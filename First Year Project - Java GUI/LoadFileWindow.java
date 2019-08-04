//package GUI;
//
//import java.awt.BorderLayout;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Scanner;
//
//import javax.swing.JButton;
//import javax.swing.JInternalFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollBar;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//
//import javafx.scene.layout.Border;
//
//public class LoadFileWindow extends JInternalFrame{
//	
//	public LoadFileWindow(String text, File file) {
//		super(text);
//		Font f = new Font("Verdana", Font.PLAIN, 30);
//		JPanel p = new JPanel(new BorderLayout());
//		
//		JTextArea display= new JTextArea();
//		JScrollPane sp = new JScrollPane(display);
//		
//		display.setEditable(false);
//		
//		StringBuffer sb = new StringBuffer();
//		
//		try {
//			Scanner output = new Scanner(file);
//			
//			while(output.hasNextLine()) {				
//				sb.append(output.nextLine()+"\n");
//			}
//
//			String s = sb.toString();
//			display.setText(s);
//		
//
//		} catch (FileNotFoundException e1) {
//			JOptionPane.showMessageDialog(null, "File could not be found", "Error 404", JOptionPane.WARNING_MESSAGE);
//
//		}
//		
//
//		JButton exit = new JButton("Exit"); exit.setFont(f); 
//		exit.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				Windows.open = false;
//			}
//		});
//		
//		display.setFont(new Font("Verdana", Font.PLAIN, 15));
//		
//		p.add(sp, BorderLayout.CENTER);
//		p.add(exit, BorderLayout.SOUTH);
//		
//		add(p);
//		setSize(550, 800);
//		setVisible(true);
//	}
//}
