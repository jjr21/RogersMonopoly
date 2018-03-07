package Test2;

public class Jail {

	private boolean jailCard, jailCard2, jailCard3, jailCard4;
	private int xCount, yCount;
	
	public Jail() {
		jailCard = false;
		jailCard2 = false;
		jailCard3 = false;
		jailCard4 = false;
		xCount = 0;
		yCount =0;
	}
	
	public void setJail(boolean j, int dice) {
		switch(dice) {
		case 1:
			jailCard = j;
			break;
		case 2:
			jailCard2 = j;
			break;
		case 3:
			jailCard3 = j;
			break;
		case 4:
			jailCard4 = false;
			break;
		}
		
	}
	public boolean getJail(int dice) {
		boolean statusJailCard = false;
		switch(dice) {
		case 1:
			statusJailCard = jailCard;
			break;
		case 2:
			statusJailCard = jailCard2;
			break;
		case 3:
			statusJailCard = jailCard3;
			break;
		case 4:
			statusJailCard = jailCard4;
			break;
			
		}
		return statusJailCard;
	}
	public void setJailcount(int dice) {
		switch(dice) {
		case 1:
			xCount=0;
			break;
		case 2:
			yCount=0;
			break;
		}
	}
	public void addJailcount(int dice) {
		switch(dice) {
		case 1:
			xCount++;
			break;
		case 2:
			yCount ++;
			break;
		}
	}
	public int getJailcount(int dice) {
		int x=0;
		switch(dice) {
		case 1:
			x= xCount;
			break;
		case 2:
			x = yCount;
			break;
		}
		return x;
	}
}
