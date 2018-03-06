package Test2;

public class PropertyPrice extends Property {
	private int cost, propertyCost;
	private boolean Coummity, Chest, Jail;
	public PropertyPrice() {
		cost = 0;
	}
	public void MatchArrayPrice(int b) {
		switch (b) {
		case 0:
			cost = 200;
			break;
		case 1:
			propertyCost = 60;
			cost = 50;
			break;
		case 2:
			Coummity = true;
			break;
		case 3:
			cost = 50;
			propertyCost = 60;
			
			break;
		case 4:
			cost = 200;
			break;
		case 5:
			propertyCost = 200;
			break;
		case 6:
			cost = 50;
			propertyCost = 100;
			break;
		case 7:
			Chest = true;
			break;
		case 8: 
			cost = 50;
			propertyCost = 100;
			break;
		case 9:
			cost = 50;
			propertyCost = 120; 
			break;
		case 10:
			Jail = true;
			break;
		default:
			break;
		}
	}
	public int getCost() {
		return cost;
	}
	public int getPropertyCost() {
		return propertyCost;
	}
}
