package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Models.JobAppEntity;
import com.example.demo.Models.JobEntity;
import com.example.demo.Models.UserData;
import com.example.demo.Repositorys.JobAppRepo;
import com.example.demo.Services.JobService;
import com.example.demo.Services.LoggedDataService;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	LoggedDataService userdata;
    @Autowired
    private JobService jobservice;
    @Autowired
    private JobAppRepo jobapprepo;

    @PostMapping("/savejobs")
    public String saveJobs(@RequestBody List<JobEntity> JobsData) {
        try {
            jobservice.saveProfessionals(JobsData);
            return "Jobs data successfully saved!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to save professionals data.";
        }
    }
    
    @GetMapping("/view/all")
    public String getJobsData(Model model) {
    	List<JobEntity> allposts=jobservice.getAllPosts();
    	model.addAttribute("jobsdata", allposts);
         return "jobs";
    }
    
    
    @GetMapping("/manage/all")
    public String getManageJobs(Model model) {
    	List<JobEntity> allposts=jobservice.getAllPosts();
    	model.addAttribute("jobsdata", allposts);
         return "jobappdash";
    }
    
    
    @GetMapping("/manage/view/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAppliedJobs(@PathVariable("id") String jobid,Model model) {
    	List<JobAppEntity> applications=jobapprepo.findByJobId(jobid);
    	model.addAttribute("applist",applications);
    	return "applicationslist";
    }
    
    @GetMapping("/apply/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getJobForm(@PathVariable("id") String id,Model model) {
    	JobEntity jobdata= jobservice.getJobData(id);
    	UserData data=userdata.getLoggedInUser();
    	model.addAttribute("user",data);
    	model.addAttribute("job", jobdata);
    	return "jobform";
    	
    }
    
    @PostMapping("/jobapplied")
    public String JobApplied(@ModelAttribute JobAppEntity application,Model model){
    	model.addAttribute("app", application);
    	System.out.print(application.getId());
    	 jobapprepo.save(application);
    	 return "submitted";
    }
    
//    @GetMapping("/search")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
//    public List<JobEntity> searchJobPosts(@RequestParam("key") String keyword) {
//        return jobservice.searchJobPosts(keyword);
//    }
    
}
