package helperClasses;

import java.io.Serializable;
import java.util.Date;

import interfaces.Displayable;

public class InternalData implements Serializable, Displayable{
	private Date date;
	private String title;
	private String description;
	
	public InternalData(Date date, String title, String description) {
		this.date = date;
		this.description = description;
		this.title = title;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	// Display the classes data
	@Override
	public void show() {
		System.out.println("Title: " + this.getTitle() + "\tPosted: "+ this.getDate()+"\n");
		System.out.println(this.getDescription()+ "\n");
	}
	
	
}
