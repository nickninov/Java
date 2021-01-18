package builder;

import interfaces.Displayable;

public class Company {
	private String name;
	private String type;
	private String info;
	
	public Company() {}
	
	public Company(String name, String type, String info) {
		this.name = name;
		this.type = type;
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	// Show the classes information
	public void getCompanyInfo() {
		System.out.println("Company name:\t" + this.getName() + "\n");
		System.out.println("Company type:\t" + this.getType() + "\n");
		System.out.println("Company information:\n" + this.getInfo() + "\n");
	}
	
	
}
