package test;

public class VerifyOwnProperty {

	private boolean own1, own3, own6, own8, own9;
	
	public VerifyOwnProperty() {
		own1 = false;
		own3 = false;
		own6 = false;
		own8 = false;
		own9 = false;
	}
	public void UpdateOwnProperty(int c, boolean b) {
	
		switch(c) {
		case 0:
			break;
		case 1:
			own1 = b;
			break;
		case 2:
			break;
		case 3:
			own3 = b;
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			own6 = b;
			break;
		case 7:
			break;
		case 8: 
			own8 = b;
			break;
		case 9:
			own9 = b;
			break;
		case 10:
			break;
		}
		
	}
	public boolean getStatus1() {
		return own1;
	}
	public boolean getStatus3() {
		return own3;
	}
	public boolean getStatus6() {
		return own6;
	}
	public boolean getStatus8() {
		return own8;
	}
	public boolean getStatus9() {
		return own9;
	}
}
