 package test;

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
	private static DiceNumber DiceHolder;
	private static PropertyRentCharge propertyRent;
	private static Jail stuckJail;
	private static int diceNumber;
	private static boolean NotHouseProperty = false;
	private static boolean continueDice = false;
	private static boolean game = true;
	private static boolean jailRule = false;
	public static void main(String[] args) {
		propertyInfo = setPropertyPrice();
		balance = setPlayerBalance();
		own = setOwnHouse();
		amountHouse = setAmountHouse();
		verifyProperty = setVerifyProperty();
		DiceHolder = setDiceHolder();
		propertyRent = setPropertyRent();
		stuckJail = getJailRule(); 
		setStartGameBalance();
		runGame();
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
	public static PropertyRentCharge setPropertyRent() {
		return new PropertyRentCharge();
		
	}
	public static void setStartGameBalance() {
		balance.setBlance(1000);
	}
	public static void displayBalance() {
		System.out.println("Player 1's balance : " + balance.getBalance());
	}
	public static DiceNumber setDiceHolder() {
		return new DiceNumber();
	}
	public static void runGame() {
		while(game = true) {
		int dice = setDice();
		displayWelcome();
		displayBalance();
		setMatchProperty(dice);
		displayDice(dice);
		displayPropertyName();
		getApproveForPurchaseProperty();
		CheckBalanceGameOver();
		}
	}
	public static int setDice() {
		int max, totalDice, dice, dice2, OverAgain;
		if(continueDice == false) {
		dice = randomDice();
		dice2 = randomDice();
		if(jailRule == true) {
		getJailStatus(1);
		}
		if(jailRule == false) {
		max = 10;
		totalDice = dice + dice2;
		DiceHolder.addDiceNumber(totalDice);
		System.out.println("First dice :" + dice + " second dice :" + dice2 + " \n Total for this : " + totalDice);
		int CountDice = DiceHolder.getDice();
		if(CountDice >= max) {
			OverAgain = CountDice - max;
			System.out.println("OverAgain :" + OverAgain);
			totalDice = 0 + OverAgain;
			System.out.println("total "+ totalDice);
			DiceHolder.setDiceNumber(totalDice);
		}
		diceNumber = DiceHolder.getDice();
		}
		}
	
		return diceNumber;
	}
	public static int randomDice() {
		int diceR;
		Random random = new Random(); 
		diceR = random.nextInt(4);
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
	public static Jail getJailRule() {
		return new Jail();
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
			JOptionPane.showMessageDialog(null,"GOOOO $"+propertyInfo.getCost()+" added to your balance");
			balance.AddBalance(propertyInfo.getCost());
			displayBalance();
		}
		if(diceNumber ==2) {
			NotHouseProperty = true;
			JOptionPane.showMessageDialog(null,"COMMUNITY CHEST: you got bonus $300!");
			balance.AddBalance(300);
			displayBalance();
		}
		if(diceNumber == 4) {
			NotHouseProperty = true;
			JOptionPane.showMessageDialog(null, "TAXXXXX");
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
			boolean resultRailRoad = checkProperty();
			System.out.println("Before purchase the property, the result of boolean : " + resultRailRoad);
			if(resultRailRoad == false) {
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
		}
		if(diceNumber ==7) {
			NotHouseProperty = true;
			JOptionPane.showMessageDialog(null,"CHANCE: you got bonus $100!");
			balance.AddBalance(100);
			displayBalance();
		}
		if(diceNumber ==10) {
			NotHouseProperty = true;
			System.out.println("JAILLLLLLLL");
			jailRule = true;
			stuckJail.setJail(jailRule);
			
			
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
			propertyRentCharge();
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
		if (checkNumber == true) {
			JOptionPane.showMessageDialog(null,"SOLD OUT for property! You have to pay rent!");
		}
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
	public static void propertyRentCharge() {
		System.out.println("Rent Costs");
		chargeRent();
	}
	public static void chargeRent() {
		int numberOfHouse;
		int costRent=0;
		numberOfHouse = amountHouse.getNumberHold();
		if(diceNumber == 1) {
			 propertyRent.PropertyRent(1, numberOfHouse);
			 costRent = propertyRent.getRent1();
				
		}
		if(diceNumber == 3) {
			propertyRent.PropertyRent(3, numberOfHouse);
			costRent = propertyRent.getRent3();
		}
		if(diceNumber == 5) {
			propertyRent.PropertyRent(5, 0);
			costRent = propertyRent.getRent5();
		}
		if(diceNumber == 6) {
			propertyRent.PropertyRent(6, numberOfHouse);
			costRent = propertyRent.getRent6();
		}
		if(diceNumber == 8) {
			propertyRent.PropertyRent(8, numberOfHouse);
			costRent = propertyRent.getRent8();
		}
		if(diceNumber == 9) {
			propertyRent.PropertyRent(9, numberOfHouse);
			costRent = propertyRent.getRent9();
		}
		JOptionPane.showMessageDialog(null,"Cost of rent : " + costRent);
	}
	public static boolean getJailStatus(int i) {
		int x = 0;
		x += i;
		if (x ==3) {
			jailRule = false;
			stuckJail.setJail(jailRule);
			
		}
		jailRule = stuckJail.getJail();
		return jailRule;
	}
	public static void CheckBalanceGameOver() {
		if(balance.getBalance() < 0 || balance.getBalance() == 0) {
			System.out.println("Congrats you won!");
			continueDice = true;
			System.exit(0);
		
		}
		else {
			JOptionPane.showMessageDialog(null, "Next Turn");
			NotHouseProperty = false;
		}
	}
}
