package builder;

import java.util.ArrayList;
import java.util.Date;

import builder.Staff.Builder;
import externalDataClasses.Article;
import externalDataClasses.News;
import helperClasses.InternalData;
import helperClasses.UserInput;
import interfaces.Archivable;
import interfaces.Displayable;
import singletons.ExternalArchive;


public class ExternalStaff extends Person implements Displayable, Archivable{
	private String department;
	private static UserInput input = new UserInput();

	private static ExternalArchive data;
	
	// Show the News Array List
	public void showNews() {
		data.showData(true);
	}
	
	// Show the Article Array List
	public void showArticles() {
		data.showData(false);
	}
	
	// Add Article to Array List
	public void createArticle() {
		String intro = input.getString("Intro: ");
		String title = input.getString("Title: ");
		String body = input.getString("Body: ");
		String summary = input.getString("Summary: ");
		data.addArticleData(new Article(intro, body, summary, new Date(), title));
	}
	
	// Add News to Array List
	public void createNews() {
		String title = input.getString("Title: ");
		String intro = input.getString("Intro: ");
		String body = input.getString("Body: ");
		String summary = input.getString("Summary: ");
		data.addArticleData(new Article(intro, body, summary, new Date(), title));
	}
	
	// Edit News in Array List
	public void changeNews() {
		data.showData(true);
		int index = input.getInt("Index: ");
		String title = input.getString("Title: ");
		String body = input.getString("Body: ");
		data.editNewsData(index, new News(body, new Date(), title));
	}
	
	// Edit Article in Array List
	public void changeArticle() {
		data.showData(false);
		int index = input.getInt("Index: ");
		String title = input.getString("Title: ");
		String intro = input.getString("Intro: ");
		String body = input.getString("Body: ");
		String summary = input.getString("Summary: ");
		data.editArticleData(index, new Article(intro, body, summary, new Date(), title));
	}
	
	// Remove News in Array List
	public void removeNews() {
		data.showData(true);
		int index = input.getInt("Index: ");
		data.removeData(index, true);
	}
	
	// Remove Article in Array List
	public void removeArticle() {
		data.showData(true);
		int index = input.getInt("Index: ");
		// Check if index is valid
		data.removeData(index, false);
	}
	
	private ExternalStaff () {}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	// Implement Displayable -> show()
	@Override
	public void showArchiveData() {
		data.showData(true);
		data.showData(false);
		
	}

	// Implement Archivable -> showArchiveData()
	@Override
	public void show() {
		this.getPersonInfo();
		System.out.println("Department:\t" + this.getDepartment() + "\n");
		this.getCompanyInfo();
	}

	public static class Builder extends Person {
		private String biography;
		private String department;
		private ExternalArchive data;
		
		public Builder() {
			this.data = ExternalArchive.getInstance();
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
		
		public ExternalStaff build() {
			ExternalStaff staff = new ExternalStaff();
			staff.department = this.department;
			staff.data = this.data;
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