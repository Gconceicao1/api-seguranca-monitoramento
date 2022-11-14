package br.com.gconceicao.forum.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class TopicInsertDto {

	@NotNull(message = "cannot be null")
	@NotEmpty(message = "cannot be empty")
	@Length(min = 3, max = 255, message = "invalid size min:3, max:255")
	private String title;
	
	@NotNull(message = "cannot be null")
	@NotEmpty(message = "cannot be empty")
	@Length(min = 3, max = 255, message = "invalid size min:3, max:255")
	private String message;
	
	@NotNull(message = "cannot be null")
	@NotEmpty(message = "cannot be empty")
	@Length(min = 3, max = 255, message = "invalid size min:3, max:255")
	private String courseName;
	
	@NotNull(message = "cannot be null")
	@NotEmpty(message = "cannot be empty")
	@Length(min = 3, max = 255, message = "invalid size min:3, max:255")
	private String userEmail;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
