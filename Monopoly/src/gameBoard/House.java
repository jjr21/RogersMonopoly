package gameBoard;

public class House {

	private int numberOfHouse;
	private String nameOfHouse;
	
	public House() {
		numberOfHouse = 0;
		nameOfHouse = " ";
	}
	public void setHouse(int h) {
		numberOfHouse = h;
	}
	public void setNameHouse(String h) {
		nameOfHouse = h;
	}
	public int getHouse() {
		return numberOfHouse;
	}
	public String getNameHouse() {
		return nameOfHouse;
	}
	public String toString() {
		String str = "Number of house " + numberOfHouse + " name of house : " + nameOfHouse;
		return str;
	}
}


