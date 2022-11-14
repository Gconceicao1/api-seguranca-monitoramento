package br.com.gconceicao.forum.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginDto {
	
	@NotNull(message = "cannot be null")
	@NotEmpty(message = "cannot be empty")
	private String email;
	@NotNull(message = "cannot be null")
	@NotEmpty(message = "cannot be empty")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UsernamePasswordAuthenticationToken generateLoginInfo() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}
	
	

}
