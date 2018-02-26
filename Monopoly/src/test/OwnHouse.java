package test;

public class OwnHouse {

	private int numberOwn1, numberOwn3, numberOwn5, numberOwn6, numberOwn8, numberOwn9;
	public OwnHouse(){
		numberOwn1 = 0;
		numberOwn3 = 0;
		numberOwn5 = 0;
		numberOwn6 = 0;
		numberOwn8 = 0;
		numberOwn9 = 0;
	}
	/*
	public OwnHouse(OwnHouse object) {
		numberOwn1 = object.numberOwn1;
	}
	*/
	public void OwnMediterranean(int h) {
		numberOwn1 = h;
	}
	public void setOwn(int h, int amount) {
		switch (h) {
		case 0:
			break;
		case 1:
			numberOwn1 = amount;
			break;
		case 2:
			break;
		case 3:
			numberOwn3 = amount;
			break;
		case 4:
			
			break;
		case 5:
			numberOwn5 = amount;
			break;
		case 6:
			numberOwn6 = amount;
			break;
		case 7:
			
			break;
		case 8: 
			numberOwn8 = amount;
			break;
		case 9:
			numberOwn9 = amount; 
			break;
		case 10:
			break;
		default:
			break;
		}
	}
	public int getOwn1() {
		return numberOwn1;
	}
	public int getOwn3() {
		return numberOwn3;
	}
	public int getOwn5() {
		return numberOwn5;
	}
	public int getOwn6() {
		return numberOwn6;
	}
	public int getOwn8() {
		return numberOwn8;
	}
	public int getOwn9() {
		return numberOwn9;
	}
}
