package it.epicode.businessLayer.security;

import it.epicode.dataLayer.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
/* implementa l'interfaccia UserDetails di Spring Security, utilizzata per rappresentare le
informazioni di autenticazione e autorizzazione di un utente. La classe è annotata con Lombok
 per ridurre il boilerplate code.*/
public class SecurityUserDetails implements UserDetails {

    @Serial
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

    /*Questo metodo consente di trasformare un'entità UserEntity (probabilmente un'entità JPA) in
         un oggetto che può essere utilizzato da Spring Security per l'autenticazione e
         l'autorizzazione.*/
    public static SecurityUserDetails build(User user) {
        var authorities = user.getRoles().stream() //
                .map(r -> new SimpleGrantedAuthority(r.getName())).toList();
        return SecurityUserDetails.builder() //
                .withUsername(user.getUsername()) //
                .withPassword(user.getPassword()) //
                .withAuthorities(authorities) //
                .build();
    }
}