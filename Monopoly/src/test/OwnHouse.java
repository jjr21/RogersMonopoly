package test;

public class OwnHouse {

	private int numberOwn;
	
	
	public OwnHouse(){
		numberOwn = 0;
	}
	public OwnHouse(OwnHouse object) {
		numberOwn = object.numberOwn;
	}
	public void OwnMediterranean(int h) {
		numberOwn = h;
	}
	public int getOwn() {
		return numberOwn;
	}
}
