package test;

public class DiceNumber {

	private int number1, number2, holdNumber1, holdNumber2;
	public DiceNumber() {
		number1 = 0;
		number2 = 0;
		holdNumber1 = 0;
		holdNumber2 = 0;
		
	}
	public void setDiceNumber(int d) {
		number1 = d;
	}
	public void setHoldNumber1(int first) {
		holdNumber1 = first;
	}
	public void setHoldNumber2(int second) {
		holdNumber2= second;
	}
	public void addDiceNumber(int add) {
		number1 += add;
	}
	public int getDice() {
		return number1;
	}
	public void addDiceNumber2(int add) {
		number2 += add;
	}
	public int getDice2() {
		return number2;
	}
	public int getHoldNumber1() {
		return holdNumber1;
		
	}
	public int getHoldNUmber2() {
		return holdNumber2;
	}
	
	
}
