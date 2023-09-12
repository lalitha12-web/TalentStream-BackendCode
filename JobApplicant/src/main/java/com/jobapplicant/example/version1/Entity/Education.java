package com.jobapplicant.example.version1.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long educationId;
    private String sscBoard;
    private double sscPercentage;
    private Integer sscYearOfPassing;
    private String interBoard;
    private double interPercentage;
    private Integer interYearOfPassing;
    private String graduationUniversity;
    private double graduationPercentage;
    private Integer graduationYearOfPassing;

    @OneToOne( cascade = CascadeType.ALL)
    @JsonBackReference
    private Resume resume;
}
