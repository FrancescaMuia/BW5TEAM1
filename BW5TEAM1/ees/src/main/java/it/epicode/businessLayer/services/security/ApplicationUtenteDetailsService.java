package it.epicode.businessLayer.services.security;

import it.epicode.dataLayer.repositories.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


// Servizio di recupero di un utente tramite le procedure di gestione utente di Spring Security
@Service
public class ApplicationUtenteDetailsService implements UserDetailsService {

	@Autowired
	UtentiRepository utenti;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = utenti.findOneByUsername(username).orElseThrow();
		var applicationUser = SecurityUtenteDetails.build(user);
		return applicationUser;
	}

}
