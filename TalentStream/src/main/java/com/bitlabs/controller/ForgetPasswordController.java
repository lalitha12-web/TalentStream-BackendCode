package com.bitlabs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitlabs.entity.JobRecruiter;
import com.bitlabs.entity.NewPasswordRequest;
import com.bitlabs.entity.OtpVerificationRequest;
import com.bitlabs.entity.ResetPasswordRequest;
import com.bitlabs.service.EmailService;
import com.bitlabs.service.JobRecruiterService;
import com.bitlabs.service.OtpService;

@RestController
public class ForgetPasswordController {
	@Autowired
    private OtpService otpService;

    @Autowired
    private JobRecruiterService jobRecruiterService; // Your service for JobRecruiter

    @Autowired
    private EmailService emailService; // Your email service
    
   
 // A boolean flag to track if OTP is verified
    private Map<String, Boolean> otpVerificationMap = new HashMap<>();
    
    //private Map<String, String> tempEmailStorage = new HashMap<>();
    
    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestBody ResetPasswordRequest request) {
        String userEmail = request.getEmail();
        JobRecruiter jobRecruiter = jobRecruiterService.findByEmail(userEmail);
        
        if (jobRecruiter == null) {
            return ResponseEntity.badRequest().body("Email is not registered.");
        }
        else {
        	// Store the email in the session
        // session.setAttribute("resetEmail", request.getEmail());

        String otp = otpService.generateOtp(userEmail);
        //tempEmailStorage.put(userEmail, userEmail);

        // Send OTP email using EmailService
        emailService.sendOtpEmail(userEmail, otp);

        otpVerificationMap.put(userEmail, true); // Mark OTP as verified

        return ResponseEntity.ok("OTP sent to your email.");
        }
    }
    
    
    @PostMapping("/verify-otp/{email}")
    public ResponseEntity<String> verifyOtp(
        @PathVariable String email,
        @RequestBody OtpVerificationRequest otpRequest
    ) {
        String enteredOtp = otpRequest.getEnteredOtp();

        if (!otpService.isEmailAssociatedWithOtp(email)) {
            return ResponseEntity.badRequest().body("Email is not correct");
        }

        if (otpService.isOtpExpired(email)) {
            return ResponseEntity.badRequest().body("Expired OTP. Please request a new one.");
        }

        if (otpService.validateOtp(email, enteredOtp)) {
            return ResponseEntity.ok("OTP verified. Proceed with password reset.");
        } else {
            return ResponseEntity.badRequest().body("Incorrect OTP.");
        }
    }


    
    
    @PostMapping("/reset-password/set-new-password/{email}")
    public ResponseEntity<String> setNewPassword(@RequestBody NewPasswordRequest request,  @PathVariable String email) {
        String newPassword = request.getNewPassword();
        String confirmedPassword = request.getConfirmedPassword();
       // String resetEmail = (String) session.getAttribute("resetEmail");

        if (email == null) {
            return ResponseEntity.badRequest().body("Email not found.");
        }

        // Get the JobRecruiter by email
        JobRecruiter jobRecruiter = jobRecruiterService.findByEmail(email);

        if (jobRecruiter == null) {
            return ResponseEntity.badRequest().body("User not found.");
        }

        // Update the password
        jobRecruiter.setPassword(newPassword); // Assuming you have a password encoder

        // Save the updated JobRecruiter
        jobRecruiterService.saveRecruiter(jobRecruiter);

        //tempEmailStorage.remove(userEmail); // Clear temporary storage

        return ResponseEntity.ok("Password updated successfully.");
    }



}
