package id.rezaprima.mitraistest.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String mobileNumber;
	
	private LocalDate birthdate;
	
	private char gender;

	public  String getEmail() {
		return email;
	}

	public  void setEmail(String email) {
		this.email = email;
	}

	public  String getFirstName() {
		return firstName;
	}

	public  void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public  String getLastName() {
		return lastName;
	}

	public  void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public  String getMobileNumber() {
		return mobileNumber;
	}

	public  void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public  LocalDate getBirthdate() {
		return birthdate;
	}

	public  void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public  char getGender() {
		return gender;
	}

	public  void setGender(char gender) {
		this.gender = gender;
	}

	public  Long getId() {
		return id;
	}
	
	
}