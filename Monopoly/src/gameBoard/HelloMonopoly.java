package gameBoard;

import javax.swing.JOptionPane;

public class HelloMonopoly {

	private static PriceHouse lamesa;
	public static void main(String[] args) {
		System.out.println("Hello Monoploy");
		PriceHouse elcajon;
		PriceHouse santee;
		lamesa = Lamesa();
		elcajon = ElCajon();
		santee = Santee();
		System.out.println("El cajon : " + elcajon.getChargeFirstHouse());
		System.out.println("santee : " + santee.getChargeFirstHouse());
		System.out.println("Lamesa : " + lamesa.getChargeFirstHouse());
		String input2 = JOptionPane.showInputDialog("Do you want to buy two houses in La Mesa?");
		String input = JOptionPane.showInputDialog("Do you want to buy two houses in El Cajon?");
		if (input2.equals("yes")) {
			LamesaTwoLevel();
			System.out.println("La Mesa Two Level : " + lamesa.getChargeSecondHouse());
		}
		if (input.equals("yes")) {
			elcajon = ElCajonTwoLevel();
			System.out.println("El cajon Two Level : " + elcajon.getChargeFirstHouse());
		}
		System.exit(0);
	}
	
	public static PriceHouse ElCajon() {
		int i;
		i = 9;
		return new PriceHouse(i);
	}
	public static PriceHouse ElCajonTwoLevel() {
		int i;
		i = 11;
		return new PriceHouse(i);
		
	}
	public static PriceHouse Santee() {
		int i;
		i = 19;
		return new PriceHouse(19);
	}	
	public static PriceHouse Lamesa() {
		int u;
		u = 20;
		return new PriceHouse(u);
	}
	public static void LamesaTwoLevel() {
		lamesa.chargeSecondHouse(30);
		//System.out.println("La Mesa Two Level : " + lamesa.getCostSecondHouse());
		
	}
}
