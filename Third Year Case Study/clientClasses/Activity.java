package clientClasses;

import java.io.Serializable;
import java.util.Date;

import interfaces.Displayable;

public class Activity implements Serializable, Displayable{
	private String action;
	private Date date;
	
	public Activity() {}
	
	public Activity(String action, Date date) {
		this.action = action;
		this.date = date;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// Implement Displayable -> show
	@Override
	public void show() {
		System.out.println(this.getDate() + ":\t " + this.getAction() + "\n");
	}
}
