package it.epicode.businessLayer.services.security;

import java.util.Collection;

import it.epicode.dataLayer.entities.Utenti;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class SecurityUtenteDetails implements UserDetails {
	private static final long serialVersionUID = 1L;

	// l'elenco dei ruoli dell'utente
	private Collection<? extends GrantedAuthority> authorities;
	private String password;
	private String username;
	@Builder.Default
	private boolean accountNonExpired = true;
	@Builder.Default
	private boolean accountNonLocked = true;
	@Builder.Default
	private boolean credentialsNonExpired = true;
	@Builder.Default
	private boolean enabled = true;

	public static SecurityUtenteDetails build(Utenti utenti) {
		var authorities = utenti.getRoles().stream() //
				.map(r -> new SimpleGrantedAuthority(r.getName())).toList();
		return SecurityUtenteDetails.builder() //
				.withUsername(utenti.getNomeUtente()) //
				.withPassword(utenti.getPassword()) //
				.withAuthorities(authorities) //
				.build();
	}
}

