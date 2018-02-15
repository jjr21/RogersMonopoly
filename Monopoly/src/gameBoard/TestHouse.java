package gameBoard;

import javax.swing.JOptionPane;

public class TestHouse {

	private static PriceHouse MediterraneanAve, BalticAve;
	
	public static void main(String[] args) {
		boolean status;
		int numberTemp = 0;
		MediterraneanAve = BuyMediterranean();
		
		BuyMediterraneanTwoLevel();
		BuyMediterraneanThreeLevel();
		BuyMediterraneanFourLevel(); 
		BalticAve = BuyBaltic();
		MediterraneanAve.setMortgage(30);
		
		/*
		System.out.println("Mediterranean ave charged: " + MediterraneanAve.getChargeFirstHouse()
		+ " . BalticAve charged : " + BalticAve.getChargeFirstHouse());
		*/
		System.out.println("Mediterrance's detail :    Rent Info:  " +MediterraneanAve.getChargeFirstHouse() + " " + MediterraneanAve.getChargeSecondHouse() + " " +
		MediterraneanAve.getChargeThirdHouse() + " " + MediterraneanAve.getChargeFourthHouse() + " Mortgage: " + MediterraneanAve.getMortgage());
		System.out.println("Mediterranceane costs 50 per house");
		while(status = true) {
		String input = JOptionPane.showInputDialog("How much do you want to buy this house?");
		
		 numberTemp = Integer.parseInt(input);
		 if (numberTemp > 5) {
			 System.out.println("Less than 5");
			 continue;
		 }
		 else {
			 break;
		 }
		}
		MediterraneanAve.setBuyHouse(numberTemp);
		MediterraneanAve.setHouse(numberTemp);
		MediterraneanAve.setNameHouse("Mediterrance Ave");
		System.out.println("You bought house at "+ MediterraneanAve.getNameHouse() + " Number of house : " +
				MediterraneanAve.getHouse() + " costs " + MediterraneanAve.getBuyHouse());
		System.exit(0);
	}
	public static PriceHouse BuyMediterranean() {
		int cost = 10;
		return new PriceHouse(cost); 
	}
	public static PriceHouse BuyBaltic() {
		int cost = 20;
		return new PriceHouse(cost);
	}
	public static void BuyMediterraneanTwoLevel() {
		int cost2 = 30;
		MediterraneanAve.chargeSecondHouse(cost2);
	}
	public static void BuyMediterraneanThreeLevel() {
		int cost3 = 90;
		MediterraneanAve.chargeThirdHouse(cost3);
	}
	public static void BuyMediterraneanFourLevel() {
		int cost4 = 160;
		MediterraneanAve.chargeFourthHouse(cost4);
	}
}
