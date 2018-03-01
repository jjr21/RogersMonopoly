package test;

public class DiceNumber {

	private int number, holdNumber1, holdNumber2;
	public DiceNumber() {
		number = 0;
		holdNumber1 = 0;
		holdNumber2 = 0;
		
	}
	public void setDiceNumber(int d) {
		number = d;
	}
	public void setHoldNumber1(int first) {
		holdNumber1 = first;
	}
	public void setHoldNumber2(int second) {
		holdNumber2= second;
	}
	public void addDiceNumber(int add) {
		number += add;
	}
	public int getDice() {
		return number;
	}
	public int getHoldNumber1() {
		return holdNumber1;
		
	}
	public int getHoldNUmber2() {
		return holdNumber2;
	}
}
