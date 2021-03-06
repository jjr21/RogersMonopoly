  package test;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.concurrent.ThreadLocalRandom;
public class PropertyTest {
	private static PropertyPrice propertyInfo;
	private static PlayerBalance balance;
	private static PlayerBalance balance2;
	//private static PlayerBalance balance3;
	//private static PlayerBalance balance4;
	private static OwnHouse own;
	private static AmountHouseHold amountHouse;
	private static VerifyOwnProperty verifyProperty;
	private static DiceNumber DiceHolder;
	private static PropertyRentCharge propertyRent;
	private static Jail stuckJail;
	private static HoldNumberDicesJail numberjail;
	private static ColorProperties colorLand;
	private static int diceNumber;
	private static boolean NotHouseProperty = false;
	private static boolean continueDice = false;
	private static boolean game = true;
	private static boolean jailRule = false;
	private static int x = 0;
	private static boolean sameNumberJail = true;
	private static int holdTurn;
	public static void main(String[] args) {
		propertyInfo = setPropertyPrice();
		balance = setPlayerBalance();
		balance2 = setPlayerBalance();
		//balance3 = setPlayerBalance();
		//balance4 = setPlayerBalance();
		own = setOwnHouse();
		amountHouse = setAmountHouse();
		verifyProperty = setVerifyProperty();
		DiceHolder = setDiceHolder();
		propertyRent = setPropertyRent();
		stuckJail = getJailRule();    
		numberjail = setNumberJails();
		colorLand = setColorLand();
		setTurn();
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
	public static ColorProperties setColorLand() {
		return new ColorProperties();
	}
	public static void setStartGameBalance() {
		balance.setBlance(1000);
		balance2.setBlance(1000);
	}
	public static void displayBalance() {
		if(holdTurn == 1){
			System.out.println("Player 1's balance : " + balance.getBalance());
		}
		if (holdTurn ==2){
			System.out.println("Player 2's balance : " + balance2.getBalance());
		}
		
	}
	public static void setTurn() {
		holdTurn = 1;
	}
	public static DiceNumber setDiceHolder() {
		return new DiceNumber();
	}
	public static HoldNumberDicesJail setNumberJails() {
		return new HoldNumberDicesJail();
	}
	public static void verifyPlayerBalance(int turn) {
		if (turn == 1) {
			System.out.println("player " + turn + " balance : "+ balance.getBalance());
		}
		if(turn == 2) {
			System.out.println("player " + turn + " balance : " + balance2.getBalance());
		}
	}
public static void SubBalance(int turn) {
	if (turn == 1) {
		balance.SubBalance(setCostAfterOptionHouse());
		System.out.println("After sub balance, player " + turn + " balance : "+ balance.getBalance());
	}
	if(turn == 2) {
		balance2.SubBalance(setCostAfterOptionHouse());
		System.out.println("After sub balance, player " + turn + " balance : " + balance2.getBalance());
	}
		
	}
public static void AddBalance(int turn) {
	if (turn == 1) {
		balance.AddBalance(setCostAfterOptionHouse());
		System.out.println("After add balance, player " + turn + " balance : "+ balance.getBalance());
	}
	if(turn == 2) {
		balance2.AddBalance(setCostAfterOptionHouse());
		System.out.println("After add balance, player " + turn + " balance : " + balance2.getBalance());
	}
		
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
		
		totalDice = getTurnDice();
		if(continueDice == false) {
		dice = randomDice();
		dice2 = randomDice();
		if(jailRule == true) {
		getJailStatus(dice, dice2);
		//Jail result below here
		if(sameNumberJail = false) {
			System.out.println("Test True Jail");
			max = 10;
			dice = numberjail.getNumberJailA();
			dice2 = numberjail.getNumberJailB();
			totalDice = dice + dice2;
			DiceHolder.addDiceNumber(totalDice);
			System.out.println("First dice :" + dice + " second dice :" + dice2 + " \n Total for this : " + totalDice);
			int CountDice = totalDice;
			if(CountDice > max) {
				OverAgain = CountDice - max;
				System.out.println("OverAgain :" + OverAgain);
				totalDice = 0 + OverAgain;
				System.out.println("total "+ totalDice);
				DiceHolder.setDiceNumber(totalDice);
				PassGo();
			}
			diceNumber = DiceHolder.getDice();
		}
		}
		//not related to jail result below here 
		if(jailRule == false) {
		max = 10;
		totalDice = dice + dice2;
		if (holdTurn == 1) {
			DiceHolder.addDiceNumber(totalDice);
		}
		if (holdTurn == 2) {
			DiceHolder.addDiceNumber2(totalDice);
		}
		
		if(holdTurn ==1) {
			DiceHolder.setHoldNumber1(totalDice);
		}
		if(holdTurn == 2) {
			DiceHolder.setHoldNumber2(totalDice);
		}
		System.out.println("First dice :" + dice + " second dice :" + dice2 + " \n Total for this : " + totalDice);
		//problem below here, fix here
		//int CountDice = DiceHolder.getDice();
		int CountDice =0;
		if (holdTurn == 1){
			CountDice = DiceHolder.getDice();
		}
		if(holdTurn == 2){
			CountDice = DiceHolder.getDice2();
		}
		System.out.println("error here test : CountDice : " + CountDice);
		if(CountDice > max) {
			OverAgain = CountDice - max;
			System.out.println("OverAgain :" + OverAgain);
			totalDice = 0 + OverAgain;
			System.out.println("total "+ totalDice);
			//test add holdDice1 & 2
			if(holdTurn ==1) {
				DiceHolder.setHoldNumber1(totalDice);
				DiceHolder.addDiceNumber(totalDice);
			}
			if(holdTurn == 2) {
				DiceHolder.setHoldNumber2(totalDice);
				DiceHolder.addDiceNumber2(totalDice);
			}
			//DiceHolder.setDiceNumber(totalDice);
			PassGo();
		}
		if(holdTurn ==1) {
			diceNumber = DiceHolder.getHoldNumber1();
		}
		if(holdTurn == 2) {
			diceNumber = DiceHolder.getHoldNUmber2();
		}
		System.out.println("holdTurn :::"+ holdTurn);
		System.out.println("dice :::"+ diceNumber);
		//diceNumber = DiceHolder.getDice();
		}
		}
		//test totalDice = 0
		//DiceHolder.setDiceNumber(0);
		return diceNumber;
	}
	
	public static int randomDice() {
		int diceR;
		//Random random = new Random(); 
		diceR = ThreadLocalRandom.current().nextInt(1,7);
		//diceR = random.nextInt(4);
		return diceR;
	}
	public static void displayDice(int d) {
		System.out.println("Dice : " + d);
	}
	public static int getDice() {
		return diceNumber;
	}
	//pause here
	public static int countTurn() {
		holdTurn++;
		if(holdTurn == 3) {
			holdTurn = 1;
		}
		return holdTurn;
	}
	public static int getTurnDice() {
		int TurnX = 0;
		if(holdTurn ==1) {
			 TurnX= DiceHolder.getHoldNumber1();
		}
		if(holdTurn ==2) {
			  TurnX=DiceHolder.getHoldNUmber2();
		}
		return TurnX;
		
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
			colorLand.setPoperties(diceNumber, true);
			System.out.println("TESSSTT COLORLAND : " + colorLand.checkPurple() + " diceNumber : " + diceNumber);
			buyProperty();
		}
		else {
			System.out.println("No");
		} 
	}
	public static void getApproveForPurchaseProperty() {
		if(diceNumber == 0) {
			NotHouseProperty = true;
			
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
				verifyProperty.UpdateOwnProperty(5,true);
				colorLand.setPoperties(diceNumber, true);
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
			if(resultRailRoad == true) {
				//JOptionPane.showMessageDialog(null,"This area is owned, costs you 250");
				System.out.println("Player own this property 250 Rent : ");
				propertyRentCharge();
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
			JOptionPane.showMessageDialog(null, "JAILLLLLLLL");
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
	//after purchase property, below here to purchase house
	public static void buyProperty() {
		if(holdTurn ==1){
			balance.SubBalance(propertyInfo.getPropertyCost());
			System.out.println("Your balance after bought property, " + balance.getBalance());
		}
		if(holdTurn == 2){
			balance2.SubBalance(propertyInfo.getPropertyCost());
			System.out.println("Your balance after bought property, " + balance2.getBalance());
		}
	
		System.out.println("Congrats, you bought the property, you may buy house if you own all color as properties");
		boolean statusColor = checkColor(diceNumber);
		if(statusColor == true) {
		JOptionPane.showMessageDialog(null, "Congrats you own all propeties! you may purchase house!");
		int optionPurchase = JOptionPane.showConfirmDialog(null, "Would you like to purchase House" + propertyInfo.getArray() + " ?",
				"Purchase Property House ", JOptionPane.YES_NO_OPTION);
		if(optionPurchase == JOptionPane.YES_OPTION) {
			
			setOptionHouse();	
		}
		else {
			System.out.println("No");
		}
		}
		else {
			JOptionPane.showMessageDialog(null,"You do not own all properties, you cannot buy any house for this moment");
		}
	}
	public static boolean checkColor(int dice) {
		boolean colorPropertiesStatus = false;
		switch(dice) {
		case 0:
			break;
		case 1:
			colorPropertiesStatus = colorLand.checkPurple();
			break;
		case 2:
			break;
		case 3:
			colorPropertiesStatus = colorLand.checkPurple();
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			colorPropertiesStatus = colorLand.checkCyan();
			break;
		case 7:
			break;
		case 8:
			colorPropertiesStatus = colorLand.checkCyan();
			break;
		case 9:
			colorPropertiesStatus = colorLand.checkCyan();
			break;
		case 10:
			break;
		
		default:
			System.out.println("No Match");
			break;
		}
		return colorPropertiesStatus;
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
		if(number ==5) {
			status = verifyProperty.getStatus5();
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
		Object[] buttons = {0,1,2,3,4,"Hotel"};
		System.out.println(propertyInfo.getArray() + " house costs " + propertyInfo.getCost());
		int optionHouse = JOptionPane.showOptionDialog(null, "How much do you would like to purchase " + propertyInfo.getArray() + " ?",
				"Purchase Property", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, buttons, buttons[0]);
		if(optionHouse ==0) {
			excaltyNumber = 0;
		}
		if(optionHouse ==1) {
			excaltyNumber = 1;
		}
		if(optionHouse ==2) {
			excaltyNumber = 2;
		}
		if(optionHouse ==3) {
			excaltyNumber = 3;
		}
		if(optionHouse ==4) {
			excaltyNumber = 4;
		}
		if(optionHouse ==5) {
			excaltyNumber = 5;
		}
	
		amountHouse.setNumberHold(excaltyNumber);
		 System.out.println("Test escaltyNumber : " +amountHouse.getNumberHold());
		}
	}
	public static int setCostAfterOptionHouse() {
		int number =0;;
		number =  amountHouse.getNumberHold();
		number = number * propertyInfo.getCost();
		return number;
	}
	public static void feedDataHouse() {
		System.out.println("feed number amount" + amountHouse.getNumberHold());
		//own.OwnMediterranean(amountHouse.getNumberHold());
		own.setOwn(diceNumber, amountHouse.getNumberHold());
		SubBalance(holdTurn);
		amountHouse.setNumberHold(0);
	}
	public static void displayOwnHouse() {
		System.out.println("Display boolean status for property : " + diceNumber + " " + getBooleanStatusProperty());
		if(diceNumber ==1) {
		System.out.println("Count House " + own.getOwn1());
	}
		if(diceNumber ==3) {
			System.out.println("Count House " + own.getOwn3());
		}
		if(diceNumber ==5) {
			System.out.println("Count House " + own.getOwn5());
		}
		if(diceNumber ==6) {
			System.out.println("Count House " + own.getOwn6());
		}
		if(diceNumber ==8) {
			System.out.println("Count House " + own.getOwn8());
		}
		if(diceNumber ==9) {
			System.out.println("Count House " + own.getOwn9());
		}
	}
	public static void propertyRentCharge() {
		System.out.println("Rent Costs");
		chargeRent();
	}
	public static void chargeRent() {
		int numberOfHouse =0;
		
		
		System.out.println("testtt :" + numberOfHouse);
		if(diceNumber == 1) {
			numberOfHouse = own.getOwn1();
			 propertyRent.PropertyRent(1, numberOfHouse);
			 int costRent1 = propertyRent.getRent1();
			JOptionPane.showMessageDialog(null,"Cost of rent : " + costRent1);
				
		}
		if(diceNumber == 3) {
			numberOfHouse = own.getOwn3();
			propertyRent.PropertyRent(3, numberOfHouse);
			int costRent3 = propertyRent.getRent3();
			JOptionPane.showMessageDialog(null,"Cost of rent : " + costRent3);
		}
		if(diceNumber == 5) {
			numberOfHouse = own.getOwn5();
			propertyRent.PropertyRent(5, 0);
			int costRent5 = propertyRent.getRent5();
			JOptionPane.showMessageDialog(null,"Cost of rent : " + costRent5);
		}
		if(diceNumber == 6) {
			numberOfHouse = own.getOwn6();
			propertyRent.PropertyRent(6, numberOfHouse);
			int costRent6 = propertyRent.getRent6();
			JOptionPane.showMessageDialog(null,"Cost of rent : " + costRent6);
		}
		if(diceNumber == 8) {
			numberOfHouse = own.getOwn8();
			propertyRent.PropertyRent(8, numberOfHouse);
			int costRent8 = propertyRent.getRent8();
			JOptionPane.showMessageDialog(null,"Cost of rent : " + costRent8);
		}
		if(diceNumber == 9) { 
			numberOfHouse = own.getOwn9();
			propertyRent.PropertyRent(9, numberOfHouse);
			int costRent9 = propertyRent.getRent9();
			JOptionPane.showMessageDialog(null,"Cost of rent : " + costRent9);
		}
	
	}
	public static void PassGo() {
		JOptionPane.showMessageDialog(null,"Pass GO! $200 added to your balance");
		balance.AddBalance(200);
	}
	public static boolean getJailStatus(int a, int b) {
		System.out.println("first dice : " + a + " second dice : " + b);
		x++;
		System.out.println("X " + x);
		if (x ==3) {
			jailRule = false;
			stuckJail.setJail(jailRule);
			x =0;
		}
		if(a ==b) {
			jailRule = false;
			stuckJail.setJail(jailRule);
			sameNumberJail = false;
			numberjail.setNumberJail(a, b);
			x=0;
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
		
			if (holdTurn == 1){
				JOptionPane.showMessageDialog(null, "GetDice FUnction : " + getDice());
				 DiceHolder.setDiceNumber(getDice());
			}
			if(holdTurn == 2){
				JOptionPane.showMessageDialog(null, "GetDice FUnction : " + getDice());
				 DiceHolder.addDiceNumber2(getDice());
			}
			countTurn();
		}
	}
}
