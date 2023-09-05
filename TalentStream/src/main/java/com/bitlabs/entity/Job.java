package com.bitlabs.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recruiterId")
    private JobRecruiter recruiter;

    private String jobTitle;
    private String jobDescription;
    private int yearsOfExperience;

    @ElementCollection // Indicates that this is a collection of elements
    private List<String> skills = new ArrayList<>(); // List of skills

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "eligibility_id")
    private Eligibility eligibility;
    // Constructors, getters, setters, etc.
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public JobRecruiter getRecruiter() {
		return recruiter;
	}
	public void setRecruiter(JobRecruiter recruiter) {
		this.recruiter = recruiter;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public Eligibility getEligibility() {
		return eligibility;
	}
	public void setEligibility(Eligibility eligibility) {
		this.eligibility = eligibility;
	}
	public int getNumberOfCandidates() {
		return numberOfCandidates;
	}
	public void setNumberOfCandidates(int numberOfCandidates) {
		this.numberOfCandidates = numberOfCandidates;
	}
	public double getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(LocalDate postedOn) {
		this.postedOn = postedOn;
	}
	private int numberOfCandidates;
    private double annualSalary;
    private String location;
    private LocalDate postedOn;

	public Job(Long id, JobRecruiter recruiter, String jobTitle, String jobDescription, int yearsOfExperience,
			List<String> skills, Eligibility eligibility, int numberOfCandidates, double annualSalary, String location,
			LocalDate postedOn) {
		super();
		this.id = id;
		this.recruiter = recruiter;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.yearsOfExperience = yearsOfExperience;
		this.skills = skills;
		this.eligibility = eligibility;
		this.numberOfCandidates = numberOfCandidates;
		this.annualSalary = annualSalary;
		this.location = location;
		this.postedOn = postedOn;
	}
	public Job() {
		
	}


    
}
