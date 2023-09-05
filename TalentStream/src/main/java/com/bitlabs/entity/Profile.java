package com.bitlabs.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Entity
@Table(name = "profile")
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name cannot be blank.")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Last name cannot be blank.")
    @Column(nullable = false)
    private String lastName;

    @NotBlank(message = "Date of birth cannot be blank.")
    @Column(nullable = false)
    private String DOB;

    @NotBlank(message = "Address cannot be blank.")
    @Column(nullable = false)
    private String address;

    @NotBlank(message = "City cannot be blank.")
    @Column(nullable = false)
    private String city;

    @NotBlank(message = "State cannot be blank.")
    @Column(nullable = false)
    private String state;

    @NotBlank(message = "Pincode cannot be blank.")
    @Column(nullable = false)
    private String pincode;

    @NotBlank(message = "Alternate phone number cannot be blank.")
    @Column(nullable = false)
    private String alternatePhoneNumber;

    @NotBlank(message = "Name of school cannot be blank.")
    @Column(nullable = false)
    private String nameOfSchool;

    @NotBlank(message = "Board cannot be blank.")
    @Column(nullable = false)
    private String board;

    @NotNull(message = "Tenth percentage cannot be null.")
    @Column(nullable = false)
    private float tenthPercentage;

    @NotNull(message = "Year of passing tenth cannot be null.")
    @Column(nullable = false)
    private int tenthYearOfPassing;

    @NotBlank(message = "City of tenth school cannot be blank.")
    @Column(nullable = false)
    private String tenthCity;

    @NotBlank(message = "State of tenth school cannot be blank.")
    @Column(nullable = false)
    private String tenthState;

    @NotBlank(message = "Pincode of tenth school cannot be blank.")
    @Column(nullable = false)
    private String tenthPincode;

    @NotBlank(message = "Name of college cannot be blank.")
    @Column(nullable = false)
    private String nameOfCollege;

    @NotBlank(message = "Board of college cannot be blank.")
    @Column(nullable = false)
    private String collegeBoard;

    @NotBlank(message = "Program cannot be blank.")
    @Column(nullable = false)
    private String program;

    @NotNull(message = "Intermediate percentage cannot be null.")
    @Column(nullable = false)
    private float interPercentage;

    @NotNull(message = "Year of passing intermediate cannot be null.")
    @Column(nullable = false)
    private int interYearOfPassing;

    @NotBlank(message = "City of intermediate cannot be blank.")
    @Column(nullable = false)
    private String interCity;

    @NotBlank(message = "State of intermediate cannot be blank.")
    @Column(nullable = false)
    private String interState;

    @NotBlank(message = "Pincode of intermediate cannot be blank.")
    @Column(nullable = false)
    private String interPincode;

    @NotBlank(message = "Name of UG college cannot be blank.")
    @Column(nullable = false)
    private String nameOfUGCollege;

    @NotBlank(message = "UG program cannot be blank.")
    @Column(nullable = false)
    private String ugProgram;

    @NotNull(message = "UG percentage cannot be null.")
    @Column(nullable = false)
    private float ugPercentage;

    @NotNull(message = "Year of passing UG cannot be null.")
    @Column(nullable = false)
    private int ugYearOfPassing;

    @NotBlank(message = "City of UG college cannot be blank.")
    @Column(nullable = false)
    private String ugCity;

    @NotBlank(message = "State of UG college cannot be blank.")
    @Column(nullable = false)
    private String ugState;

    @NotBlank(message = "Pincode of UG college cannot be blank.")
    @Column(nullable = false)
    private String ugPincode;

    @Lob
    @Column(name = "resume")
    private byte[] resume;

    // User entity relationship
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // ... (constructors)

	public Profile(Long id, @NotBlank(message = "First name cannot be blank.") String firstName,
			@NotBlank(message = "Last name cannot be blank.") String lastName,
			@NotBlank(message = "Date of birth cannot be blank.") String dOB,
			@NotBlank(message = "Address cannot be blank.") String address,
			@NotBlank(message = "City cannot be blank.") String city,
			@NotBlank(message = "State cannot be blank.") String state,
			@NotBlank(message = "Pincode cannot be blank.") String pincode,
			@NotBlank(message = "Alternate phone number cannot be blank.") String alternatePhoneNumber,
			@NotBlank(message = "Name of school cannot be blank.") String nameOfSchool,
			@NotBlank(message = "Board cannot be blank.") String board,
			@NotNull(message = "Tenth percentage cannot be null.") float tenthPercentage,
			@NotNull(message = "Year of passing tenth cannot be null.") int tenthYearOfPassing,
			@NotBlank(message = "City of tenth school cannot be blank.") String tenthCity,
			@NotBlank(message = "State of tenth school cannot be blank.") String tenthState,
			@NotBlank(message = "Pincode of tenth school cannot be blank.") String tenthPincode,
			@NotBlank(message = "Name of college cannot be blank.") String nameOfCollege,
			@NotBlank(message = "Board of college cannot be blank.") String collegeBoard,
			@NotBlank(message = "Program cannot be blank.") String program,
			@NotNull(message = "Intermediate percentage cannot be null.") float interPercentage,
			@NotNull(message = "Year of passing intermediate cannot be null.") int interYearOfPassing,
			@NotBlank(message = "City of intermediate cannot be blank.") String interCity,
			@NotBlank(message = "State of intermediate cannot be blank.") String interState,
			@NotBlank(message = "Pincode of intermediate cannot be blank.") String interPincode,
			@NotBlank(message = "Name of UG college cannot be blank.") String nameOfUGCollege,
			@NotBlank(message = "UG program cannot be blank.") String ugProgram,
			@NotNull(message = "UG percentage cannot be null.") float ugPercentage,
			@NotNull(message = "Year of passing UG cannot be null.") int ugYearOfPassing,
			@NotBlank(message = "City of UG college cannot be blank.") String ugCity,
			@NotBlank(message = "State of UG college cannot be blank.") String ugState,
			@NotBlank(message = "Pincode of UG college cannot be blank.") String ugPincode, byte[] resume, User user) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.alternatePhoneNumber = alternatePhoneNumber;
		this.nameOfSchool = nameOfSchool;
		this.board = board;
		this.tenthPercentage = tenthPercentage;
		this.tenthYearOfPassing = tenthYearOfPassing;
		this.tenthCity = tenthCity;
		this.tenthState = tenthState;
		this.tenthPincode = tenthPincode;
		this.nameOfCollege = nameOfCollege;
		this.collegeBoard = collegeBoard;
		this.program = program;
		this.interPercentage = interPercentage;
		this.interYearOfPassing = interYearOfPassing;
		this.interCity = interCity;
		this.interState = interState;
		this.interPincode = interPincode;
		this.nameOfUGCollege = nameOfUGCollege;
		this.ugProgram = ugProgram;
		this.ugPercentage = ugPercentage;
		this.ugYearOfPassing = ugYearOfPassing;
		this.ugCity = ugCity;
		this.ugState = ugState;
		this.ugPincode = ugPincode;
		this.resume = resume;
		this.user = user;
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getDOB() {
		return DOB;
	}



	public void setDOB(String dOB) {
		DOB = dOB;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}



	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}



	public String getNameOfSchool() {
		return nameOfSchool;
	}



	public void setNameOfSchool(String nameOfSchool) {
		this.nameOfSchool = nameOfSchool;
	}



	public String getBoard() {
		return board;
	}



	public void setBoard(String board) {
		this.board = board;
	}



	public float getTenthPercentage() {
		return tenthPercentage;
	}



	public void setTenthPercentage(float tenthPercentage) {
		this.tenthPercentage = tenthPercentage;
	}



	public int getTenthYearOfPassing() {
		return tenthYearOfPassing;
	}



	public void setTenthYearOfPassing(int tenthYearOfPassing) {
		this.tenthYearOfPassing = tenthYearOfPassing;
	}



	public String getTenthCity() {
		return tenthCity;
	}



	public void setTenthCity(String tenthCity) {
		this.tenthCity = tenthCity;
	}



	public String getTenthState() {
		return tenthState;
	}



	public void setTenthState(String tenthState) {
		this.tenthState = tenthState;
	}



	public String getTenthPincode() {
		return tenthPincode;
	}



	public void setTenthPincode(String tenthPincode) {
		this.tenthPincode = tenthPincode;
	}



	public String getNameOfCollege() {
		return nameOfCollege;
	}



	public void setNameOfCollege(String nameOfCollege) {
		this.nameOfCollege = nameOfCollege;
	}



	public String getCollegeBoard() {
		return collegeBoard;
	}



	public void setCollegeBoard(String collegeBoard) {
		this.collegeBoard = collegeBoard;
	}



	public String getProgram() {
		return program;
	}



	public void setProgram(String program) {
		this.program = program;
	}



	public float getInterPercentage() {
		return interPercentage;
	}



	public void setInterPercentage(float interPercentage) {
		this.interPercentage = interPercentage;
	}



	public int getInterYearOfPassing() {
		return interYearOfPassing;
	}



	public void setInterYearOfPassing(int interYearOfPassing) {
		this.interYearOfPassing = interYearOfPassing;
	}



	public String getInterCity() {
		return interCity;
	}



	public void setInterCity(String interCity) {
		this.interCity = interCity;
	}



	public String getInterState() {
		return interState;
	}



	public void setInterState(String interState) {
		this.interState = interState;
	}



	public String getInterPincode() {
		return interPincode;
	}



	public void setInterPincode(String interPincode) {
		this.interPincode = interPincode;
	}



	public String getNameOfUGCollege() {
		return nameOfUGCollege;
	}



	public void setNameOfUGCollege(String nameOfUGCollege) {
		this.nameOfUGCollege = nameOfUGCollege;
	}



	public String getUgProgram() {
		return ugProgram;
	}



	public void setUgProgram(String ugProgram) {
		this.ugProgram = ugProgram;
	}



	public float getUgPercentage() {
		return ugPercentage;
	}



	public void setUgPercentage(float ugPercentage) {
		this.ugPercentage = ugPercentage;
	}



	public int getUgYearOfPassing() {
		return ugYearOfPassing;
	}



	public void setUgYearOfPassing(int ugYearOfPassing) {
		this.ugYearOfPassing = ugYearOfPassing;
	}



	public String getUgCity() {
		return ugCity;
	}



	public void setUgCity(String ugCity) {
		this.ugCity = ugCity;
	}



	public String getUgState() {
		return ugState;
	}



	public void setUgState(String ugState) {
		this.ugState = ugState;
	}



	public String getUgPincode() {
		return ugPincode;
	}



	public void setUgPincode(String ugPincode) {
		this.ugPincode = ugPincode;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public byte[] getResume() {
		return resume;
	}



	// Additional method to set the resume from MultipartFile
    public void setResume(MultipartFile resumeFile) {
        try {
            this.resume = resumeFile.getBytes();
        } catch (IOException e) {
            // Handle the exception as needed
        }
    }
}
