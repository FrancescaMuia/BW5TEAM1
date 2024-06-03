package it.epicode.businessLayer.services.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class LoginResponseDto {
	private long id;
	private String nomeUtente;
	private String email;
	private String token;
	private String roles;

	@Builder(setterPrefix = "with")
	public LoginResponseDto(long id, String nomeUtente, String email, String token, String roles) {
		this.id = id;
		this.nomeUtente = nomeUtente;
		this.email = email;
		this.token = token;
		this.roles = roles;
	}
}
