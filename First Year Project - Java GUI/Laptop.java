package GUI;

import java.io.Serializable;

public class Laptop implements Serializable{
	private int id;
	private String brand;
	private int ram;
	private double clockSpeed;
	private double price;

	public Laptop() {
		this.brand = "?????????";
		this.ram = 0;
		this.clockSpeed = 0;
		this.price = 0;
		this.id = 0;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Laptop(int id, String brand, int ram, double clockSpeed, double price) {
		this.brand = brand;
		this.ram = ram;
		this.clockSpeed = clockSpeed;
		this.price = price;
		this.id = id;
	}

	@Override
	public String toString() {
		return "ID: " + id +"\tBrand: " + brand + "\tRAM: " + ram + "\tGHz: " + clockSpeed + "\tPrice: £" + price + "\n\n";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public double getClockSpeed() {
		return clockSpeed;
	}

	public void setClockSpeed(double clockSpeed) {
		this.clockSpeed = clockSpeed;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}