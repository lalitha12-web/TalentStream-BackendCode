package com.bitlabs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bitlabs.entity.Profile;
import com.bitlabs.service.ProfileService;

@RestController
public class ProfileController {
	private  ProfileService profileService;

	public ProfileController(ProfileService profileService) {
		this.profileService = profileService;
	}
	  @PostMapping("/addProfile")
	    public ResponseEntity<Profile> createProfile(@ModelAttribute Profile profile,
	                                                       @RequestParam("resume") MultipartFile resume) {
	        if (resume.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	        }

	        try {
	            profile.setResume(resume);
	            Profile savedProfile = profileService.saveProfile(profile);
	            return ResponseEntity.ok(savedProfile);
	        } catch (Exception e) {
	            // Handle any exception occurred while saving the profile
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    }
	
	
}
