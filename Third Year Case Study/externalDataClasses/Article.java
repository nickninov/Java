package externalDataClasses;

import java.io.Serializable;
import java.util.Date;

import helperClasses.ExternalData;
import interfaces.Displayable;

public class Article extends ExternalData implements Serializable, Displayable {
	private String intro;
	private String body;
	private String summary;
	
	public Article(String intro, String body, String summary, Date date, String title) {
		this.intro = intro;
		this.body = body;
		this.summary = summary;
		// External data 
		this.setDate(date);
		this.setTitle(title);
	}
	
	public Article() {}
	
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	// Implement Displayable -> show
	@Override
	public void show() {
		System.out.println("Title: " + this.getTitle() + "\tPosted: " + this.getDate() + "\n");
		System.out.println(this.getIntro() + "\n");
		System.out.println(this.getBody() + "\n");
		System.out.println(this.getSummary() + "\n");
	}
	
}
