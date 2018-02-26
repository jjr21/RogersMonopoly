package board;

public class PropertyRentCharge {
	
	private int rent1, rent3, rent5, rent6, rent8, rent9;
	
	public PropertyRentCharge() {
		rent1 = 0;
		rent3 = 0;
		rent5 = 0;
		rent6 = 0;
		rent8 = 0;
		rent9 = 0;
	}
	public void PropertyRent(int c, int p) {
		
		switch(c) {
		case 0:
			break;
		case 1:
			if(p==0) {
			rent1 = 2;
			}
			if(p==1) {
				rent1 = 10;
			}
			if(p==2) {
				rent1 = 30;
			}
			if(p==3) {
				rent1 = 90;
			}
			if(p==4) {
				rent1 = 160;
			}
			if(p==5) {
				rent1 = 250;
			}
			break;
		case 2:
			break;
		case 3:
			if(p==0) {
				rent3 = 4;
				}
				if(p==1) {
					rent3 = 20;
				}
				if(p==2) {
					rent3 = 60;
				}
				if(p==3) {
					rent3 = 180;
				}
				if(p==4) {
					rent3 = 320;
				}
				if(p==5) {
					rent3 = 450;
				}
			break;
		case 4:
			break;
		case 5:
			if(p==0) {
				rent5 = 25;
				}
				
			break;
		case 6:
			if(p==0) {
				rent6 = 6;
				}
				if(p==1) {
					rent6 = 30;
				}
				if(p==2) {
					rent6 = 90;
				}
				if(p==3) {
					rent6 = 270;
				}
				if(p==4) {
					rent6 = 400;
				}
				if(p==5) {
					rent6 = 550;
				}
			break;
		case 7:
			break;
		case 8: 
			if(p==0) {
				rent8 = 6;
				} 
				if(p==1) {
					rent8 = 30;
				}
				if(p==2) {
					rent8 = 90;
				}
				if(p==3) {
					rent8 = 270;
				}
				if(p==4) {
					rent8 = 400;
				}
				if(p==5) {
					rent8 = 550;
				}
			break;
		case 9:
			if(p==0) {
				rent9 = 8;
				}
				if(p==1) {
					rent9 = 40;
				}
				if(p==2) {
					rent9 = 100;
				}
				if(p==3) {
					rent9 = 300;
				}
				if(p==4) {
					rent9 = 450;
				}
				if(p==5) {
					rent9 = 600;
				}
			break;
		case 10:
			break;
		}
		
	}
	public int getRent1() {
		return rent1;
	}
	public int getRent3() {
		return rent3;
	}
	public int getRent5() {
		return rent5;
	}
	public int getRent6() {
		return rent6;
	}
	public int getRent8() {
		return rent8;
	}
	public int getRent9() {
		return rent9;
	}
}
