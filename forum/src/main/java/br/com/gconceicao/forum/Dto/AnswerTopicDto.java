package br.com.gconceicao.forum.Dto;

import java.time.LocalDateTime;

import br.com.gconceicao.forum.models.Answer;

public class AnswerTopicDto {
	private Long id;
	private String message;
	private LocalDateTime creationDate;
	private String author;
	
	public AnswerTopicDto(Answer answer) {
		this.id = answer.getId();
		this.message = answer.getMessage();
		this.creationDate = answer.getCreationDate();
		this.author = answer.getAuthor().getName();
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public String getAuthor() {
		return author;
	}
	
}
