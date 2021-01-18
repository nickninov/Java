package builder;

import java.util.ArrayList;
import java.util.Date;

import builder.Staff.Builder;
import helperClasses.InternalData;
import helperClasses.UserInput;
import interfaces.Archivable;
import interfaces.Displayable;
import singletons.ExternalArchive;
import singletons.InternalArchive;

public class Staff extends Person implements Displayable, Archivable{
	private String biography;
	private String department;
	private static UserInput input = new UserInput();
	private static InternalArchive data;
	private static ExternalArchive external;
	private static ArrayList<Client> clients;
	
	public String getBiography() {
		return biography;
	}
	
	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public InternalArchive getData() {
		return data;
	}

	public void setData(InternalArchive archive) {
		data = archive;
	}
	
	public static ExternalArchive getExternal() {
		return external;
	}

	public static void setExternal(ExternalArchive external) {
		Staff.external = external;
	}

	public void showClients() {
		int i = 1;
		
		if(!clients.isEmpty()) {
			for(Client client: clients) {
				System.out.println("Index: " + i);
				client.show();
				i++;
			}
		}
		else {
			System.out.println("No client data.\n");
		}
	}
	
	// Create a client object and add it to the array list
	public void createClient() {
		String fullName = input.getString("Full name: ");
		String id = input.getString("ID: ");
		int age = input.getInt("Age: ");
		String username = input.getString("Username: ");
		String password = input.getString("Password: ");
		String phone = input.getString("Phone number: ");
		String companyName = input.getString("Company name: ");
		String companyType = input.getString("Company type: ");
		String companyInfo = input.getString("Company information: ");
		
		Client person = new Client.Builder().addFullName(fullName)
												.addId(id)
												.addAge(age)
												.addUsername(username)
												.addPassword(password)
												.addPhone(phone)
												.addCompanyName(companyName)
												.addCompanyType(companyType)
												.addCompanyInfo(companyInfo)
												.build();
		
		addClient(person);;	
	}
	
	// Remove Client object from Array List
	public void removeClient() {
		showClients();
		int index = input.getInt("Index: ");
		deleteClient(index);
	}	
	
	// Edit a Client object in Array List
	public void changeClient() {
		showClients();
		int index = input.getInt("Index: ");

		String fullName = input.getString("Full name: ");
		String id = input.getString("ID: ");
		int age = input.getInt("Age: ");
		String username = input.getString("Username: ");
		String password = input.getString("Password: ");
		String phone = input.getString("Phone number: ");
		String companyName = input.getString("Company name: ");
		String companyType = input.getString("Company type: ");
		String companyInfo = input.getString("Company information: ");

		Client person = new Client.Builder().addFullName(fullName)
											.addId(id)
											.addAge(age)
											.addUsername(username)
											.addPassword(password)
											.addPhone(phone)
											.addCompanyName(companyName)
											.addCompanyType(companyType)
											.addCompanyInfo(companyInfo)
											.build();

		editClient(index, person);
	}
	
	// Add data to client array list
	private void addClient(Client client) {
		// Check if input is valid
		if(client.getAge() < 18 || client.getFullName().matches("") || client.getFullName().matches("") 
				|| client.getUsername().matches("") || client.getInfo().matches("") || client.getName().matches("")
				|| client.getType().matches("") || client.getPhone().matches("") || client.getPhone().length() < 11
				|| !client.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
			System.out.println("Invalid input");
		}
		else {
			clients.add(client);
			System.out.println("Client has been added!\n");
			
		}
		
	}
	
	// Remove data from client array list
	private void deleteClient(int index) {
		// Check if index is valid and if there is a client
		if(index <= clients.size() && index > 0 && !clients.isEmpty()) {
			clients.remove(index - 1);
			System.out.println("Data at index " + index + " has been removed!");
		}
		else {
			System.out.println("No Client data available.\n");
		}
	}
	
	// Edit data from client array list
	private void editClient(int index, Client client) {
		// Check if index is valid and if there is a client
		if(index <= clients.size() && index > 0 && !clients.isEmpty()) {
			// Check if input is valid
			if(client.getAge() < 18 || client.getFullName().matches("") || client.getFullName().matches("") 
					|| client.getUsername().matches("") || client.getInfo().matches("") || client.getName().matches("")
					|| client.getType().matches("") || client.getPhone().matches("") || client.getPhone().length() < 11
					|| !client.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
				System.out.println("Invalid input");
			}
			else {
				clients.set(index - 1, client);
				System.out.println("Client has been edited");
			}
			
		}
		else {
			System.out.println("No Client data available.\n");
		}
	}
	
	// Get user's input and create Internal Archive data
	public void createData() {
		String title = input.getString("Title: ");
		String description = input.getString("Description: ");
		data.addData(new InternalData(new Date(), title, description));
	}
	
	// Get user's input and delete Internal Archive data
	public void removeData() {
		data.showInternalData();
		int index = input.getInt("Index: ");
		data.removeData(index);
	}
	
	// Get user's input and edit Internal Archive data
	public void changeData() {
		data.showInternalData();
		int index = input.getInt("Index: ");
		String title = input.getString("Title: ");
		String description = input.getString("Description: ");
		data.editData(index, new InternalData(new Date(), title, description));
	}
	
	public void showExternalArchive() {
		external.showData(true);
		external.showData(false);
	}
	
	// Implement Displayable -> show()
	@Override
	public void show() {
		this.getPersonInfo();
		System.out.println("Department:\t" + this.getDepartment() + "\n");
		System.out.println("Biography:\n" + this.getBiography()+ "\n");
		this.getCompanyInfo();

	}

	// Implement Archivable -> showArchiveData()
	@Override
	public void showArchiveData() {
		data.showInternalData();
	}
	
	public static class Builder extends Person {
		private String biography;
		private String department;
		private InternalArchive data;
		private ExternalArchive external;
		private ArrayList<Client> clients;
		
		public Builder() {
			this.data = InternalArchive.getInstance();
			this.external = ExternalArchive.getInstance();
			this.clients = new ArrayList<>();
		}
		
		public Builder addBiography(String biography) {
			this.biography = biography;
			return this;
		}
		
		public Builder addDepartment(String department) {
			this.department = department;
			return this;
		}
		
		public Builder addFullName(String fullName) {
			this.setFullName(fullName);
			return this;
		}
		
		public Builder addId(String id) {
			this.setId(id);
			return this;
		}
		
		public Builder addAge(int age) {
			this.setAge(age);
			return this;
		}
		
		public Builder addPhone(String phone) {
			this.setPhone(phone);
			return this;
		}
		
		public Builder addUsername(String username) {
			this.setUsername(username);
			return this;
		}
		
		public Builder addPassword(String password) {
			this.setPassword(password);
			return this;
		}
		
		public Builder addCompanyName(String companyName) {
			this.setName(companyName);
			return this;
		}
		
		public Builder addCompanyType(String companyType) {
			this.setType(companyType);
			return this;
		}
		
		public Builder addCompanyInfo(String companyInfo) {
			this.setInfo(companyInfo);
			return this;
		}
		
		public Staff build() {
			Staff staff = new Staff();
			staff.biography = this.biography;
			staff.department = this.department;
			staff.data = this.data;
			staff.external = this.external;
			staff.clients = this.clients;
			// Person
			staff.setFullName(this.getFullName());
			staff.setAge(this.getAge());
			staff.setId(this.getId());
			staff.setPhone(this.getPhone());
			staff.setUsername(this.getUsername());
			staff.setPassword(this.getPassword());
			// Company
			staff.setName(this.getName());
			staff.setInfo(this.getInfo());
			staff.setType(this.getType());
			
			return staff;
		}
	}
}