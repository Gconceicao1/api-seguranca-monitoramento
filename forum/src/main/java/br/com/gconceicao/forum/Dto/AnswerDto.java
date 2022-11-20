package br.com.gconceicao.forum.Dto;

import br.com.gconceicao.forum.models.Answer;

import java.time.LocalDateTime;

public class AnswerDto {
    private Long id;
    private String message;
    private LocalDateTime creationDate;

    public AnswerDto(Long id, String message, LocalDateTime creationDate) {
        this.id = id;
        this.message = message;
        this.creationDate = creationDate;
    }

    public AnswerDto(Answer answer){
        this.id = answer.getId();
        this.message = answer.getMessage();
        this.creationDate = answer.getCreationDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
