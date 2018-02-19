package board;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PropertyTest {
	private static PropertyPrice propertyInfo;
	private static PlayerBalance balance;
	//private static PlayerBalance balance2;
	private static OwnHouse own;
	private static AmountHouseHold amountHouse;
	private static VerifyOwnProperty verifyProperty;
	public static void main(String[] args) {
		propertyInfo = setPropertyPrice();
		balance = setPlayerBalance();
		own = setOwnHouse();
		amountHouse = setAmountHouse();
		verifyProperty = setVerifyProperty();
		int dice = setDice();
		displayWelcome();
		setStartGameBalance();
		displayBalance();
		setMatchProperty(dice);
		displayPropertyName();
		displayPropertyPrice();
		setOptionPurchase();
		setCostAfterOptionHouse();
		feedDataHouse();
		displayBalance();
		displayOwnHouse();
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
	public static AmountHouseHold setAmountHouse() {
		return new AmountHouseHold();
	}
	public static VerifyOwnProperty setVerifyProperty() {
		return new VerifyOwnProperty();
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
		//dice = random.nextInt(7);
		dice = 1;
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
		System.out.println("Property Costs: " + propertyInfo.getPropertyCost());
	}
	public static void displayPropertyHousePrice() {
		System.out.println("Property Costs: " + propertyInfo.getCost());
	}
	public static void setOptionPurchase() {
		
		int optionPurchase = JOptionPane.showConfirmDialog(null, "Would you like to purchase " + propertyInfo.getArray() + " ?",
				"Purchase Property", JOptionPane.YES_NO_OPTION);
		if(optionPurchase == JOptionPane.YES_OPTION) {
			verifyProperty.UpdateOwnProperty(true);
			buyProperty();
			
				
		}
		else {
			System.out.println("No");
		}
		  
	}
	public static void buyProperty() {
		balance.SubBalance(propertyInfo.getPropertyCost());
		System.out.println("Your balance after bought property, " + balance.getBalance());
		System.out.println("Congrats, you bought the property, you may buy house");
		int optionPurchase = JOptionPane.showConfirmDialog(null, "Would you like to purchase House" + propertyInfo.getArray() + " ?",
				"Purchase Property House ", JOptionPane.YES_NO_OPTION);
		if(optionPurchase == JOptionPane.YES_OPTION) {
			
			setOptionHouse();
				
		}
		else {
			System.out.println("No");
		}
		
		
	}
	public static void setOptionHouse() {
		if(verifyProperty.getStatus() == true) {
		int excaltyNumber =0;
		Object[] buttons = {1,2,3,4,"Hotel"};
		System.out.println(propertyInfo.getArray() + " house costs " + propertyInfo.getCost());
		int optionHouse = JOptionPane.showOptionDialog(null, "How much do you would like to purchase " + propertyInfo.getArray() + " ?",
				"Purchase Property", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, buttons, buttons[0]);
		if(optionHouse ==0) {
			excaltyNumber = 1;
		}
		if(optionHouse ==1) {
			excaltyNumber = 2;
		}
		if(optionHouse ==2) {
			excaltyNumber = 3;
		}
		if(optionHouse ==3) {
			excaltyNumber = 4;
		}
		if(optionHouse ==4) {
			excaltyNumber = 5;
		}
		int buyNumber;
		amountHouse.setNumberHold(excaltyNumber);
		buyNumber = amountHouse.getNumberHold();
		}
		
	}
	public static int setCostAfterOptionHouse() {
		int number;
		number =  amountHouse.getNumberHold();
		number = number * propertyInfo.getCost();
		return number;
		
	}
	public static void feedDataHouse() {
		own.OwnMediterranean(amountHouse.getNumberHold());
		SubBalance();
		
	}
	public static void SubBalance() {
		balance.SubBalance(setCostAfterOptionHouse());
	}
	public static void displayOwnHouse() {
		System.out.println("Display boolean status for property : " + verifyProperty.getStatus());
		System.out.println("Count House " + own.getOwn());
	}

	
	
}
