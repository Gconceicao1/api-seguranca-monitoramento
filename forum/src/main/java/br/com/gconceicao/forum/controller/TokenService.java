package br.com.gconceicao.forum.controller;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

import br.com.gconceicao.forum.models.Token;
import br.com.gconceicao.forum.models.UserForum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${forum.jwt.expiration}")
	private Long expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;
	
	public Token generatedToken(Authentication authenticate) {
		UserForum  LoggedUser =  (UserForum) authenticate.getPrincipal();
		Date now = new Date();
		Date expirationDate = new Date(now.getTime() + expiration);
		
		String Token = Jwts.builder()
				.setIssuer("gconceicao.api.java.forum")
				.setSubject(Long.toString(LoggedUser.getId()))
				.setIssuedAt(now)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact()
				;
		
		return new Token(Token, expirationDate.getTime());
	}
	

	public boolean isValidtoken(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		}catch (Exception e) {
			return false;
		}
	}


	public Long getUserId(String token) {
		Jws<Claims> parseClaimsJws = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
		return Long.parseLong(parseClaimsJws.getBody().getSubject()) ;
	}

}
