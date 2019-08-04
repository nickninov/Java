package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

//JInternalFrame
public class Remove extends JInternalFrame {

static int selectedItem;
	public Remove(String text) {
		super(text);
		Font f = new Font("Verdana", Font.PLAIN, 30);
		
		JList jlist = new JList(AddWindow.displayInfo.toArray());
		
		JScrollPane scroll = new JScrollPane(jlist);
		jlist.setFont(f);

		Windows win = new Windows();
		JPanel tidy = new JPanel(new BorderLayout());
		JButton exit = new JButton("Exit");
		exit.setFont(f);

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Windows.open = false;
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

		JButton delete = new JButton("Delete");
		buttonPanel.add(delete);
		delete.setFont(f);

		JButton edit = new JButton("Edit");
		buttonPanel.add(edit);
		edit.setFont(f);
		
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					selectedItem = jlist.getSelectedIndex();
					AddWindow.displayInfo.remove(selectedItem);
					Windows.open = false;

					dispose();

					JOptionPane.showMessageDialog(null, "Item successfully deleted!", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IndexOutOfBoundsException eDos) {
					JOptionPane.showMessageDialog(null, "Please select an item! ", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					selectedItem = jlist.getSelectedIndex();
					
					Edit eWindow = new Edit("Edit ");
					Windows.desktop.add(eWindow);
					
					dispose();
					
				} catch (IndexOutOfBoundsException e3) {
					JOptionPane.showMessageDialog(null, "Please select an item! ", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		buttonPanel.add(exit);
		tidy.add(scroll, BorderLayout.CENTER);
		tidy.add(buttonPanel, BorderLayout.SOUTH);

		add(tidy);
		pack();
		setVisible(true);

	}
}
