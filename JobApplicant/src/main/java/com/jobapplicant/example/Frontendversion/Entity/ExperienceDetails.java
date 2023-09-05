package com.jobapplicant.example.Frontendversion.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Embeddable
//@Entity
@Getter
@Setter
public class ExperienceDetails {
   // @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
   // private int expid;
    private String company;
    private String position;
    private String startDate;
    private String endDate;
}
