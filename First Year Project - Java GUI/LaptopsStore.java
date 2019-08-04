package GUI;

import java.util.ArrayList;

public class LaptopsStore {
	private ArrayList<Laptop> laptops;
	
	public LaptopsStore() {
		laptops = new ArrayList<Laptop>();
	}
	
	public void addLaptop(int id, String brand, int ram, int clockSpeed, double price) {
		
	}
	
	public void removeLaptop(int index) {
		
	}
	
	public ArrayList<Laptop> getLaptops(){
		return laptops;
	}
	
	public void sortIDAscending() {
		
	}
	public void sortIDDescending() {
		
	}
	public ArrayList<Laptop> sortRAM() {
		
		return laptops;
	}
	public void sortPrice() {
		
	}
	public void sortBrandAscending() {
		
	}
	public void sortBrandDescending() {
		
	}
	
	public void sortClockSpeed() {
		
	}
	
	public String toString() {
		return laptops.toString();
	}
	
	
}
