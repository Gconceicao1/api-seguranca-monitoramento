package br.com.gconceicao.forum.service;

import java.util.Optional;

import br.com.gconceicao.forum.models.StatusTopic;
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
		if(courseName == null) {
			return TopicDto.convert(topicRepository.findAll(pagination));
		}
		else {
			return TopicDto.convert(topicRepository.findTopicByCourseName(courseName, pagination));
		}
	}

	public Topic findTopicById(Long id){
		Optional<Topic> topic = topicRepository.findById(id);
		if(topic.isPresent()){
			return  topic.get();
		}else{
			throw  new NotFoundObjectException("topic not exists");
		}
	}
	public Topic insertTopic(TopicInsertDto topicInsertDto) {
		Topic topic = convert(topicInsertDto);
		return topicRepository.saveAndFlush(topic);
	}
	
	public TopicDetailsDto topicDetails( Long id) {
			Optional<Topic> topic = topicRepository.findById(id);
			if(topic.isPresent()) {
				return new TopicDetailsDto(topic.get());
			}
			else {
				throw new NotFoundObjectException("The topic entered does not exist in the database");
			}
		
	}
	
	public TopicDetailsDto updateTopic (TopicUpdateDto topicUpdateDto, Long id) {
		TopicDetailsDto topic = topicDetails(id);
		topic.setTitle(topicUpdateDto.getTitle());
		topic.setMessage(topicUpdateDto.getMessage());
		topicRepository.save(topic.convertToTopic(topic, userForumService.findUserById(topic.getAuthor().getId())));
		return topic;
	}

	public void deleteTopic(Long id){

			Optional<Topic> topic = topicRepository.findById(id);
			if(topic.isPresent()) {
				topicRepository.delete(topic.get());
			}else {
				throw new NotFoundObjectException("fail to delete");
			}
	}
	public Topic convert(TopicInsertDto topicInsertDto) {
		Course course = courseService.findCourseByName(topicInsertDto.getCourseName());
		UserForum userForum = userForumService.getUserForumByEmail(topicInsertDto.getUserEmail());
		return new Topic(topicInsertDto.getTitle(), topicInsertDto.getMessage(), course, userForum);
	}


	public void updateStatus(long id, StatusTopic statusTopic) {
		Optional<Topic> topic = topicRepository.findById(id);
		if(topic.isPresent()){
			topic.get().setStatus(statusTopic);
			topicRepository.save(topic.get());
		}else{
			throw new NotFoundObjectException("topic not exist");
		}
	}
}
