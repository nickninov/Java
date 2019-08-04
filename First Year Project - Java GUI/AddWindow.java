package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddWindow extends JInternalFrame {

//	ArrayList that helps display information
	public static ArrayList<Laptop> displayInfo = new ArrayList<>();
//	private static Laptop laptopItem;
	private static int idShift;
	
	public AddWindow(String text) {
		super(text);
		
		Windows win = new Windows();
		
		JPanel tidy = new JPanel(new GridLayout(7, 2));
		Font f = new Font("Verdana", Font.PLAIN, 30);
		
		JLabel enterId = new JLabel("Enter ID: "); tidy.add(enterId);
		JTextField id = new JTextField(); tidy.add(id);
		enterId.setFont(f);
		id.setFont(f);
		
		JLabel enterBrand = new JLabel("Enter brand: "); tidy.add(enterBrand);
		JTextField brandField = new JTextField(); tidy.add(brandField);
		enterBrand.setFont(f);
		brandField.setFont(f);
		
		JLabel enterRam = new JLabel("Enter RAM: "); tidy.add(enterRam);
		JTextField ramField = new JTextField(); tidy.add(ramField);
		enterRam.setFont(f);
		ramField.setFont(f);
		
		JLabel enterGhz = new JLabel("Enter GHz: "); tidy.add(enterGhz);
		JTextField ghzField = new JTextField(); tidy.add(ghzField);
		enterGhz.setFont(f);
		ghzField.setFont(f);
		
		JLabel enterPrice = new JLabel("Enter price: "); tidy.add(enterPrice);
		JTextField priceField = new JTextField(); tidy.add(priceField);
		enterPrice.setFont(f);
		priceField.setFont(f);
		
		JLabel statusLable = new JLabel("Status: "); tidy.add(statusLable);
		JLabel status = new JLabel(); tidy.add(status);
		
		
		
		JButton exit = new JButton("Exit"); tidy.add(exit);
	
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Windows.open = false;
			}
		});
		
		JButton addDetails = new JButton("Add"); tidy.add(addDetails);
		
		statusLable.setFont(f);
		status.setFont(new Font("Verdana", Font.PLAIN, 15));
		exit.setFont(f);
		addDetails.setFont(f);
		
		addDetails.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				Laptop laptopItem = new Laptop();
				
				try {
					
				idShift = Integer.parseInt(id.getText());
				
				ArrayList<Integer> dummy = new ArrayList<>();
				
				for(int i = 0; i < displayInfo.size(); i++) {
					dummy.add(displayInfo.get(i).getId());
					
				}
				
				
				for(int i = 0; i < dummy.size(); i++) {
					if(dummy.get(i) == idShift) {
						laptopItem.setId(0);
						break;
					}
					else {
						laptopItem.setId(idShift);
					}
				}
				
				if(displayInfo.size() == 0) {
					laptopItem.setId(idShift);
				}
				
				}
				catch(NumberFormatException e1) {
					status.setText("ID has to be a number");
				}
				
				
				String brand = brandField.getText();
				laptopItem.setBrand(brand);
				
				try {
				String ramString = ramField.getText();
				int ram = Integer.parseInt(ramString);
				
				if(ram > 0) {
					laptopItem.setRam(ram);
				}
				
				}
				catch(NumberFormatException e1) {
					status.setText("Please enter a number...");
				}
				
				try {
				String clockSpeedString = ghzField.getText();
				double clockSpeed = Double.parseDouble(clockSpeedString);
				
				if(clockSpeed > 0) {
					laptopItem.setClockSpeed(clockSpeed);

				}

				}
				catch(NumberFormatException e2) {
					status.setText("Please enter a number...");
				}
				
				try {
				String priceString = priceField.getText();
				double price = Double.parseDouble(priceString);
				
				if(price > 0) {
					laptopItem.setPrice(price);

				}

				}
				catch(NumberFormatException e3) {
					status.setText("Please enter a number...");
				}
				
				if(laptopItem.getRam() == 0 || laptopItem.getPrice() == 0 || laptopItem.getClockSpeed() == 0 && laptopItem.getId()== 0 && laptopItem.getBrand().equals("?????????") ) {
				status.setText("Item was not added!");
				}
				else {
					if(laptopItem.getId() > 0) {
					displayInfo.add(laptopItem);
					status.setText("Item successfully added!");
					}
					
					else {
						JOptionPane.showMessageDialog(null, "ID already in use. Please change ID number", "Not valid ID", JOptionPane.WARNING_MESSAGE);
						status.setText("Laptop not added!");
					}
				}

			}
		});				
	
		setFocusable(true);
		add(tidy);
		pack();
		setVisible(true);
		
	}
}	