package com.jobapplicant.example.version1.Controller;

import com.jobapplicant.example.version1.Entity.ApplicantLogin;
import com.jobapplicant.example.version1.Entity.ApplicantRegister;
import com.jobapplicant.example.version1.Entity.ApplicantRegisterwithOTP;
import com.jobapplicant.example.version1.Service.ApplicantRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ApplicantRegisterController {
    /*
    @Autowired
    private ApplicantRegisterService userService;

    @PostMapping("/api/applicant/register")
    public ResponseEntity<ApplicantRegisterwithOTP> register(@RequestBody ApplicantRegister applicantRegister) {
        return new ResponseEntity<>(userService.register(applicantRegister), HttpStatus.OK);
    }

    @PutMapping("/api/applicant/verify-account")
    public ResponseEntity<String> verifyAccount(@RequestParam String email,
                                                @RequestParam String otp) {
        return new ResponseEntity<>(userService.verifyAccount(email, otp), HttpStatus.OK);
    }

    @PutMapping("/api/applicant/regenerate-otp")
    public ResponseEntity<String> regenerateOtp(@RequestParam String email) {
        return new ResponseEntity<>(userService.regenerateOtp(email), HttpStatus.OK);
    }

    @PutMapping("/api/applicant/login")
    public ResponseEntity<String> login(@RequestBody ApplicantLogin loginDto) {
        return new ResponseEntity<>(userService.login(loginDto), HttpStatus.OK);
    }
/*
    @PutMapping("/api/applicant/forgotpassword")
    public ResponseEntity<String> forgotPassword(@RequestBody String email) {

            return new ResponseEntity<>(userService.forgotPassword(email), HttpStatus.OK);
        }*/
/*
    @PutMapping("/forgotpassword")
    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> requestMap) {
        String email = requestMap.get("email");
        return new ResponseEntity<>(userService.forgotPassword(email), HttpStatus.OK);
    }



   /* @GetMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String email) {
        // Implement the logic to handle password reset here
        return new ResponseEntity<>("Password reset link clicked for: " + email, HttpStatus.OK);
    }*/
    /*
      @PutMapping("/set-password")
      public ResponseEntity<String> setPassword(@RequestBody Map<String, String> requestMap) {
          String email = requestMap.get("email");
          String password = requestMap.get("password");
          return new ResponseEntity<>(userService.setPassword(email, password), HttpStatus.OK);
      }*/
    }