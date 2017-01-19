package com.tsystems.ecrono.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.tsystems.ecrono.repository.UserRepository;

//Esta anotacion añade por defecto una configuracion por sesion
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    @Autowired
    public SecurityConfig(UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	auth.userDetailsService(new MyUserDetailService(userRepository));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable()//
		.httpBasic().and()//
		.antMatcher("/**").authorizeRequests()//
		.anyRequest().authenticated();
	// Para limitar la seguridad por roles
	// .antMatchers("/clasification/**").hasAuthority("GOOD")//
	// .anyRequest().denyAll();
    }

}
