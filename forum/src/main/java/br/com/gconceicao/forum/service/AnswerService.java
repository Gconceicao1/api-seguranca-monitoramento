package br.com.gconceicao.forum.service;

import br.com.gconceicao.forum.Dto.AnswerDto;
import br.com.gconceicao.forum.Dto.AnswerInsertDto;
import br.com.gconceicao.forum.models.Answer;
import br.com.gconceicao.forum.models.StatusTopic;
import br.com.gconceicao.forum.models.Topic;
import br.com.gconceicao.forum.models.UserForum;
import br.com.gconceicao.forum.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    UserForumService userForumService;

    @Autowired
    TopicService topicService;

    public AnswerDto insertAnswer(AnswerInsertDto answerInsertDto){
        UserForum userForum = userForumService.findUserById(answerInsertDto.getAuthorId());
        Topic topic = topicService.findTopicById(answerInsertDto.getTopicId());
        Answer answer = answerRepository.saveAndFlush(toAnswer(answerInsertDto,userForum,topic));
        if(answer.getTopic().getStatus().equals(StatusTopic.NOT_ANSWERED)) {
            topicService.updateStatus(answer.getTopic().getId(), StatusTopic.NOT_SOLVED);
        }
        return new AnswerDto(answer);
    }

    public Answer toAnswer(AnswerInsertDto answerInsertDto, UserForum author, Topic topic){
        Answer answer = new Answer();
        answer.setAuthor(author);
        answer.setMessage(answerInsertDto.getMessage());
        answer.setTopic(topic);
        return answer;
    }
}

