package com.example.demo.Repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Models.JobAppEntity;

public interface JobAppRepo extends JpaRepository<JobAppEntity, String> {
	
	@Query(value = "SELECT * FROM job_app_table WHERE job_id = :jobId order by final_score desc", nativeQuery = true)
    List<JobAppEntity> findByJobId(@Param("jobId") String jobId);
}
