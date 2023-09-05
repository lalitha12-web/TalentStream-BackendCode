package com.bitlabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bitlabs.entity.JobRecruiter;
import com.bitlabs.entity.RecruiterLogin;

import com.bitlabs.service.JobRecruiterService;

@RestController

public class JobRecruiterController {
     JobRecruiterService recruiterService;

    @Autowired
    public JobRecruiterController(JobRecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @PostMapping("/saveRecruiters")
    public ResponseEntity<String> registerRecruiter(@RequestBody JobRecruiter recruiter) {
        return recruiterService.saveRecruiter(recruiter);
    }
    
    @PostMapping("/recruiterLogin")
    public ResponseEntity<String> login(@RequestBody RecruiterLogin loginRequest) {
        boolean loginResult = recruiterService.login(loginRequest.getEmail(), loginRequest.getPassword());

        if (loginResult) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/viewRecruiters")
    public ResponseEntity<List<JobRecruiter>> getAllJobRecruiters() {
        List<JobRecruiter> jobRecruiters = recruiterService.getAllJobRecruiters();
        return ResponseEntity.ok(jobRecruiters);
    }
}
