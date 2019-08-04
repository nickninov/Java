package GUI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Edit extends JInternalFrame{
	public Edit(String text) {
		super(text+"ID "+AddWindow.displayInfo.get(Remove.selectedItem).getId());
		
		JPanel tidy = new JPanel(new GridLayout(7, 2));
		Font f = new Font("Verdana", Font.PLAIN, 30);
		
		
		JLabel enterId = new JLabel("Change ID: "); tidy.add(enterId);
		JTextField id = new JTextField();  id.setText(AddWindow.displayInfo.get(Remove.selectedItem).getId()+"");
		
		tidy.add(id);
		enterId.setFont(f);
		id.setFont(f);
		
		JLabel enterBrand = new JLabel("Change brand: "); tidy.add(enterBrand);
		JTextField brandField = new JTextField(); tidy.add(brandField);
		brandField.setText(AddWindow.displayInfo.get(Remove.selectedItem).getBrand());
		
		enterBrand.setFont(f);
		brandField.setFont(f);
		
		JLabel enterRam = new JLabel("Change RAM: "); tidy.add(enterRam);
		JTextField ramField = new JTextField(); tidy.add(ramField);
		String ramString = AddWindow.displayInfo.get(Remove.selectedItem).getRam()+"";
		ramField.setText(ramString);
		enterRam.setFont(f);
		ramField.setFont(f);
		
		JLabel enterGhz = new JLabel("Change GHz: "); tidy.add(enterGhz);
		JTextField ghzField = new JTextField(); tidy.add(ghzField);
		String ghzString = AddWindow.displayInfo.get(Remove.selectedItem).getClockSpeed()+"";
		ghzField.setText(ghzString);
		enterGhz.setFont(f);
		ghzField.setFont(f);
		
		JLabel enterPrice = new JLabel("Change price: "); tidy.add(enterPrice);
		JTextField priceField = new JTextField(); tidy.add(priceField);
		String priceString = AddWindow.displayInfo.get(Remove.selectedItem).getPrice()+"";
		priceField.setText(priceString);
		enterPrice.setFont(f);
		priceField.setFont(f);
		
		JLabel statusLable = new JLabel("Status: "); statusLable.setFont(f); tidy.add(statusLable);
		JLabel status = new JLabel(); tidy.add(status);
		
		JButton exit = new JButton("Exit"); exit.setFont(f); tidy.add(exit);
		JButton edit = new JButton("Edit"); edit.setFont(f); tidy.add(edit);

		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Windows.open = false;
			}
		});
		
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
				int idPut = Integer.parseInt(id.getText());
				
				ArrayList<Integer> dummy = new ArrayList<>();
				
				for(int i = 0; i < AddWindow.displayInfo.size(); i++) {
					dummy.add(AddWindow.displayInfo.get(i).getId());
				}

				boolean flag = true;

				for(int i = 0; i < dummy.size(); i++) {
					if(dummy.get(i) == idPut) {
						flag = false;
						break;
					}
					else {
						flag = true;
					}
				}
								
				if(flag == true) {
					AddWindow.displayInfo.get(Remove.selectedItem).setId(idPut);
				}
				if(flag == false) {
					JOptionPane.showMessageDialog(null, "Not valid ID", "ID already in use.", JOptionPane.WARNING_MESSAGE);
					int idTest = AddWindow.displayInfo.get(Remove.selectedItem).getId();
					AddWindow.displayInfo.get(Remove.selectedItem).setId(idTest);
					status.setText("ID was not changed...");
				}
				
				}
				catch(NumberFormatException e1) {
					status.setText("Please enter a number...");
				}
				
				AddWindow.displayInfo.get(Remove.selectedItem).setBrand(brandField.getText());
				
				try {
				int dRam = Integer.parseInt(ramField.getText());
				if(dRam > 0) {
					AddWindow.displayInfo.get(Remove.selectedItem).setRam(dRam);
				}
				else {
					status.setText("Not valid information...");
				}
				
				} catch(NumberFormatException e1) {
					status.setText("Please enter a number...");
				}
				
				try {
					double dGhz = Double.parseDouble(ghzField.getText());
					if(dGhz > 0) {
						AddWindow.displayInfo.get(Remove.selectedItem).setClockSpeed(dGhz);
					}
					else {
						status.setText("Not valid information...");
					}
					} catch(NumberFormatException e1) {
						status.setText("Please enter a number...");
					}
				
				try {
					double dPrice = Double.parseDouble(priceField.getText());
					
					if(dPrice > 0) {
						AddWindow.displayInfo.get(Remove.selectedItem).setPrice(dPrice);
					}
					else {
						status.setText("Not valid information...");
					}
					} catch(NumberFormatException e1) {
						status.setText("Please enter a number...");
					}
				
				status.setText("Details have been changed!");
			}
		});
		
		add(tidy);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {

	}
}
