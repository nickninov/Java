package singletons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import helperClasses.InternalData;

/*
	The singleton is initialised when getInstance()
	is called. It will return either the old InternalArchive
	object or a new one - if it does not exist.
*/
public class InternalArchive {
	private static InternalArchive internalArchive;
	
	private static ArrayList<InternalData> data = new ArrayList<>();
	
	private InternalArchive() {}
	
	// Load all of the data from the file
	private static void loadData(String internalArchiveFile) {
		File f = new File(internalArchiveFile);		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			try {
				data = (ArrayList) ois.readObject();		
				ois.close();
			} catch (ClassNotFoundException e1) {
				System.out.println(e1.getMessage());
			}
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	// Add internal data to the archive
	public void addData (InternalData internalData) {
		// Check if input is valid
		if(internalData.getTitle().matches("") || internalData.getDescription().matches("")) {
			System.out.println("Invalid input.\n");
		}
		else {
			data.add(internalData);
			System.out.println("Internal data has been added!");
		}
	}
	
	// Remove internal data from the archive
	public void removeData(int index) {
		// Check if index is valid and if there is data
		if(index <= data.size() && index  > 0 && !data.isEmpty()) {
			data.remove(index - 1);
			System.out.println("Data at index " + index + " has been removed!");
		}
		else {
			System.out.println("No data to remove.");
		}
	}
	
	// Display all of the data in the archive
	public void showInternalData() {
		int i = 1;
		// Check if empty
		if (data.isEmpty()) {
			System.out.println("No Internal data available.");
		}
		else {
			for(InternalData element: data) {
				System.out.println("Index: "+i+ "\n");
				element.show();
				System.out.println("========================================================================================\n\n");
				i++;
			}
		}
	}
	
	// Edit internal data from the archive
	public void editData(int index, InternalData internalData) {
		// Check if index is valid and if there is data
		if(index <= data.size() && index > 0 && !data.isEmpty()) {
			// Check if input is valid
			if(internalData.getTitle().matches("") || internalData.getDescription().matches("")) {
				System.out.println("Invalid input.\n");
			}
			else {
				data.set(index - 1, internalData);
				System.out.println("Data has been edited!");
			}
			
		}
		else {
			System.out.println("No Internal data to edit.");
		}
	}
		
	// Allow multi-threaded uses
	synchronized public static InternalArchive getInstance() {
		if(internalArchive == null) {
			internalArchive = new InternalArchive();
			loadData("/Users/nick/Desktop/Data/InternalData.ser");
		}		
		return internalArchive;
	}
}