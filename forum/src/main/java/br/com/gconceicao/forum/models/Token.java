package br.com.gconceicao.forum.models;

public class Token {

	private String type = "Bearer";
	private String token;
	private Long expirationDate;
	
	public Token(String token, Long expirationDate) {
		
		this.token = token;
		this.expirationDate = expirationDate;
	}

	public String getToken() {
		return token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Long expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	
	
}
