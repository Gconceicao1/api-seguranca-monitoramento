package br.com.gconceicao.forum.config.validation.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer statusCode;
	private String message;
	private LocalDateTime dateError;
	
	
	
	public StandardError(Integer statusCode, String message, LocalDateTime dateError) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.dateError = dateError;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateError() {
		return dateError;
	}
	public void setDateError(LocalDateTime dateError) {
		this.dateError = dateError;
	}
	
}
