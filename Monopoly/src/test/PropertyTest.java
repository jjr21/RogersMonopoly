package test;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PropertyTest {
	private static PropertyPrice propertyInfo;
	private static PlayerBalance balance;
	//private static PlayerBalance balance2;
	private static OwnHouse own;

	public static void main(String[] args) {
		propertyInfo = setPropertyPrice();
		balance = setPlayerBalance();
		own = setOwnHouse();
		int dice = setDice();
		displayWelcome();
		setStartGameBalance();
		displayBalance();
		setMatchProperty(dice);
		displayPropertyName();
		displayPropertyPrice();
		setOptionPurchase();
	}
	public static PropertyPrice setPropertyPrice() {
		return new PropertyPrice();
	}
	public static PlayerBalance setPlayerBalance() {
		return new PlayerBalance();
	}
	public static OwnHouse setOwnHouse() {
		return new OwnHouse();
	}
	public static void displayWelcome() {
		System.out.println("Welcome JJ's Design Monopoly");
	}
	public static void setStartGameBalance() {
		balance.setBlance(1000);
	}
	public static void displayBalance() {
		System.out.println("Player 1's balance : " + balance.getBalance());
	}
	public static int setDice() {
		Random random = new Random(); 
		int dice, dice2;
		dice = random.nextInt(7);
		System.out.println("Dice : " + dice);
		return dice;
	}
	public static void setMatchProperty(int d) {
		propertyInfo.MatchBoxArray(d); //Find Property's name
		propertyInfo.MatchArrayPrice(d); //find Property's cost info
	}
	public static void displayPropertyName() {
		System.out.println("Property Name: " + propertyInfo.getArray());
	}
	public static void displayPropertyPrice() {
		System.out.println("Property Costs: " + propertyInfo.getCost());
	}
	public static void setOptionPurchase() {
		System.out.println("Do you want to purchase property?");
		int optionPurchase = JOptionPane.showConfirmDialog(null, "Would you like to purchase " + propertyInfo.getArray() + " ?",
				"Purchase Property", JOptionPane.YES_NO_OPTION);
		if(optionPurchase == JOptionPane.YES_OPTION) {
			setOptionHouse();
				
		}
		else {
			System.out.println("No");
		}
		  
	}
	public static void setOptionHouse() {
		Object[] buttons = {1,2,3,4,"Hotel"};
		int optionHouse = JOptionPane.showOptionDialog(null, "How much do you would like to purchase " + propertyInfo.getArray() + " ?",
				"Purchase Property", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, buttons, buttons[0]);
		if(optionHouse ==0) {
			System.out.println(1);
		}
		if(optionHouse ==1) {
			System.out.println(2);
		}
		if(optionHouse ==2) {
			System.out.println(3);
		}
		if(optionHouse ==3) {
			System.out.println(4);
		}
		if(optionHouse ==4) {
			System.out.println("Hotel");
		}
	}

	
	
}
