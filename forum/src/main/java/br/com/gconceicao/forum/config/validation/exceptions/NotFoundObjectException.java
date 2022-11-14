package br.com.gconceicao.forum.config.validation.exceptions;

public class NotFoundObjectException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NotFoundObjectException( String message) {
		super(message);
	}
	
}

