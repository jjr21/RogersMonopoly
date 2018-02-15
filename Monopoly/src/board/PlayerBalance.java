package board;

public class PlayerBalance {

	private int balance;
	
	public PlayerBalance() {
		balance = 0;
	}
	
	public void setBlance(int b) {
		balance = b;
	}
	public void SubBalance(int s) {
		balance -= s;
	}
	public void AddBalance(int a) {
		balance += a;
	}
	public int getBalance() {
		return balance;
	}
}
