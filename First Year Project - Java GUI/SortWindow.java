package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;

public class SortWindow extends JInternalFrame{
	
	public SortWindow(String text) {
	
		
		super(text);
		
		Font f = new Font("Verdana", Font.PLAIN, 30);
		
		JList jlist = new JList(AddWindow.displayInfo.toArray());
		JScrollPane scroll = new JScrollPane(jlist);
		jlist.setFont(f);
		
		Windows win = new Windows();
		JPanel tidy = new JPanel(new BorderLayout());
		JButton exit = new JButton("Exit"); exit.setFont(f); 
		
		ButtonGroup rbm = new ButtonGroup();
		JPanel p = new JPanel(new GridLayout(7, 1));
		
		JRadioButton sId = new JRadioButton("Sort by ID (Ascending order)"); rbm.add(sId); p.add(sId);
		sId.setFont(f);
		
		JRadioButton sId1 = new JRadioButton("Sort by ID (Descending order)"); rbm.add(sId1); p.add(sId1);
		sId1.setFont(f);
		
		JRadioButton sRam = new JRadioButton("Sort by RAM"); rbm.add(sRam); p.add(sRam);
		sRam.setFont(f);
		
		JRadioButton sGhz = new JRadioButton("Sort by Clock Speed"); rbm.add(sGhz); p.add(sGhz);
		sGhz.setFont(f);
		
		JRadioButton sPrice = new JRadioButton("Sort by Price"); rbm.add(sPrice); p.add(sPrice);
		sPrice.setFont(f);
		
		JRadioButton sBrand = new JRadioButton("Sort by Brand (A-Z)"); rbm.add(sBrand); p.add(sBrand);
		sBrand.setFont(f);
		
		JRadioButton sBrand1 = new JRadioButton("Sort by Brand (Z-A)"); rbm.add(sBrand1); p.add(sBrand1);
		sBrand1.setFont(f);
		sRam.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Comparator<Laptop> c = new Comparator<Laptop>() {
					@Override
					public int compare(Laptop o1, Laptop o2) {
						
						if(o1.getRam() > o2.getRam()) {
							return 1;
						}
						if(o1.getRam() < o2.getRam()) {
							return -1;
						}
						return 0;
					}
					
				};
				
				Collections.sort(AddWindow.displayInfo,c);
				
				dispose();			
				JOptionPane.showMessageDialog(null, "Items successfully sorted by RAM!", "Success", JOptionPane.INFORMATION_MESSAGE);
			
				Windows.desktop.add(new DisplayItems("Collection"));
			
			}
		});


		sGhz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Comparator<Laptop> c = new Comparator<Laptop>() {
					@Override
					public int compare(Laptop o1, Laptop o2) {
						
						if(o1.getClockSpeed() > o2.getClockSpeed()) {
							return 1;
						}
						if(o1.getClockSpeed() < o2.getClockSpeed()) {
							return -1;
						}
						return 0;
					}
					
				};
				
				Collections.sort(AddWindow.displayInfo,c);
				
				dispose();			
				JOptionPane.showMessageDialog(null, "Items successfully sorted by Clock Speed!", "Success", JOptionPane.INFORMATION_MESSAGE);
		
				Windows.desktop.add(new DisplayItems("Collection"));
			}
		});
		
		
		sPrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Comparator<Laptop> c = new Comparator<Laptop>() {
					@Override
					public int compare(Laptop o1, Laptop o2) {
						
						if(o1.getPrice() > o2.getPrice()) {
							return 1;
						}
						if(o1.getPrice() < o2.getPrice()) {
							return -1;
						}
						return 0;
					}
					
				};
				
				Collections.sort(AddWindow.displayInfo,c);
				
				dispose();			
				JOptionPane.showMessageDialog(null, "Items successfully sorted by Price!", "Success", JOptionPane.INFORMATION_MESSAGE);
			
				Windows.desktop.add(new DisplayItems("Collection"));

			}
		});
		
		sBrand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Comparator<Laptop> c = new Comparator<Laptop>() {
						@Override
						public int compare(Laptop o1, Laptop o2) {
						return o1.getBrand().compareTo(o2.getBrand());
					}
				};
				
				Collections.sort(AddWindow.displayInfo,c);
				
				dispose();			
				JOptionPane.showMessageDialog(null, "Items successfully sorted by Brand (A-Z)!", "Success", JOptionPane.INFORMATION_MESSAGE);
			
				Windows.desktop.add(new DisplayItems("Collection"));

			}
		});
		
		sId.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			Comparator<Laptop> c = new Comparator<Laptop>() {
				
				@Override
				public int compare(Laptop o1, Laptop o2) {
					if(o1.getId() > o2.getId()) {
						return 1;
					}
					if(o1.getId() < o2.getId()) {
						return -1;
					}
					return 0;
				}
			};
				
				Collections.sort(AddWindow.displayInfo, c);
				
				dispose();
				JOptionPane.showMessageDialog(null, "Items successfully sorted by ID (Ascending order)!", "Success", JOptionPane.INFORMATION_MESSAGE);
				
				Windows.desktop.add(new DisplayItems("Collection"));
			}
		});
		
		sId1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Comparator<Laptop> c = new Comparator<Laptop>() {
					
					@Override
					public int compare(Laptop o1, Laptop o2) {
						
						if(o2.getId() > o1.getId()) {
							return 1;
						}
						if(o2.getId() < o1.getId()) {
							return -1;
						}
						return 0;
					}
				};
				
				Collections.sort(AddWindow.displayInfo, c);
				
				dispose();
				JOptionPane.showMessageDialog(null, "Items successfully sorted by ID (Descending order)!", "Success", JOptionPane.INFORMATION_MESSAGE);
				
				Windows.desktop.add(new DisplayItems("Collection"));
			}
		});
		
		
		sBrand1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Comparator<Laptop> c = new Comparator<Laptop>() {
						@Override
						public int compare(Laptop o1, Laptop o2) {
						return o2.getBrand().compareTo(o1.getBrand());
					}
				};
				
				Collections.sort(AddWindow.displayInfo,c);
				
				dispose();			
				JOptionPane.showMessageDialog(null, "Items successfully sorted by Brand (Z-A)!", "Success", JOptionPane.INFORMATION_MESSAGE);
			
				Windows.desktop.add(new DisplayItems("Collection"));

			}
		});
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Windows.open = false;
			}
		});
		
//		tidy.add(scroll, BorderLayout.CENTER);
		tidy.add(exit, BorderLayout.SOUTH);
		tidy.add(p, BorderLayout.NORTH);
		
		add(tidy);
		pack();
		setVisible(true);
	}
}
