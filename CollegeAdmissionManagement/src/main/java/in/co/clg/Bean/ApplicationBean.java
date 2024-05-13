package in.co.clg.Bean;

import java.util.Date;

public class ApplicationBean extends BaseBean{
	
	private String collegeName;
	private long collegeId;
	private String courseName;
	private long courseId;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String motherName;
	private String emailId;
	private String applicationNo;
	private long phoneNo;
	private String gender;
	private String address;
	private String correspondenceAddress;
	private String nationality;
	private String Category;
	private long pincode;
	private String board1;
	private String Year1;
	private String percentange1;
	private String stream1;
	private String board2;
	private String Year2;
	private String percentange2;
	private String stream2;
	private String declaration;
	private String DOB;
	private String status;
	private long userID;
	private long courseFees;
	private String payment;
	
	
	
	
	public long getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(long courseFees) {
		this.courseFees = courseFees;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
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

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCorrespondenceAddress() {
		return correspondenceAddress;
	}

	public void setCorrespondenceAddress(String correspondenceAddress) {
		this.correspondenceAddress = correspondenceAddress;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getBoard1() {
		return board1;
	}

	public void setBoard1(String board1) {
		this.board1 = board1;
	}

	public String getYear1() {
		return Year1;
	}

	public void setYear1(String year1) {
		Year1 = year1;
	}

	public String getPercentange1() {
		return percentange1;
	}

	public void setPercentange1(String percentange1) {
		this.percentange1 = percentange1;
	}

	public String getStream1() {
		return stream1;
	}

	public void setStream1(String stream1) {
		this.stream1 = stream1;
	}

	public String getBoard2() {
		return board2;
	}

	public void setBoard2(String board2) {
		this.board2 = board2;
	}

	public String getYear2() {
		return Year2;
	}

	public void setYear2(String year2) {
		Year2 = year2;
	}

	public String getPercentange2() {
		return percentange2;
	}

	public void setPercentange2(String percentange2) {
		this.percentange2 = percentange2;
	}

	public String getStream2() {
		return stream2;
	}

	public void setStream2(String stream2) {
		this.stream2 = stream2;
	}

	public String getDeclaration() {
		return declaration;
	}

	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}
	
	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Override
	public String getKey() {
		return id+"";
	}

	@Override
	public String getValue() {
		return collegeName+courseName;
	}

}
