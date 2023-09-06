package com.bitlabs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitlabs.entity.Eligibility;
import com.bitlabs.entity.Job;
import com.bitlabs.entity.JobRecruiter;
import com.bitlabs.service.EligibilityService;
import com.bitlabs.service.JobRecruiterService;
import com.bitlabs.service.JobService;

@RestController

public class JobController {
    private final JobService jobService;
    private final EligibilityService eligibilityService;
    JobRecruiterService recruiterService;

    @Autowired
    public JobController(JobService jobService, EligibilityService eligibilityService,JobRecruiterService recruiterService) {
        this.jobService = jobService;
        this.eligibilityService = eligibilityService;
        this.recruiterService=recruiterService;
    }

    @PostMapping("/saveJob")
    public ResponseEntity<String> saveJob(@RequestBody @Valid Job job) {
        Long jobRecruiterId = job.getRecruiter().getRecruiterId(); // Assuming you have a getter for id in JobRecruiter
        JobRecruiter jobRecruiter = recruiterService.findById(jobRecruiterId);
        // Fetch JobRecruiter by ID
        if(jobRecruiter!=null) {
        job.setRecruiter(jobRecruiter); 
        Eligibility eligibility = job.getEligibility();
        eligibilityService.saveEligibility(eligibility); // Save eligibility first
        job.setEligibility(eligibility); // Associate eligibility with the job
        Job savedJob = jobService.saveJob(job);
        return ResponseEntity.ok("Job saved successfully with ID: " + savedJob.getId());
        }
        else {
        	 return ResponseEntity.badRequest().body("Recruiter is not registered.");
        }
    }
    
    @GetMapping("/viewJobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    // Other endpoints and methods...
}
