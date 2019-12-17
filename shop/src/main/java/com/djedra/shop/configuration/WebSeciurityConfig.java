package com.djedra.shop.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.djedra.shop.jwt.filter.JWTFilter;

@Configuration
public class WebSeciurityConfig extends WebSecurityConfigurerAdapter {

//	/storage wymaga roli admin
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/articleCategory").authenticated()
		.antMatchers("/storage").hasRole("admin")
		.and().addFilter(new JWTFilter(authenticationManager()));
	}
}
