package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchWindow extends JInternalFrame {

	public SearchWindow(String text) {
		
		super(text);
		Font f = new Font("Verdana", Font.PLAIN, 40);

		JPanel p = new JPanel(new BorderLayout());
		JTextField result = new JTextField(); result.setFont(f); p.add(result, BorderLayout.CENTER); result.setEditable(false);
		JButton exit = new JButton("Exit"); exit.setFont(f); p.add(exit, BorderLayout.SOUTH);
		
		ArrayList<Integer> idList = new ArrayList<>();
		for(Laptop l: AddWindow.displayInfo) {
			idList.add(l.getId());
		}
		
		String s = Windows.searchText.getText();
		int id = Integer.parseInt(s);
		
		for(int i = 0; i < idList.size(); i++) {
			if(idList.get(i) == id) {
				result.setText(AddWindow.displayInfo.get(i).toString());
				break;
			}
			else {
				result.setText("ID not found...");
			}
		}
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Windows.open = false;
			}
		});
		
		add(p);
		pack();
		setVisible(true);
	}
}
