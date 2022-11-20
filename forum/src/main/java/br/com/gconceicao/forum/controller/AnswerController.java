package br.com.gconceicao.forum.controller;

import br.com.gconceicao.forum.Dto.AnswerDto;
import br.com.gconceicao.forum.Dto.AnswerInsertDto;
import br.com.gconceicao.forum.service.AnswerService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping
    public ResponseEntity<AnswerDto> insertAnswer(@RequestBody @Valid AnswerInsertDto answerInsertDto, UriComponentsBuilder uriComponentsBuilder){
        AnswerDto answerDto = answerService.insertAnswer(answerInsertDto);
        URI uri = uriComponentsBuilder.path("/topic/{id}").build(answerDto.getId());
        return  ResponseEntity.created(uri).body(answerDto);
    }
}
