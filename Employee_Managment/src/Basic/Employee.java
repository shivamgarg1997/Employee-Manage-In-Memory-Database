package Basic;

import java.util.HashMap;
import java.util.Map;

public class Employee {
	static Map<Integer, String> deptMap = new HashMap<Integer, String>();
	static Map<Integer, String> genderMap = new HashMap<Integer, String>();
	static {
		genderMap.put(1, "Male");
		genderMap.put(2, "Female");
		genderMap.put(3, "Transgender");

		deptMap.put(1, "Admin");
		deptMap.put(2, "HR");
		deptMap.put(3, "Tech");
		deptMap.put(4, "Network");
	}
	private String id;
	private int age;
	private String name, firstName, middleName, lastName;
	private String email;
	private String address, city, state, country;
	private String gender, dept, phno;
	private String dob;

	public Employee(String id,String firstName, String middleName, String lastName, String gender, String dob, String phno,
			String email, String address, String dept) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.phno = phno;
		this.email = email;
		this.address = address;
		this.dept = dept;
	}

	public Employee() {
	}

	public String getName() {
		return Utility.camelCase(getFirstName() +" "+ getMiddleName() + " " + getLastName());
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middle_name) {
		this.middleName = middle_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String toString() {
		return firstName + "," + middleName + "," + lastName + "," + gender + "," + dob + "," + phno + "," + email + ","
				+ address + "," + dept;
	}

	public static String mapToGender(int tG) {
		return Employee.genderMap.get(tG);
	}

	public static String mapToDept(int tG) {
		return Employee.deptMap.get(tG);
	}
}
