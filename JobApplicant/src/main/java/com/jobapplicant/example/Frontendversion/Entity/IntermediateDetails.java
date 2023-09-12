package com.jobapplicant.example.Frontendversion.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


//@Entity
@Embeddable
@Getter
@Setter

public class IntermediateDetails {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int interid;
    private String icollegeName;
    private String iboard;
    private String iprogram;
    private String ipercentage;
    private String iyearOfPassing;
    private String iCity;
    private String iState;
}
