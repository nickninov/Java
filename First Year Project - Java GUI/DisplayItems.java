package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DisplayItems extends JInternalFrame {
	
	public DisplayItems(String text) {
		super(text);
		
		Font f = new Font("Verdana", Font.PLAIN, 30);
		
		
		
		JList jlist = new JList(AddWindow.displayInfo.toArray());
		JScrollPane scroll = new JScrollPane(jlist);
		jlist.setFont(f);
		
		Windows win = new Windows();
		JPanel tidy = new JPanel(new BorderLayout());
		JButton exit = new JButton("Exit"); exit.setFont(f); 
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Windows.open = false;
			}
		});
		
		
		tidy.add(scroll, BorderLayout.CENTER);
		tidy.add(exit, BorderLayout.SOUTH);
		
		add(tidy);
		pack();
		setVisible(true);
		
	}
}
