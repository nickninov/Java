package builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import builder.Staff.Builder;
import clientClasses.Activity;
import clientClasses.Transaction;
import externalDataClasses.Article;
import helperClasses.UserInput;
import interfaces.Displayable;

public class Client extends Person implements Displayable{

	private static ArrayList<Transaction> budget = new ArrayList<>();
	private static ArrayList<Activity> activities = new ArrayList<>();
	private static UserInput input = new UserInput();
	
	// Show either Activity or Transaction ArrayList
	public void getInformation(boolean isBudget) {
		int i = 1;
		if(isBudget) {
			// Check if empty
			if(budget.isEmpty()) {
				System.out.println("No transactions available.\n");
			}
			else {
				System.out.println("T r a n s a c t i o n s\n");
				for(Transaction element: budget) {
					System.out.println("\nIndex: " + i + "\n");
					element.show();
					i++;
					System.out.println("*******************************");
				}
			}
		}
		else {
			// Check if empty
			if(activities.isEmpty()) {
				System.out.println("No activities available.\n");
			}
			else {
				System.out.println("A c t i v i t i e s\n");
				for(Activity element: activities) {
					System.out.println("\nIndex: " + i + "\n");
					element.show();
					i++;
					System.out.println("*******************************");
				}
			}
		}
	}

	// Add transaction to array list
	public void createTransaction() {
		String name = input.getString("Transaction name: ");
		Double amount = input.getDouble("Amount: ");
		addTransaction(new Transaction(amount, name, new Date()));
	}

	// Remove transaction from array list
	public void removeTransaction() {
		// Display budget
		getInformation(true);
		int index = input.getInt("Index: ");
		removeData(index, true);
	}

	// Edit transaction from array list
	public void changeTransaction() {
		// Display budget
		getInformation(true);
		int index = input.getInt("Index: ");
		String name = input.getString("Transaction name: ");
		double amount = input.getDouble("Amount: ");
		editBudget(index, new Transaction(amount, name, new Date()));
	}

	// Add activity to array list
	public void createActivity() {
		String action = input.getString("Activity: ");
		addActivity(new Activity(action, new Date()));
	}

	// Remove activity from array list
	public void removeActivity() {
		// Display activities
		getInformation(false);
		// Check if there are any activities in array list
		if(activities.size() > 0) {
			int index = input.getInt("Index: ");
			// Check if index is valid
			if(index <= activities.size() && index > 0) {
				removeData(index, false);
			}
			else {
				System.out.println("Activity does not exist.\n");
			}
		}
	}

	// Edit activity from array list
	public void changeActivity() {
		// Display activities
		getInformation(false);
		int index = input.getInt("Index: ");
		String action = input.getString("Activity: ");
		editActivity(index, new Activity(action, new Date()));
	}


	// Add transaction to the array list
	private void addTransaction(Transaction transaction) {
		// Check if amount is greater than 0
		if(transaction.getAmount() > 0) {
			// Check if input is valid
			if(transaction.getName().matches("")) {
				System.out.println("Invalid input.\n");
			}
			else {
				budget.add(transaction);
				System.out.println("Transaction has been added!\n");
			}
		}
		else {
			System.out.println("Transaction could not be added. The given value is: " + transaction.getAmount() + " which is not valid.\n");
		}
	}

	// Add transaction to the array list
	private void addActivity(Activity activity) {
		// Check if input is valid
		if(activity.getAction().matches("")) {
			System.out.println("Invalid input.\n");
		}
		else {
			activities.add(activity);
			System.out.println("Activity has been added!\n");
		}
	}

	// Remove transaction or article from the array list
	private void removeData(int index, boolean isBudget) {
		if(isBudget) {
			// Check if index is valid and if there are transactions
			if(index <= budget.size() && index > 0 && !budget.isEmpty()) {
				budget.remove(index - 1);
				System.out.println("Transaction removed");
			}
			else {
				System.out.println("No transactions available.\n");
			}	
		}
		else {
			// Check if index is valid and if there are activities
			if(index <= activities.size() && index > 0 && !activities.isEmpty()) {
				activities.remove(index - 1);
				System.out.println("Activity removed");
			}
			else {
				System.out.println("No activities available.\n");
			}
		}
	}

	// Edit Activity data in the ArrayList
	private void editActivity(int index, Activity activity) {
		// Check if index is valid and if there are activities
		if(!activities.isEmpty() && index <= activities.size() && index > 0) {
			// Check if input is valid
			if(activity.getAction().matches("")) {
				System.out.println("Invalid input.\n");
			}
			else {
				activities.set(index - 1, activity);
				System.out.println("Activity data has been edited!\n");
			}
		}
		else {
			System.out.println("Activity does not exist.\n");
		}
	}

	// Edit Budget data in the ArrayList
	private void editBudget(int index, Transaction transaction) {
		// Check if index is valid and if there are activities
		if(!budget.isEmpty() && index <= budget.size() && index > 0) {
			// Check if input is valid
			if(transaction.getAmount() > 0 && !transaction.getName().matches("")) {
				budget.set(index - 1, transaction);
				System.out.println("Transaction data has been edited!\n");
			}
			else {
				System.out.println("Invalid input.\n");
				
			}
			
		}
		else {
			System.out.println("No transactions available.\n");
		}
		
	}

	private Client() {
		loadFiles("/Users/nick/Desktop/Data/Client/Transactions.ser", "/Users/nick/Desktop/Data/Client/Activities.ser");
	}

	public static class Builder extends Person {

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

		public Client build() {
			Client client = new Client();

			// Person
			client.setFullName(this.getFullName());
			client.setAge(this.getAge());
			client.setId(this.getId());
			client.setPhone(this.getPhone());
			client.setUsername(this.getUsername());
			client.setPassword(this.getPassword());
			// Company
			client.setName(this.getName());
			client.setInfo(this.getInfo());
			client.setType(this.getType());

			return client;
		}
	}

	// Implement Displayable -> show
	@Override
	public void show() {
		this.getPersonInfo();
		this.getCompanyInfo();
	}
	
	
	// Load data into the news and article ArrayLists
	private static void loadFiles(String transactionFile, String activityFile) {
		File fileTransactions = new File(transactionFile);
		File fileActivities = new File(activityFile);

		try {
			ObjectInputStream ioTransactions = new ObjectInputStream(new FileInputStream(fileTransactions));
			ObjectInputStream iosActivities = new ObjectInputStream(new FileInputStream(activityFile));

			try {
				budget = (ArrayList) ioTransactions.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}

			try {
				activities = (ArrayList) iosActivities.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}

			ioTransactions.close();
			iosActivities.close();
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}
}
