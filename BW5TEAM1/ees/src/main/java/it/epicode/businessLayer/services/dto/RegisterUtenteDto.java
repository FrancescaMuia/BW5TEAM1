package it.epicode.businessLayer.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Builder(setterPrefix = "with")
@AllArgsConstructor
public class RegisterUtenteDto extends DtoBase {
	private long id;
	private String nomeUtente;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String roles;
}
