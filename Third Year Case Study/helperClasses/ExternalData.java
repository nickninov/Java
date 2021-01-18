package helperClasses;

import java.io.Serializable;
import java.util.Date;

import interfaces.Displayable;


public class ExternalData implements Serializable {
	private Date date;
	private String title;
		
	public ExternalData() {}	
	
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
}
