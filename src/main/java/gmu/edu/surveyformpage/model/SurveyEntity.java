package gmu.edu.surveyformpage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name="survey")
public class SurveyEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="streetAddress")
	private String streetAddress;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="dateOfSurvey")
	private String dateOfSurvey;
	
	@Column(name="likeCampus")
	private String likeCampus;
	
	@Column(name="interestedInUniversity")
	private String interestedInUniversity;
	
	@Column(name="prospectiveStudents")
	private String prospectiveStudents;
	
	@Column(name="raffle")
	private String raffle;
	
	@Column(name="additionalComments")
	private String additionalComments;
	
	public Long getId() {
		return id;
	}
	
	public void setId(long id) {
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
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDateOfSurvey() {
		return dateOfSurvey;
	}
	
	public void setDateOfSurvey(String dateOfSurvey) {
		this.dateOfSurvey = dateOfSurvey;
	}
	
	public String getLikeCampus() {
		return likeCampus;
	}
	
	public void setLikeCampus(String likeCampus) {
		this.likeCampus = likeCampus;
	}
	
	public String getInterestedInUniversity() {
		return interestedInUniversity;
	}
	
	public void setInterestedInUniversity(String interestedInUniversity) {
		this.interestedInUniversity = interestedInUniversity;
	}
	
	public String getProspectiveStudents() {
		return prospectiveStudents;
	}
	
	public void setProspectiveStudents(String prospectiveStudents) {
		this.prospectiveStudents = prospectiveStudents;
	}
	
	public String getRaffle() {
		return raffle;
	}
	
	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}
	
	public String getAdditionalComments() {
		return additionalComments;
	}
	
	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}
}
