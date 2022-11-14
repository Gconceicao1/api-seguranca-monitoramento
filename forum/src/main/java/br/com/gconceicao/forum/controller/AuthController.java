package br.com.gconceicao.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gconceicao.forum.Dto.LoginDto;
import br.com.gconceicao.forum.config.validation.exceptions.AuthException;
import br.com.gconceicao.forum.models.Token;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@RequestMapping
	public ResponseEntity<Token> authetication (@RequestBody @Valid LoginDto loginDto){
		UsernamePasswordAuthenticationToken logininfo = loginDto.generateLoginInfo();
		
		try {
			Authentication authenticate = authenticationManager.authenticate(logininfo);
			Token token = tokenService.generatedToken(authenticate);
			return ResponseEntity.ok(token);
			
		}catch (Exception e) {
			throw new AuthException("email or password incorrect");
		}
	}
}
