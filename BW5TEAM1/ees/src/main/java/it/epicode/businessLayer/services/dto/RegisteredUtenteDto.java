package it.epicode.businessLayer.services.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class RegisteredUtenteDto {
	private long id;
	private String nomeUtente;
	private String email;
	private String roles;



	@Builder(setterPrefix = "with")
	public RegisteredUtenteDto(long id, String nomeUtente, String email, String roles) {
		this.id = id;
		this.nomeUtente = nomeUtente;
		this.email = email;
		this.roles = roles;
	}
}
