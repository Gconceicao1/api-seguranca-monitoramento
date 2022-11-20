package br.com.gconceicao.forum.Dto;

import br.com.gconceicao.forum.models.Answer;
import br.com.gconceicao.forum.models.Topic;
import br.com.gconceicao.forum.models.UserForum;
import org.h2.engine.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AnswerInsertDto {
    @NotNull(message = "cannot be null")
    @NotEmpty(message = "cannot be empty")
    private String message;

    @NotNull(message = "cannot be null")
    private Long authorId;

    @NotNull(message = "cannot be null")
    private Long topicId;

    public AnswerInsertDto(String message, Long authorId, Long topicId) {
        this.message = message;
        this.authorId = authorId;
        this.topicId = topicId;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }
}
