package test4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class PurpleBoxWindow extends JFrame{
	private JPanel purplePanel;
	private JPanel selectedPurplePanel;
	private JComboBox purpleBox;
	private JLabel labelPurple;
	private JTextField selectedPurple;
	private JButton noButton;
	private JPanel purpleButtonPanel;
	private String[] Purple = {"Mediterranean Ave", "Baltic Ave"};
	
	public PurpleBoxWindow() {
		//runPurpleBoxWindow();
	}
	public void runPurpleBoxWindow() {
	
		
		setTitle("Purple");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		buildPurpleTradePanel();
		buildSelectedPurplePanel();
		buildPurpleButtonPanel();
		add(purplePanel, BorderLayout.CENTER);
		add(selectedPurplePanel, BorderLayout.EAST);
		add(purpleButtonPanel, BorderLayout.SOUTH);
		pack();
		
		setVisible(true);
		
	}
	public void buildPurpleButtonPanel() {
		purpleButtonPanel = new JPanel();
		noButton = new JButton("OK");
		
		noButton.addActionListener(new YesPurpleButtonListener());
		
		purpleButtonPanel.add(noButton);
		
	}
	
	private class YesPurpleButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String purpleName = (String) purpleBox.getSelectedItem();
			System.out.println("You choosed the Purple Property: "+ purpleName);
			setVisible(false);
			System.exit(0);
		}
	}
	public void buildPurpleTradePanel() {
		purplePanel = new JPanel();
		
		purpleBox = new JComboBox(Purple);
		
		purpleBox.addActionListener(new PurpleBoxListener());
		
		purplePanel.add(purpleBox);
	}
	
	private void buildSelectedPurplePanel()
	{
		selectedPurplePanel = new JPanel();
		labelPurple = new JLabel("You selected CYAN : ");
		selectedPurple = new JTextField(10);
		selectedPurple.setEnabled(false);
		selectedPurplePanel.add(labelPurple);
		selectedPurplePanel.add(selectedPurple);
	}
	private class PurpleBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		String selection2 = (String) purpleBox.getSelectedItem();
		selectedPurple.setText(selection2);
	}
}

}