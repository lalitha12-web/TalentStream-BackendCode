package com.bitlabs.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.bitlabs.entity.JobRecruiter;
import com.bitlabs.entity.User;
import com.bitlabs.repo.JobRecruiterRepository;

@Service
public class JobRecruiterService {
  JobRecruiterRepository recruiterRepository;

    @Autowired
    public JobRecruiterService(JobRecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    public ResponseEntity<String> saveRecruiter(JobRecruiter recruiter) {
        // Check if the email already exists in the database
        if (recruiterRepository.existsByEmail(recruiter.getEmail())) {
            return ResponseEntity.badRequest().body("Email already registered");
        }

        // Save the recruiter if the email is not already registered
        recruiterRepository.save(recruiter);
        return ResponseEntity.ok("Recruiter registered successfully");
    }
    public boolean login(String email, String password) {
        JobRecruiter recruiter = recruiterRepository.findByEmail(email);

        if (recruiter != null && recruiter.getPassword().equals(password)) {
            return true; // Login successful
        } else {
            return false; // Login failed
        }
    }
    public JobRecruiter findById(Long id) {
       return recruiterRepository.findByrecruiterId(id);
        
    }
    public List<JobRecruiter> getAllJobRecruiters() {
        return recruiterRepository.findAll();
    }
    public void updatePassword(String userEmail, String newPassword) {
        JobRecruiter jobRecruiter = recruiterRepository.findByEmail(userEmail);
        if (jobRecruiter != null) {
            jobRecruiter.setPassword(newPassword);
            recruiterRepository.save(jobRecruiter);
        } else {
            throw new EntityNotFoundException("JobRecruiter not found for email: " + userEmail);
        }
    }

	public JobRecruiter findByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return recruiterRepository.findByEmail(userEmail);
	}
	
	 public JobRecruiter loadUserByEmail(String s) throws UsernameNotFoundException {
	        
		 JobRecruiter jobRecruiter =recruiterRepository.findByEmail(s);
	    	
	    	
	    	//ArrayList al=new ArrayList();
	    	//al.add(users.getFull_name());
	    	
	    	
	    	return new JobRecruiter(jobRecruiter.getEmail(), jobRecruiter.getPassword(),Arrays.stream(jobRecruiter.getRole().split(","))
					.map(SimpleGrantedAuthority::new)
					.collect(Collectors.toList()));
	    }
	

}
    

    // You can add more methods here for updating, deleting, finding recruiters, etc.

	
