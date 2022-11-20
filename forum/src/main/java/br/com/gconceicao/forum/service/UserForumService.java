package br.com.gconceicao.forum.service;

import br.com.gconceicao.forum.config.validation.exceptions.NotFoundObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gconceicao.forum.models.UserForum;
import br.com.gconceicao.forum.repository.UserForumRepository;

import java.util.Optional;

@Service
public class UserForumService {

	@Autowired
	UserForumRepository userForumRepository;
	
	public UserForum getUserForumByEmail(String userForumEmail) {
			return userForumRepository.findUserForumByEmail(userForumEmail);
	}

	public UserForum findUserById(Long userId) {
		Optional<UserForum> user = userForumRepository.findById(userId);
		if(user.isPresent()){
			return user.get();
		}
		else{
			throw new NotFoundObjectException("User not exist");
		}
	}
	
	
}
