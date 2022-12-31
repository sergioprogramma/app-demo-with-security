package com.app.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class CustomSecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Autowired
	private DataSource securityDataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}
 
	@Override
       protected void configure(HttpSecurity http) throws Exception {
    	   http.csrf().disable()
    	   .authorizeRequests()
	    	.antMatchers("/").authenticated()
	   		.antMatchers("/employees/**").hasRole("ADMIN")
	   		.antMatchers("/suppliers/**").hasRole("ADMIN")
	   		.antMatchers("/owners/**").hasRole("ADMIN")
	   		.antMatchers("/home-owner/**").hasRole("OWNER")
	   		.antMatchers("/home-supplier/**").hasRole("SUPPLIER")
	   		.and()
	   		.formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/login")
	        .and()
	   		.logout()
	   		.logoutSuccessUrl("/showMyLoginPage").deleteCookies("JSESSIONID")
	   		.invalidateHttpSession(true) 
	   		.permitAll()
	   		.and()
	   		.exceptionHandling().accessDeniedPage("/access-denied");
       }
   
}
