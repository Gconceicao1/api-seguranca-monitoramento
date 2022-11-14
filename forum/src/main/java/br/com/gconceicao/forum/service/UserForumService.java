package br.com.gconceicao.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gconceicao.forum.models.UserForum;
import br.com.gconceicao.forum.repository.UserForumRepository;

@Service
public class UserForumService {

	@Autowired
	UserForumRepository userForumRepository;
	
	public UserForum getUserForumByEmail(String userForumEmail) {
			return userForumRepository.findUserForumByEmail(userForumEmail);
	}

	public UserForum findUserById(Long userId) {
		return userForumRepository.findById(userId).get();
	}
	
	
}
