package com.jobapplicant.example.Frontendversion.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
@Embeddable
public class BasicDetails {
   // @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int detailsid;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]{3,19}$",message = "invalid username")
    private String firstName;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]{3,19}$",message = "invalid username")
    private String lastName;

    private String dateOfBirth;
    private String address;
    private String city;
    private String state;

    @NotBlank
    @Pattern(regexp = "^\\d{6}$",message = "invalid mobile number")
    private String pincode;
    private  String email;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number")
    private String alternatePhoneNumber;
}
