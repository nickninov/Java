package externalDataClasses;

import java.io.Serializable;
import java.util.Date;

import helperClasses.ExternalData;
import interfaces.Displayable;

public class News extends ExternalData implements Serializable, Displayable {
	String body;
	
	public News () {}
	
	public News(String body, Date date, String title) {
		this.body = body;
		// External data
		this.setDate(date);
		this.setTitle(title);
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	// Implement Displayable -> show
	@Override
	public void show() {
		System.out.println("Title: " + this.getTitle() + "\tPosted: "+ this.getDate() + "\n");
		System.out.println(this.getBody() + "\n");
	}
}
