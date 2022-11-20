package br.com.gconceicao.forum.Dto;

import br.com.gconceicao.forum.models.Course;
import br.com.gconceicao.forum.models.StatusTopic;
import br.com.gconceicao.forum.models.Topic;
import br.com.gconceicao.forum.models.UserForum;
import org.h2.engine.User;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopicDetailsDto {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime creationDate;
	@ManyToOne()
	private UserForumDto author;
	@ManyToOne()
	private Course course;
	private StatusTopic status;
	private List<AnswerTopicDto> answers;	
	
	public TopicDetailsDto(Topic topic) {
		this.id = topic.getId();
		this.title= topic.getTitle();
		this.message = topic.getMessage();
		this.creationDate = topic.getCreationDate();
		this.course = topic.getCourse();
		this.status = topic.getStatus();
		this.author = new UserForumDto(topic.getUser().getId(), topic.getUser().getName());
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

	public UserForumDto getAuthor() {
		return author;
	}

	public void setAuthor(UserForumDto author) {
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Topic convertToTopic(TopicDetailsDto topicDetailsDto, UserForum user){
		//String title, String message, Course course, UserForum user
		Topic topic = new Topic(topicDetailsDto.getTitle(), topicDetailsDto.getMessage(), topicDetailsDto.getCourse(), user);
		topic.setId(topicDetailsDto.getId()) ;
		return topic;
	}
	
}
