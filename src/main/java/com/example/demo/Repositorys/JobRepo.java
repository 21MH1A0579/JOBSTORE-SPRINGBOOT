package com.example.demo.Repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Models.JobEntity;

public interface JobRepo extends JpaRepository<JobEntity, String> {
//	 @Query("SELECT p FROM JobEntity p WHERE " +
//	           "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//	           "CAST(p.experience AS string) LIKE CONCAT('%', :keyword, '%') OR " +
//	           "LOWER(p.profile) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//	           "LOWER(p.techs) LIKE LOWER(CONCAT('%', :keyword, '%'))")
//	    List<JobEntity> searchAcrossAllFields(@Param("keyword") String keyword);
}
