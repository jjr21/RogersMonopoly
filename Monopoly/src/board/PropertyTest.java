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
	private static int diceNumber;
	private static boolean NotHouseProperty = false;
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
		displayDice(dice);
		displayPropertyName();
		getApproveForPurchaseProperty();
		/*
		displayPropertyPrice();
		setOptionPurchase();
		setCostAfterOptionHouse();
		feedDataHouse();
		displayBalance();
		displayOwnHouse();
		*/
		System.exit(0);
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
		int dice, dice2;
		dice = randomDice();
		diceNumber = dice;
		return dice;
	}
	public static int randomDice() {
		int diceR;
		Random random = new Random(); 
		diceR = random.nextInt(11);
		return diceR;
	}
	public static void displayDice(int d) {
		System.out.println("Dice : " + d);
	}
	public static int getDice() {
		return diceNumber;
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
	public static String getNameProperty() {
		String name = propertyInfo.getArray();
		return name;
	}
	public static void setOptionPurchase() {
		
		int optionPurchase = JOptionPane.showConfirmDialog(null, "Would you like to purchase " + propertyInfo.getArray() + " ?",
				"Purchase Property", JOptionPane.YES_NO_OPTION);
		if(optionPurchase == JOptionPane.YES_OPTION) {
			verifyProperty.UpdateOwnProperty(diceNumber,true);
			buyProperty();
		}
		else {
			System.out.println("No");
		} 
	}
	public static void getApproveForPurchaseProperty() {
		if(diceNumber == 0) {
			NotHouseProperty = true;
			System.out.println("$"+propertyInfo.getCost()+" added to your balance");
			balance.AddBalance(propertyInfo.getCost());
			displayBalance();
		}
		if(diceNumber ==2) {
			NotHouseProperty = true;
			System.out.println("COMMUNITY CHEST: you got bonus $300!");
			balance.AddBalance(300);
			displayBalance();
		}
		if(diceNumber == 4) {
			NotHouseProperty = true;
			int tax1, tax2, tax1Percent, tax1Result;
			System.out.println("Your balance" +balance.getBalance());
			tax1 = balance.getBalance();
			tax1Percent = 10;
			tax1Result = (tax1Percent * tax1) /100;
			tax1Result = (1000*tax1Result/1000);
			System.out.println("Tax after calc: " +tax1Result);
			tax2 = 200;
			Object[] taxButton= {tax1Result, tax2};
			JOptionPane.showMessageDialog(null, "Bad news, you have to pay JJ's Tax, there is two kinds way to pay tax");
			int taxChoose = JOptionPane.showOptionDialog(null, "first tax based ten percent of your balance : " + tax1Result +" . Secondly "+
					 "tax costs only " + tax2, "Tax Option", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, taxButton, taxButton[0]);
			if(taxChoose == 0) {
				balance.SubBalance(tax1Result);
			} 
			if(taxChoose ==1) {
				balance.SubBalance(tax2);
			}
			displayBalance();
			
		}
		if(diceNumber ==5) {
			NotHouseProperty = true;
			displayPropertyPrice();
			int optionPurchaseRailRoad = JOptionPane.showConfirmDialog(null, "Would you like to purchase " + propertyInfo.getArray() + " ?",
					"Purchase Property", JOptionPane.YES_NO_OPTION);
			if(optionPurchaseRailRoad == JOptionPane.YES_OPTION) {
				verifyProperty.UpdateOwnProperty(diceNumber,true);
				amountHouse.setNumberHold(1);
				balance.SubBalance(200);
				feedDataHouse();
				displayBalance();
				displayOwnHouse();
				
			}
			else {
				System.out.println("No");
			} 
		}
		if(diceNumber ==7) {
			NotHouseProperty = true;
			System.out.println("CHANCE: you got bonus $100!");
			balance.AddBalance(100);
			displayBalance();
		}
		if(diceNumber ==10) {
			NotHouseProperty = true;
			System.out.println("JAILLLLLLLL");
		}
		if(NotHouseProperty == false) {
			boolean result = checkProperty();
			System.out.println("Before purchase the property, the result of boolean : " + result);
		if (result == false) {
			displayPropertyPrice();
			setOptionPurchase();
			setCostAfterOptionHouse();    
			feedDataHouse();
			displayBalance();
			displayOwnHouse();
		}
		else {
			String input = getNameProperty();
			System.out.println("Player own this property " + input + "Rent : ");
		}
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
	public static boolean getBooleanStatusProperty() {
		int number = getDice();
		boolean status = false;
		//System.out.println("Function getDice :" + number);
		if(number == 1) {
			status = verifyProperty.getStatus1();
		}
		if(number == 3) {
			status = verifyProperty.getStatus3();
		}
		if(number == 6) {
			status = verifyProperty.getStatus6();
		}
		if(number == 8) {
			status = verifyProperty.getStatus8();
		}
		if(number == 9) {
			status = verifyProperty.getStatus9();
		}
		return status;
	}
	public static boolean checkProperty() {
		boolean checkNumber = getBooleanStatusProperty();
		return checkNumber;
	}
	public static void setOptionHouse() {
		if(getBooleanStatusProperty() == true) {
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
		System.out.println("Display boolean status for property : " + diceNumber + " " + getBooleanStatusProperty());
		System.out.println("Count House " + own.getOwn());
	}
}
