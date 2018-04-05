package test3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CyanBosWindow extends JFrame{
	private JPanel cyanPanel;
	private JPanel selectedCyanPanel;
	private JComboBox cyanBox;
	private JLabel labelCyan;
	private JTextField selectedCyan;
	private JButton noButton;
	private JPanel cyanButtonPanel;
	private String[] Cyan = {"Oriental Ave", "Vermont Ave", "Connecticut Ave"};
	
	public CyanBosWindow() {
		//runCyanBoxWindow();
	}
	public void runCyanBoxWindow() {
	
		
		setTitle("Cyan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		buildCyanTradePanel();
		buildSelectedCyanPanel();
		buildCyanButtonPanel();
		add(cyanPanel, BorderLayout.CENTER);
		add(selectedCyanPanel, BorderLayout.EAST);
		add(cyanButtonPanel, BorderLayout.SOUTH);
		pack();
		
		setVisible(true);
		
	}
	public void buildCyanButtonPanel() {
		cyanButtonPanel = new JPanel();
		noButton = new JButton("OK");
		
		noButton.addActionListener(new YesCyanButtonListener());
		
		cyanButtonPanel.add(noButton);
		
	}
	
	private class YesCyanButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cyanName = (String) cyanBox.getSelectedItem();
			System.out.println("You choosed the Cyan Property: "+ cyanName);
			setVisible(false);
			//System.exit(0);
		}
	}
	public void buildCyanTradePanel() {
		cyanPanel = new JPanel();
		
		cyanBox = new JComboBox(Cyan);
		
		cyanBox.addActionListener(new CyanBoxListener());
		
		cyanPanel.add(cyanBox);
	}
	
	private void buildSelectedCyanPanel()
	{
		selectedCyanPanel = new JPanel();
		labelCyan = new JLabel("You selected CYAN : ");
		selectedCyan = new JTextField(10);
		selectedCyan.setEnabled(false);
		selectedCyanPanel.add(labelCyan);
		selectedCyanPanel.add(selectedCyan);
	}
	private class CyanBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		String selection2 = (String) cyanBox.getSelectedItem();
		selectedCyan.setText(selection2);
	}
}

}
