package test3;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxWindow extends JFrame{

	private JPanel colorPanel;
	private JPanel selectedColorPanel;
	private JComboBox colorBox;
	//private JComboBox purpleBox;
	private JLabel label;
	private JTextField selectedColor;
	private JPanel buttonPanel;
	private JButton yesButton;
	private String[] color = {"Cyan", "Purple"};
	private CyanBosWindow cyanFunction;
	private PurpleBoxWindow purpleFunction;
	private static int countStatus;
	public ComboBoxWindow() {
		runComboBoxWindow();
		cyanFunction = setCyanFunction();
		purpleFunction = setPurpleFunction();
		countStatus = 0;
		
		
	}
	
	public void runComboBoxWindow() {
		setTitle("Trade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		buildColorTradePanel();
		buildSelectedColorPanel();
		buildButtonPanel();
		add(colorPanel, BorderLayout.CENTER);
		add(selectedColorPanel, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
		
		setVisible(true);
	}
	
	public void buildButtonPanel() {
		buttonPanel = new JPanel();
		yesButton = new JButton("YES");
		buttonPanel.add(yesButton);
		yesButton.addActionListener(new YesButtonListener());
	
	}
	
	private class YesButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//varibale to hold the data Color Properties
	
			String colorName = (String) colorBox.getSelectedItem();
	
			System.out.println("You choosed the color : "+ colorName);
			
			setVisible(false);
			if(colorName.equals("Cyan")) {
				//new CyanBosWindow();
				cyanFunction.runCyanBoxWindow();
				
			}
			if(colorName.equals("Purple")) {
				//new PurpleBoxWindow();
				purpleFunction.runPurpleBoxWindow();
				
			}
			
			//System.exit(0);
		}
	}
	
	public void buildColorTradePanel() {
		colorPanel = new JPanel();
		
		colorBox = new JComboBox(color);
		
		colorBox.addActionListener(new ComboBoxListener());
		
		colorPanel.add(colorBox);
	}
	private void buildSelectedColorPanel() {
		
		selectedColorPanel = new JPanel();
		label = new JLabel("You selected : ");
		
		selectedColor = new JTextField(10);
		selectedColor.setEnabled(false);
		
		selectedColorPanel.add(label);
		selectedColorPanel.add(selectedColor);
		
	}
	
	private class ComboBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		String selection = (String) colorBox.getSelectedItem();
		selectedColor.setText(selection);
	}
}
	
	public int returnColorTrade() {
		return countStatus;
	}
	
	public static CyanBosWindow setCyanFunction() {
		return new CyanBosWindow();
	}
	public static PurpleBoxWindow setPurpleFunction() {
		return new PurpleBoxWindow();
	}
}