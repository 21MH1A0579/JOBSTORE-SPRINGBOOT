package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Models.UserData;
import com.example.demo.Repositorys.UserDataRepo;

public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	UserDataRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserData> userinfo=repo.findByEmail(username);
		return userinfo.map(UserInfoDetails::new)
				.orElseThrow(()->new UsernameNotFoundException("USER NOT FOUND"+username)); 
	}

}
