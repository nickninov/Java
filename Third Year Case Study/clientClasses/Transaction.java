package clientClasses;

import java.io.Serializable;
import java.util.Date;

import interfaces.Displayable;

public class Transaction implements Serializable, Displayable{
	private Double amount;
	private String name;
	private Date date;
	
	public Transaction() {}
	
	public Transaction(Double amount, String name, Date date) {
		this.amount = amount;
		this.name = name;
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		System.out.println(this.getDate() + "\n");
		System.out.println(this.getName()+ ":\t£ " + this.getAmount()+ "\n");
	}
}
