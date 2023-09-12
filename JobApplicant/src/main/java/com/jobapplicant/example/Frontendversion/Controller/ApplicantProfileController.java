package com.jobapplicant.example.Frontendversion.Controller;

import com.jobapplicant.example.Frontendversion.Entity.ApplicantProfile;
import com.jobapplicant.example.Frontendversion.Service.ApplicantProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/applicantprofiles")
public class ApplicantProfileController {

    private final ApplicantProfileService applicantProfileService;

    @Autowired
    public ApplicantProfileController(ApplicantProfileService applicantProfileService) {
        this.applicantProfileService = applicantProfileService;
    }

   @PostMapping("/insertdata")
    public ResponseEntity<ApplicantProfile> createOrUpdateApplicantProfile(@RequestBody ApplicantProfile applicantProfile) {
        ApplicantProfile savedProfile = applicantProfileService.createOrUpdateApplicantProfile(applicantProfile);
        return ResponseEntity.ok(savedProfile);
    }

   /* @PostMapping("/insertdata")
    public ResponseEntity<ApplicantProfile> createOrUpdateApplicantProfile(
            @ModelAttribute ApplicantProfile profile,

            @RequestParam("resume") MultipartFile resumeFile) {



        if (!resumeFile.isEmpty()) {
            try {
                byte[] resumeData = resumeFile.getBytes();
                // Process the resumeData as needed
            } catch (IOException e) {
                // Handle exception
            }
        }

        ApplicantProfile savedProfile = applicantProfileService.createOrUpdateApplicantProfile(profile);
        return ResponseEntity.ok(savedProfile);
    }*/

    @GetMapping("/{applicantId}")
    public ResponseEntity<ApplicantProfile> getApplicantProfileById(@PathVariable int applicantId) {
        ApplicantProfile applicantProfile = applicantProfileService.getApplicantProfileById(applicantId);
        if (applicantProfile != null) {
            return ResponseEntity.ok(applicantProfile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        @DeleteMapping("/{applicantId}")
        public ResponseEntity<Void> deleteApplicantProfile(@PathVariable int applicantId) {
            applicantProfileService.deleteApplicantProfile(applicantId);
            return ResponseEntity.noContent().build();
        }
}
