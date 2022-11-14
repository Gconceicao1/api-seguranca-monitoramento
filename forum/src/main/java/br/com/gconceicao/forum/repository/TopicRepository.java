package br.com.gconceicao.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gconceicao.forum.models.Topic;

public interface TopicRepository  extends JpaRepository<Topic, Long>{

	Page<Topic> findTopicByCourseName(String courseName, Pageable pagination);

}
