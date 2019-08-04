package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;


public class Windows extends JFrame{
	
public static boolean open = false;

public static BackgroundImage desktop = new BackgroundImage();

public static JTextField searchText = new JTextField();

	public static void menuWindow(){	
		JFrame win = new JFrame();
		Font f = new Font("Verdana", Font.PLAIN, 40);
		
		Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

		win.setSize(d);
		win.setLocationRelativeTo(null);
		win.setDefaultCloseOperation(EXIT_ON_CLOSE);

		win.setTitle("Menu");
		
		JPanel layout = new JPanel(new BorderLayout());
		
		JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
		layout.add(buttonPanel, BorderLayout.SOUTH);
		
		
//		BackgroundImage desktop = new BackgroundImage();
		layout.add(desktop, BorderLayout.CENTER);
		
	
		JPanel searchPanel = new JPanel(new BorderLayout());
		JButton searchButton = new JButton("Search ID"); searchPanel.add(searchButton, BorderLayout.EAST); searchButton.setFont(f);
		searchPanel.add(searchText, BorderLayout.CENTER); searchText.setFont(f);
		
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(AddWindow.displayInfo.size() > 0) {
				if(open == false) {
					
							
					SearchWindow search = new SearchWindow("Result");
					desktop.add(search);
					open = true;
				}
			}
				else {
					JOptionPane.showMessageDialog(null, "Collection is empty. Please add items.", "Empty", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		layout.add(searchPanel, BorderLayout.NORTH);
		
		JButton addLaptop = new JButton("Add Laptop"); addLaptop.setFont(f);
		buttonPanel.add(addLaptop);
		
		JButton removeLaptop = new JButton("Remove/Edit Laptop"); removeLaptop.setFont(f);
		buttonPanel.add(removeLaptop);
		
		JButton viewCurrentCollection = new JButton("View current collection"); viewCurrentCollection.setFont(f);
		buttonPanel.add(viewCurrentCollection);
		
		JButton saveCurrentCollection = new JButton("Save current collection"); saveCurrentCollection.setFont(f);
		buttonPanel.add(saveCurrentCollection);
		
		JButton loadSavedCollection = new JButton("Load selected collection"); loadSavedCollection.setFont(f);
		buttonPanel.add(loadSavedCollection);
		
		JButton sort = new JButton("Sort current collection"); sort.setFont(f);	
		buttonPanel.add(sort);
		
//		Add laptop
		addLaptop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(open == false) {
					AddWindow addLaptopWindow = new AddWindow("Add Laptop");
					desktop.add(addLaptopWindow);
					open = true;
				}
			}
		});
				
//		viewCurrentCollection
		viewCurrentCollection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(open == false) {
					if(AddWindow.displayInfo.size() == 0) {
						JOptionPane.showMessageDialog(null, "Collection is empty. Please add items.", "Empty", JOptionPane.WARNING_MESSAGE);

					}
					else {
						DisplayItems displayCollection = new DisplayItems("Collection");
						desktop.add(displayCollection);
						open = true;
					}
				}

			}
		});
		
//		removeLaptop
		removeLaptop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(open == false) {
					if(AddWindow.displayInfo.size() == 0) {
						JOptionPane.showMessageDialog(null, "No items have been added!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
					Remove removeItemFromCollection = new Remove("Delete/Edit item from collection");
					desktop.add(removeItemFromCollection);
					open = true;
					}
				}	
			}
		});
		
//		Sort
		sort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(AddWindow.displayInfo.size() == 0) {
					JOptionPane.showMessageDialog(null, "Collection is empty. Please add items.", "Empty", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(open == false) {
					SortWindow sortWindow = new SortWindow("Sort");
					desktop.add(sortWindow);
					open = true;
					}
				}
			}
		});
		
//		loadSavedCollection
		loadSavedCollection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(open == false) {
				JButton open = new JButton();
				
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("Load file");

				if(fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {

					File f = new File(fc.getSelectedFile().getAbsoluteFile().toString());
					
					
					try {
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
						
						try {
							
							AddWindow.displayInfo = (ArrayList) ois.readObject();
							
							ois.close();
							
							DisplayItems di = new DisplayItems("Collection");
							desktop.add(di);
						} catch (ClassNotFoundException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);

						}
						
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "File not found", "Error",JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "File cannot be opened", "Error",JOptionPane.ERROR_MESSAGE);
					}
					}
				}
			}
		});
		
//		saveCurrentCollection
		saveCurrentCollection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(open == false) {
					if(AddWindow.displayInfo.size() == 0) {
						JOptionPane.showMessageDialog(null, "Collection empty", "Collection empty", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
				JButton choose = new JButton("Choose");
				
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("Save file");
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
				if(fc.showOpenDialog(choose) == JFileChooser.APPROVE_OPTION) {
					
					String fileName = JOptionPane.showInputDialog(null, "Please enter file name", "File name", JOptionPane.PLAIN_MESSAGE);
					String pathName = fc.getSelectedFile().getAbsolutePath().toString()+"/"+fileName;
					
					
					File savingFile = new File(pathName);
					
					try {
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savingFile+".ser"));
						oos.writeObject(AddWindow.displayInfo);
						
						oos.close();
						
						JOptionPane.showMessageDialog(null, "File "+fileName+" successfully created!", "Success", JOptionPane.INFORMATION_MESSAGE);
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			  }
				}	
	    	}
		});
		
		win.add(layout);
		win.setVisible(true);
	}	
	public static void main(String[] args) {
		menuWindow();
	}
}