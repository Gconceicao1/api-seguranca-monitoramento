package br.com.gconceicao.forum.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String message;
	private StatusTopic topicStatus;

	private LocalDateTime creationDate = LocalDateTime.now();
	@ManyToOne
	private UserForum author;

	@ManyToOne(fetch = FetchType.EAGER)
	private Topic topic;
	private boolean solution = false;
	
	
	public Answer(){}
	public Answer(long id, String message, StatusTopic topicStatus, LocalDateTime creationDate, UserForum author, boolean solution, Topic topic) {
		this.id = id;
		this.message = message;
		this.topicStatus = topicStatus;
		this.topic = topic;
		this.creationDate = creationDate;
		this.author = author;
		this.solution = solution;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, creationDate, id, message, solution, topicStatus);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Answer answer = (Answer) o;
		return id == answer.id
				&& solution == answer.solution
				&& message.equals(answer.message)
				&& topicStatus == answer.topicStatus
				&& creationDate.equals(answer.creationDate)
				&& author.equals(answer.author)
				&& topic.equals(answer.topic);
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
	public StatusTopic getTopicStatus() {
		return topicStatus;
	}
	public void setTopic(StatusTopic topic) {
		this.topicStatus = topic;
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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
