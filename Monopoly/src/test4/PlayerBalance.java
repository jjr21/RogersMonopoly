package test4;

public class PlayerBalance {

	private int balance, balance2;
	
	public PlayerBalance() {
		balance = 0;
		balance2 = 0;
	}
	public void setBlance(int b) {
		balance = b;
		balance2 = b;
	}
	public void SubBalance(int s, int costSub) {
		switch(s) {
		case 1:
			balance -= costSub;
			break;
		case 2:
			balance2 -= costSub;
			break;
		}
	}
	public void AddBalance(int a, int costAdd) {
		switch(a) {
		case 1:
			balance += costAdd;
			break;
		case 2:
			balance2 += costAdd;
			break;
		}
	}
	public int getBalance() {
		return balance;
	}
	public int getBalance2() {
		return balance2;
	}
}
