package test4;

public class ColorProperties {

	private boolean color1, color3, color5, color6, color8, color9;
	private boolean ownColorSingle;
	private boolean ownAll;
	private int groupProperty;
	private String nameProperties;
	private int own1, own3, own5, own6, own8, own9;
	
	public ColorProperties() {
		color1 = false;
		color3 = false;
		color5 = false;
		color6 = false;
		color8 = false;
		color9 = false;
		groupProperty = 0;
		nameProperties = " ";
		ownAll = false;
		ownColorSingle = false;
		own1 = 0;
		own3 = 0;
		own5 =0;
		own6 = 0;
		own8 = 0;
		own9 = 0;
	}
	
	public void setPoperties(int a, boolean b, int ownID) {
		switch(a) {
		case 0:
			break;
		case 1:
			color1 = true;
			own1 = ownID;
			break;
		case 2:
			break;
		case 3:
			color3 = true;
			own3 = ownID;
			break;
		case 4:
			break;
		case 5:
			color5 = true;
			own5 = ownID;
			break;
		case 6:
			color6 = true;
			own6 = ownID;
			break;
		case 7:
			break;
		case 8:
			color8 = true;
			own8 = ownID;
			break;
		case 9:
			color9 = true;
			own9 = ownID;
			break;
		case 10:
			break;
		
		default:
			System.out.println("No Match");
			break;
		
		}
	}
		public boolean checkCyan() {
			boolean statusCyan = false;
			
				if(color6 == true& color8 == true & color9 == true) {
					System.out.println("Colors are true");
					if((own6 ==1 && own8 == 1 && own9 == 1)|| (own6 == 2 && own8 == 2 && own9 == 2)) {
						
					System.out.println("colors are true and owner is true");
				statusCyan = true;
				}
			}
			else{
				statusCyan = false;
			}
			return statusCyan;
			
		}
		public boolean checkPurple() {
			boolean statusPurple = false;
			if(color1 == true && color3 == true) {
				System.out.println("Colors are true");
				if((own1 == 1 && own3 == 1)|| (own1 ==2 && own3 ==2)) {
					
				System.out.println("colors are true and owner is true");
				statusPurple = true;
			}}
			else {
				statusPurple = false;
			}
			return statusPurple;
		}
	}

