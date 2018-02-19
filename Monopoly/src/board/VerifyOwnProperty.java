package board;

public class VerifyOwnProperty {

	private boolean own;
	
	public VerifyOwnProperty() {
		own = false;
	}
	public void UpdateOwnProperty(boolean b) {
		own = b;
	}
	public boolean getStatus() {
		return own;
	}
}
