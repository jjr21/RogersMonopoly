package gameBoard;

public class PriceHouse extends House implements MortgageValue {
	private int cost,  cost1, cost2, cost3, cost4, hotel, mortgage;
	private int buyHouse;
	public PriceHouse() {
		cost = 0;
		cost1 = 0;
		cost2 = 0;
		cost3 = 0;
		cost4 = 0;
		hotel = 0;
		buyHouse = 0;
		
		
	}
	 
	public PriceHouse(int current) {
		cost1 = current;
	}
	public PriceHouse(PriceHouse object) {
		cost1 = object.cost1;
	}
	
	
	public void setBuyHouse(int buy) {
		buyHouse = buy * 50;
	}

	
	public void buyProperity(int p) {
		cost = p;
	}
	public void chargeFirstHouse(int f) {
		cost1 = f;
	}
	
	public void chargeSecondHouse(int s) {
		cost2 = s;
	}
	public void chargeThirdHouse(int t) {
		cost3 = t;
	}
	public void chargeFourthHouse(int f) {
		cost4 = f;
	}
	public void chargeHotel(int h) {
		hotel = h;
	}
	public void setMortgage(int m) {
		mortgage = m;
	}
	public int getPrperity() {
		return cost;
	}
	public int getChargeFirstHouse() {
		return cost1;
	}
	public int getChargeSecondHouse() {
		return cost2;
	}
	public int getChargeThirdHouse() {
		return cost3;
	}
	public int getChargeFourthHouse() {
		return cost4;
	}
	public int getChargeHotel() {
		return hotel;
	}
	public int getBuyHouse() {
		return buyHouse;
	}
	public int getMortgage() {
		return mortgage; 
	}
}
