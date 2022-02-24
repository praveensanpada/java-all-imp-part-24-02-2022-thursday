package com.example.demo.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.CustomAuthorDetailService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthorDetailService customAuthorDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.authorizeHttpRequests()
			.antMatchers("/", "/index")
			.permitAll()
			.antMatchers("/css/**", "/js/**", "/images/**")
			.permitAll()
			.antMatchers("/author/login", "/author/register", "/author/addAuthor")
			.permitAll()
			.antMatchers("/author/**")
			.hasRole("AUTHOR")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.usernameParameter("email")
			.loginPage("/author/login")
			.loginProcessingUrl("/author/doLogin")
			.defaultSuccessUrl("/author/dashboard")
			.and()
			.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/author/logout"))
			.logoutSuccessUrl("/author/login");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * auth .inMemoryAuthentication() .withUser("praveen") .password(this
		 * .passwordEncoder() .encode("praveen@123")) .roles("AUTHOR");
		 */

		auth
			.userDetailsService(customAuthorDetailService)
			.passwordEncoder(this
				.passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	   public ModelMapper modelMapper() {
	      ModelMapper modelMapper = new ModelMapper();
	      return modelMapper;
	   }
}
