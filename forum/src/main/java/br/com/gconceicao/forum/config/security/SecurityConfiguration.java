package br.com.gconceicao.forum.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.gconceicao.forum.controller.TokenService;
import br.com.gconceicao.forum.service.UserForumService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AuthService authService;
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	UserForumService userForumService;
	
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	protected void configure (HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().
		antMatchers(HttpMethod.GET, "/topic").permitAll()
		.antMatchers(HttpMethod.GET, "/topic/*").permitAll()
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore( new TokenAuthFilter(tokenService,userForumService) , UsernamePasswordAuthenticationFilter.class);
	}
	
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.userDetailsService(authService).passwordEncoder(new BCryptPasswordEncoder());
	  }
	
}
