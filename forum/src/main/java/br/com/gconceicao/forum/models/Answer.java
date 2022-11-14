package br.com.gconceicao.forum.models;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String message;
	private StatusTopic topic;
	private LocalDateTime creationDate = LocalDateTime.now();
	@ManyToOne
	private UserForum author;
	private boolean solution = false;
	
	
	public Answer(){}
	public Answer(long id, String message, StatusTopic topic, LocalDateTime creationDate, UserForum author, boolean solution) {
		this.id = id;
		this.message = message;
		this.topic = topic;
		this.creationDate = creationDate;
		this.author = author;
		this.solution = solution;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, creationDate, id, message, solution, topic);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		return Objects.equals(author, other.author) && Objects.equals(creationDate, other.creationDate)
				&& id == other.id && Objects.equals(message, other.message) && solution == other.solution
				&& topic == other.topic;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public StatusTopic getTopic() {
		return topic;
	}
	public void setTopic(StatusTopic topic) {
		this.topic = topic;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public UserForum getAuthor() {
		return author;
	}
	public void setAuthor(UserForum author) {
		this.author = author;
	}
	public boolean isSolution() {
		return solution;
	}
	public void setSolution(boolean solution) {
		this.solution = solution;
	}
	
	
	
	
}
