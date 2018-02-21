package test;

public class DiceNumber {

	private int number;
	
	public DiceNumber() {
		number = 0;
	}
	public void setDiceNumber(int d) {
		number = d;
	}
	public void addDiceNumber(int add) {
		number += add;
	}
	public int getDice() {
		return number;
	}
}
