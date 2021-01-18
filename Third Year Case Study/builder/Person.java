package builder;

import java.util.ArrayList;
import java.util.Date;

import interfaces.Displayable;

public class Person extends Company {
	
	private String fullName;
	private String id;
	private int age;
	private String phone;
	private Company company;
	private String username;
	private String password;
	
	public Person() {}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// Display the classes data
	public void getPersonInfo() {
		System.out.println("Name:\t\t" + this.getFullName() + "\n");
		System.out.println("Age:\t\t" + this.getAge() + "\n");
		System.out.println("ID number:\t" + this.getId() + "\n");
		System.out.println("Phone number:\t" + this.getPhone() + "\n");
		System.out.println("Username:\t" + this.getUsername() + "\n");
		
	}
	
}
