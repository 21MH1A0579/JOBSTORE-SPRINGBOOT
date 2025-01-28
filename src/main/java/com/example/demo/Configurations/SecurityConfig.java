package com.example.demo.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.Services.UserInfoUserDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/home").permitAll()
	            .requestMatchers("/register").permitAll()
	            .requestMatchers("/user/register").permitAll()
	            .requestMatchers("/jobs/savejobs").permitAll()
	            .requestMatchers("/jobs/manage/view/**").authenticated()
	            .requestMatchers("/jobs/apply/**").authenticated()
	            .requestMatchers("/jobs/view/all").permitAll()
	            .requestMatchers("/jobs/**").authenticated()
	            .requestMatchers("/user/**").authenticated()
	        )
	        .formLogin(form -> form
	            .loginPage("/login") 
	            .permitAll()
	            .defaultSuccessUrl("/user/homepage")
	        )
	        .logout(logout -> logout
	            .logoutUrl("/logout")
	            .logoutSuccessUrl("/")
	            .permitAll()
	        );
	    return http.build();
	}


	
	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public UserDetailsService userdetailsservice() {
		return new UserInfoUserDetailsService();
		
	}
	
	@Bean
	public AuthenticationProvider authenticationprovider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userdetailsservice());
		provider.setPasswordEncoder(passwordencoder());
		return provider;
	}
	
	
	

}
