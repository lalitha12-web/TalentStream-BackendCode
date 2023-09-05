package com.jobapplicant.example.version1.Controller;

import com.jobapplicant.example.version1.Entity.ApplicantBioData;
import com.jobapplicant.example.version1.Service.ApplicantBioDataService;
import com.jobapplicant.example.version1.Service.ApplicantRegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ApplicantBioDataController {
    @Autowired
    private ApplicantRegisterService applicantRegisterService;
    @Autowired
    private ApplicantBioDataService applicantProfileService;



    @PostMapping("/update")
    public ResponseEntity<String> registerJobSeeker(@Valid @RequestBody ApplicantBioData applicantProfile) {
        applicantProfileService.registerJobSeeker(applicantProfile);
        return ResponseEntity.ok("Job seeker registered successfully.");
    }
    @GetMapping("/all")
    public List<ApplicantBioData> getAllJobSeekers()
    {
        return applicantProfileService.getAllApplicants();
    }
}
