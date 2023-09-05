package com.jobapplicant.example.version1.Service;

import com.jobapplicant.example.version1.Entity.ApplicantLogin;
import com.jobapplicant.example.version1.Entity.ApplicantRegister;
import com.jobapplicant.example.version1.Entity.ApplicantRegisterwithOTP;
import com.jobapplicant.example.version1.Repository.ApplicantRegisterRepository;
import com.jobapplicant.example.version1.Util.EmailUtils;
import com.jobapplicant.example.version1.Util.OtpUtils;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ApplicantRegisterService {
/*
    @Autowired
    private OtpUtils otpUtil;
    @Autowired
    private EmailUtils emailUtil;
    @Autowired
    private ApplicantRegisterRepository userRepository;
    public ApplicantRegisterwithOTP register(ApplicantRegister applicantRegister) {

        Optional<ApplicantRegisterwithOTP> existingApplicant = userRepository.findByEmail(applicantRegister.getEmail());

        if (existingApplicant.isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }
        else {

           // String otp = otpUtil.generateOtp();
            try {
             //   emailUtil.sendOtpEmail(applicantRegister.getEmail(), otp);
            } catch (MessagingException e) {
                throw new RuntimeException("Unable to send otp please try again");
            }
            ApplicantRegisterwithOTP user = new ApplicantRegisterwithOTP();
            user.setName(applicantRegister.getName());
            user.setEmail(applicantRegister.getEmail());
            user.setPassword(applicantRegister.getPassword());
           user.setOtp(otp);
            user.setOtpGeneratedTime(LocalDateTime.now());
            userRepository.save(user);

            return userRepository.save(user);  }

    }
    public String verifyAccount(String email, String otp) {
        ApplicantRegisterwithOTP user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with this email: " + email));
        if (user.getOtp().equals(otp) && Duration.between(user.getOtpGeneratedTime(),
                LocalDateTime.now()).getSeconds() < (1 * 120)) {
            user.setOtp(null);
            userRepository.save(user);
            return "OTP verified you can login";
        }
        return "Please regenerate otp and try again";
    }
    public String regenerateOtp(String email) {
        ApplicantRegisterwithOTP user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with this email: " + email));
       String otp = otpUtil.generateOtp();
        try {
            emailUtil.sendOtpEmail(email, otp);
        } catch (MessagingException e) {
            throw new RuntimeException("Unable to send otp please try again");
        }
        user.setOtp(otp);
        user.setOtpGeneratedTime(LocalDateTime.now());
        userRepository.save(user);
        return "Email sent... please verify account within 1 minute";
    }

    public String login(ApplicantLogin applicantLogin) {
        ApplicantRegisterwithOTP user = userRepository.findByEmail(applicantLogin.getEmail())
                .orElseThrow(
                        () -> new RuntimeException("User not found with this email: " + applicantLogin.getEmail()));
        if (user != null && user.getPassword().equals(applicantLogin.getPassword())) {

            return "Login Successful";
        }
        return "email password not matching or incorrect";
    }
public String forgotPassword(String email) {

    ApplicantRegisterwithOTP user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found with email" + email));
    try {
        emailUtil.sendSetpasswordEmail(email);
    } catch (MessagingException e) {
        throw new RuntimeException("unable to send set password");
    }
return "Please check your mail to set new Password";
}
public String setPassword(String email, String newpassword)
{
    ApplicantRegisterwithOTP user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found with email" + email));
    user.setPassword(newpassword);
    userRepository.save(user);
    return "new password set sucessfully";
}
*/
}
