package br.com.gconceicao.forum.Dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gconceicao.forum.models.StatusTopic;
import br.com.gconceicao.forum.models.Topic;

public class TopicDetailsDto {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime creationDate;
	private String author;
	private StatusTopic status;
	private List<AnswerTopicDto> answers;	
	
	public TopicDetailsDto(Topic topic) {
		this.id = topic.getId();
		this.title= topic.getTitle();
		this.message = topic.getMessage();
		this.creationDate = topic.getCreationDate();
		this.status = topic.getStatus();
		this.author = topic.getUser().getName();
		this.answers = new ArrayList<>();
		this.answers.addAll(topic.getAnswers().stream().map(AnswerTopicDto :: new).collect(Collectors.toList()));
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public StatusTopic getStatus() {
		return status;
	}

	public void setStatus(StatusTopic status) {
		this.status = status;
	}

	public List<AnswerTopicDto> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerTopicDto> answers) {
		this.answers = answers;
	}
	
	
}
