package com.jobapplicant.example.version1.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

import lombok.*;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity

public class ApplicantBioData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicantProfile_Id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]{3,19}$",message = "invalid username")
    private String firstname;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]{3,19}$",message = "invalid username")
    private String lastname;

    @NotBlank
    @Email(message = "invalid email address")
    private String email;
    @NotNull
    private LocalDate dob;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number")
    private String alternatemobileno;

    @NotBlank
    @Pattern(regexp = "\\d{6}", message = "Invalid PIN code. Should be 6 digits.")
    private String pincode;


    @OneToOne(targetEntity = Resume.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "resume_id", referencedColumnName = "resumeId")
    @JsonManagedReference
    private Resume resume;
}
