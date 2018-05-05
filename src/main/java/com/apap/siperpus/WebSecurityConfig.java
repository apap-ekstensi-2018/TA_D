package com.apap.siperpus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String ROLE_STAFF = "STAF";
	private static final String ROLE_MAHASISWA = "mahasiswa";
	private static final String ROLE_DOSEN = "dosen";
	
	@Autowired
	DataSource dataSource;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/","/resources/**").permitAll()
		.antMatchers("/literatur/tambah").hasRole(ROLE_STAFF)
		.antMatchers("/**").hasAnyRole(ROLE_DOSEN, ROLE_MAHASISWA)
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.and()
		.logout().permitAll();
	}
	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"select username, password, 1 from user_account " +
								"where username=?")
				.authoritiesByUsernameQuery(
						"select username, role from user_account " +
								"where username=?");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/bootstrap/**")
				.antMatchers("/css/**")
				.antMatchers("/dist/**")
				.antMatchers("/plugins/**");
	}
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("admin")
		.password("admin")
		.roles("ADMIN");
	}*/

	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
