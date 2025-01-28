package com.example.demo.Repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Models.UserData;

public interface UserDataRepo extends JpaRepository<UserData, String> {
	Optional<UserData> findByEmail(String username);
}
