package br.com.gconceicao.forum.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.gconceicao.forum.controller.TokenService;
import br.com.gconceicao.forum.models.UserForum;
import br.com.gconceicao.forum.service.UserForumService;

public class TokenAuthFilter extends OncePerRequestFilter{
	
	private TokenService tokenService;
	
	private UserForumService userForumService;
	
	public TokenAuthFilter(TokenService tokenService, UserForumService userForumService) {
		this.tokenService = tokenService;
		this.userForumService = userForumService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = retriveToken(request);
		boolean tokenValid = tokenService.isValidtoken(token);
		
		if(tokenValid) {
			authClient(token);
		}
		
		filterChain.doFilter(request, response);
	}

	private void authClient(String token) {
		Long userId = tokenService.getUserId(token);
		UserForum user = userForumService.findUserById(userId);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String retriveToken(HttpServletRequest request) {
		String token  = request.getHeader("Authorization");
		if(token == null|| token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7, token.length());
	}

}
