package br.com.gconceicao.forum.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gconceicao.forum.Dto.TopicDetailsDto;
import br.com.gconceicao.forum.Dto.TopicDto;
import br.com.gconceicao.forum.Dto.TopicInsertDto;
import br.com.gconceicao.forum.Dto.TopicUpdateDto;
import br.com.gconceicao.forum.models.Topic;
import br.com.gconceicao.forum.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@Cacheable(value = "listTopic")
	@GetMapping
	public Page<TopicDto> list(
			@RequestParam(required = false) String courseName,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC)Pageable pagination){
		
		return topicService.listTopics(courseName, pagination);
	}
	
	@PostMapping
	@CacheEvict(value ="listTopic", allEntries = true)
	public ResponseEntity<TopicDto> insertTopic(@RequestBody @Valid TopicInsertDto topicInsertDto, UriComponentsBuilder uriComponentsBuilder){
		Topic topic = topicService.insertTopic(topicInsertDto);
		URI uri = uriComponentsBuilder.path("/topic/{id}").build(topic.getId());
		return ResponseEntity.created(uri).body(new TopicDto(topic));
	}
	
	@GetMapping(value="/{id}")
	public TopicDetailsDto topicDetails(@PathVariable Long id){
		return topicService.topicDetails(id);
	}
	
	@PutMapping(value="/{id}")
	@CacheEvict(value ="listTopic", allEntries = true)
	public ResponseEntity<TopicDetailsDto> updateTopic(@PathVariable Long id, @RequestBody TopicUpdateDto topicUpdateDto ){
		TopicDetailsDto topicDetailsDto =  topicService.updateTopic(topicUpdateDto, id);
		return ResponseEntity.ok(topicDetailsDto);
	}
}
