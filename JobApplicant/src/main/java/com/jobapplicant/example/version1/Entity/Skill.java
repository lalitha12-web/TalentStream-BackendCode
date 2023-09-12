package com.jobapplicant.example.version1.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long skill_id;

    @NotBlank
    private String skill_name;

    @OneToOne(targetEntity = Experience.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_id", referencedColumnName = "experienceId")
    @JsonManagedReference
    private Experience experience;


    @ManyToOne
    @JoinColumn(name = "resume_id")
    @JsonBackReference
    private Resume resume;
}
