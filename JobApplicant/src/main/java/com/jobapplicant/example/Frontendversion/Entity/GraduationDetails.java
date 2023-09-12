package com.jobapplicant.example.Frontendversion.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Embeddable
@Getter
@Setter
public class GraduationDetails {
   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
   // private int  gid;
    private String gcollegeName;  // "gcollegeName" instead of "gcollegeName"
 private String gboard;        // "gboard" instead of "gboard"
 private String gprogram;      // "gprogram" instead of "gprogram"
 private String gpercentage;   // "gpercentage" instead of "gpercentage"
 private String gyearOfPassing;// "gyearOfPassing" instead of "gyearOfPassing"
 private String gCity;         // "gCity" instead of "gCity"
 private String gState;
}
