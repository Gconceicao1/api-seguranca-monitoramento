package br.com.gconceicao.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gconceicao.forum.models.UserForum;

public interface UserForumRepository extends JpaRepository<UserForum, Long>{

	UserForum findUserForumByEmail(String userForumEmail);

}
