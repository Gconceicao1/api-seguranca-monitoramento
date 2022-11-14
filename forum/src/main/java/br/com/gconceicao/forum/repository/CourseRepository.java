package br.com.gconceicao.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gconceicao.forum.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	Course findByName(String courseName);
	
}
