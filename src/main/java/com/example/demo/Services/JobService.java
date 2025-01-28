package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.JobEntity;
import com.example.demo.Repositorys.JobRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo jobrepo;

    public void saveProfessionals(List<JobEntity> professionalsData) {
        
       for(JobEntity data:professionalsData) {
    	   JobEntity newdata=new JobEntity();
    	   newdata.setDescription(data.getDescription());
    	   newdata.setExperience(data.getExperience());
    	   newdata.setProfile(data.getProfile());
    	   newdata.setTechs(data.getTechs());
    	   jobrepo.save(newdata);
       }
    }
    
    public JobEntity getJobData(String id) {
    	Optional<JobEntity> jobdata=jobrepo.findById(id);
    	if(jobdata.isPresent())
    	{
    		return jobdata.get();
    	}
    	return null;
    }
    
    public List<JobEntity> getAllPosts(){
    	return jobrepo.findAll();
    }

}
