package br.com.gconceicao.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gconceicao.forum.models.Course;
import br.com.gconceicao.forum.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public Course findCourseByName(String courseName) {
		return courseRepository.findByName(courseName);
	}

}
