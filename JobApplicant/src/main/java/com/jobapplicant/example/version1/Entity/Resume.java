package com.jobapplicant.example.version1.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long resumeId;
    @NotBlank
    private String location;


    @OneToMany(targetEntity = Skill.class,cascade = CascadeType.ALL)
    // @JoinColumn(name="skill_id",referencedColumnName = "skill_id")
    @JsonManagedReference
    private List<Skill> skillSet=new ArrayList<>();




    @OneToOne(targetEntity = Education.class, cascade = CascadeType.ALL)
    // @JoinColumn(name = "education_id", referencedColumnName = "educationId")
    @JsonManagedReference
    private Education education;



    @OneToOne
    @JsonBackReference
    private ApplicantBioData applicantProfile;
}
