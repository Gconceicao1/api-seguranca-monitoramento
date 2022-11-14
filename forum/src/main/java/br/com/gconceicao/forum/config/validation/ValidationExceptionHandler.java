package br.com.gconceicao.forum.config.validation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.gconceicao.forum.Dto.ErrorValidationDto;
import br.com.gconceicao.forum.config.validation.exceptions.AuthException;
import br.com.gconceicao.forum.config.validation.exceptions.NotFoundObjectException;
import br.com.gconceicao.forum.config.validation.exceptions.StandardError;

@RestControllerAdvice
public class ValidationExceptionHandler {
	
	@Autowired
	private MessageSource messageSourece;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorValidationDto> handle(MethodArgumentNotValidException exception) {
		
		List<ErrorValidationDto> errorValidationDto = new  ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(e ->{
			String message = messageSourece.getMessage(e, LocaleContextHolder.getLocale());
			ErrorValidationDto error = new ErrorValidationDto(e.getField(), message);
			errorValidationDto.add(error);
		});
		
		return errorValidationDto;
	}
	
	@ExceptionHandler(NotFoundObjectException.class)
	public ResponseEntity<StandardError> objectNotFound(NotFoundObjectException e, HttpServletRequest httpServletRequest){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(PropertyReferenceException.class)
	public ResponseEntity<StandardError> propePropertyReferenceException (PropertyReferenceException e, HttpServletRequest httpServletRequest){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(AuthException.class)
	public ResponseEntity<StandardError> authException (AuthException e, HttpServletRequest httpServletRequest){
		StandardError err = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}
}
