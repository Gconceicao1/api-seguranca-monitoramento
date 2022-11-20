package br.com.gconceicao.forum.repository;

import br.com.gconceicao.forum.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository <Answer, Long> {

}
