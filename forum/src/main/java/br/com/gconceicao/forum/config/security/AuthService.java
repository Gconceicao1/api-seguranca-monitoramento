package br.com.gconceicao.forum.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gconceicao.forum.models.UserForum;
import br.com.gconceicao.forum.repository.UserForumRepository;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	UserForumRepository userForumRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserForum  user = userForumRepository.findUserForumByEmail(username);
		
		if(user != null) {
			return user;
		}else {
			throw new UsernameNotFoundException("error");
		}
	}

}
