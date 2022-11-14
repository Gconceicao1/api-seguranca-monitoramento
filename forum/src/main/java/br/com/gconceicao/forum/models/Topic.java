package br.com.gconceicao.forum.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String message;
	private LocalDateTime creationDate = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private StatusTopic status = StatusTopic.NOT_ANSWERED;
	@ManyToOne
	private UserForum user;
	@ManyToOne
	private Course course;
	@OneToMany(mappedBy = "topic")
	private List<Answer> answers = new ArrayList<>();
	
	
	@Override
	public int hashCode() {
		return Objects.hash(answers, course, creationDate, id, message, status, title, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		return Objects.equals(answers, other.answers) && Objects.equals(course, other.course)
				&& Objects.equals(creationDate, other.creationDate) && id == other.id
				&& Objects.equals(message, other.message) && status == other.status
				&& Objects.equals(title, other.title) && Objects.equals(user, other.user);
	}
	
	public Topic() {}
	
	public Topic(String title, String message, Course course, UserForum user) {
		this.title = title;
		this.message = message;
		this.course = course;
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public StatusTopic getStatus() {
		return status;
	}
	public void setStatus(StatusTopic status) {
		this.status = status;
	}
	public UserForum getUser() {
		return user;
	}
	public void setUser(UserForum user) {
		this.user = user;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	
	
}
