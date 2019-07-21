package id.rezaprima.mitraistest.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	@Pattern(regexp = "([\\[\\(])?(?:(\\+62)|62|0)\\1? ?-? ?8(?!0|4|6)\\d(?!0)\\d\\1? ?-? ?\\d{3,4} ?-? ?\\d{3,5}(?: ?-? ?\\d{3})?\\b", message="incorrect phone number format")
	// taken from https://stackoverflow.com/a/46986069
	private String mobileNumber;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate birthdate;
	
	private Character gender;

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

	public  Character getGender() {
		return gender;
	}

	public  void setGender(Character gender) {
		if(gender.equals('\u0000')) gender=null;
		this.gender = gender;
	}

	public  Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", birthdate=" + birthdate + ", gender=" + gender + "]";
	}
	
	

}