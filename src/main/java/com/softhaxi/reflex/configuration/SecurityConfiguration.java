package com.softhaxi.reflex.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ivohutasoit
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
	protected void configure(HttpSecurity http) throws Exception {
        http
			.authorizeRequests()
				.antMatchers("/", "/register", "/webjars/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/signin")
				.permitAll()
				.and()
            .logout()
                .logoutUrl("/signout")
				.permitAll();
	}
}