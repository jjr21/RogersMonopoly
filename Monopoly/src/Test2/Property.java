package Test2;

public class Property {

	private String propertyName;
	//private int [] numbers = new int[39];
	
	public Property() {
		propertyName = " ";
	}
	
	public Property(Property object) {
		propertyName = object.propertyName;
	}
	
	public void MatchBoxArray(int a) {
		switch (a) {
		case 0:
			propertyName = "GO";
			break;
		case 1:
			propertyName = "Mediterranean Avenue";
			break;
		case 2:
			propertyName = "Community Chest";
			break;
		case 3:
			propertyName = "Baltic Avenue";
			break;
		case 4:
			propertyName = "Income Tax";
			break;
		case 5:
			propertyName = "Reading Railroad";
			break;
		case 6:
			propertyName = "Oriental Avenue";
			break;
		case 7:
			propertyName = "Chance";
			break;
		case 8: 
			propertyName = "Vermont Avenue";
			break;
		case 9:
			propertyName = "Connecticut Avenue";
			break;
		case 10:
			propertyName = "JAIL";
			break;
		default:
			propertyName = "No match";
			break;
		}
		
	}
	
	public String getArray() {
		return propertyName;
	}
	
}
