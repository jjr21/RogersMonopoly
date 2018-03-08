package test3;

public class AmountHouseHold {

	private int hold;
	
	public AmountHouseHold() {
		hold = 0;
	}
	public AmountHouseHold(AmountHouseHold object) {
		hold = object.hold;
	}
	public void setNumberHold(int n) {
		hold = n;
	}
	public int getNumberHold() {
		return hold;
	}
}
