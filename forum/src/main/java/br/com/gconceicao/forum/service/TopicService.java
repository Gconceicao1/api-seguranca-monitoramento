package br.com.gconceicao.forum.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gconceicao.forum.Dto.TopicDetailsDto;
import br.com.gconceicao.forum.Dto.TopicDto;
import br.com.gconceicao.forum.Dto.TopicInsertDto;
import br.com.gconceicao.forum.Dto.TopicUpdateDto;
import br.com.gconceicao.forum.config.validation.exceptions.NotFoundObjectException;
import br.com.gconceicao.forum.models.Course;
import br.com.gconceicao.forum.models.Topic;
import br.com.gconceicao.forum.models.UserForum;
import br.com.gconceicao.forum.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired 
	TopicRepository topicRepository;
	@Autowired 
	CourseService courseService;
	@Autowired
	UserForumService userForumService;
	
	public Page<TopicDto> listTopics(String courseName,  Pageable pagination){
		Page<Topic> listTopic;
		
		if(courseName == null) {		
			listTopic = topicRepository.findAll(pagination);
			return TopicDto.convert(listTopic);
		}
		else {
			listTopic = topicRepository.findTopicByCourseName(courseName, pagination);
			return TopicDto.convert(listTopic);
		}
	}
	public Topic insertTopic(TopicInsertDto topicInsertDto) {
		Topic topic = convert(topicInsertDto);
		return topicRepository.saveAndFlush(topic);
	}
	
	public TopicDetailsDto topicDetails( Long id) {
		try {
			Optional<Topic> topic = topicRepository.findById(id);
			return new TopicDetailsDto(topic.get());
		}catch (Exception e) {
			throw new NotFoundObjectException("The topic entered does not exist in the database");
		}
		
	}
	
	public TopicDetailsDto updateTopic (TopicUpdateDto topicUpdateDto, Long id) {
		TopicDetailsDto topic = topicDetails(id);
		topic.setTitle(topicUpdateDto.getTitle());
		topic.setMessage(topicUpdateDto.getMessage());
		return topic;
	}
	
	public Topic convert(TopicInsertDto topicInsertDto) {
		Course course = courseService.findCourseByName(topicInsertDto.getCourseName());
		UserForum userForum = userForumService.getUserForumByEmail(topicInsertDto.getUserEmail());
		return new Topic(topicInsertDto.getTitle(), topicInsertDto.getMessage(), course, userForum);
	}

}
