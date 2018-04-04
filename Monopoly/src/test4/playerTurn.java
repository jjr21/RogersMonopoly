package test4;

public class playerTurn extends DiceNumber {
	
	private int player1, player2;
	
	public playerTurn() {
		player1 = 0;
		player2 = 0;
	}
	public void setPlayer1(int f) {
		player1 = f;
	}
	public void setPlayer2(int s) {
		player2 = s;
	}
	public void addPlayer1(int fa) {
		player1 += fa;
	}
	public void addPlayer2(int sa) {
		player2 += sa;
	}
	public int getPlayer1() {
		return player1;
	}
	public int getPlayer2() {
		return player2;
	}


}
