package test4;

public class VerifyOwnProperty {

	private boolean own1, own3, own5, own6, own8, own9;
	private int playerOwn, playerOwn3,playerOwn5, playerOwn6, playerOwn8, playerOwn9;
	
	public VerifyOwnProperty() {
		own1 = false;
		own3 = false;
		own5 = false;
		own6 = false;
		own8 = false;
		own9 = false;
		playerOwn = 0;
		playerOwn3 = 0;
		playerOwn5 = 0;
		playerOwn6 = 0;
		playerOwn8 = 0;
		playerOwn9 = 0;
	}
	public void UpdateOwnProperty(int c, boolean b, int whom) {
	
		switch(c) {
		case 0:
			break;
		case 1:
			own1 = b;
			playerOwn = whom;
			break;
		case 2:
			break;
		case 3:
			own3 = b;
			playerOwn3 = whom;
			break;
		case 4:
			break;
		case 5:
			own5 = b;
			playerOwn5 = whom;
			break;
		case 6:
			own6 = b;
			playerOwn6 = whom;
			break;
		case 7:
			break;
		case 8: 
			own8 = b;
			playerOwn8 = whom;
			break;
		case 9:
			own9 = b;
			playerOwn9 = whom;
			break;
		case 10:
			break;
		}
		
	}
	public int getWhon(int c) {
		int whomOwn=0;
		switch(c) {
		case 1:
			whomOwn = playerOwn;
			break;
		case 2:
			break;
		case 3:
			whomOwn = playerOwn3;
			break;
		case 4:
			break;
		case 5:
			whomOwn = playerOwn5;
			break;
		case 6:
			whomOwn = playerOwn6;
			break;
		case 7:
			break;
		case 8:
			whomOwn = playerOwn8;
			break;
		case 9:
			whomOwn = playerOwn9;
			break;
		case 10:
			break;
		}
		return whomOwn;
	}
	public boolean getStatus1() {
		return own1;
	}
	public boolean getStatus3() {
		return own3;
	}
	public boolean getStatus5() {
		return own5;
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
