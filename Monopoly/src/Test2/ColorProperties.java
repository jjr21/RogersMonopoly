package Test2;

public class ColorProperties {

	private boolean color1, color3, color5, color6, color8, color9;
	private boolean ownColorSingle;
	private boolean ownAll;
	private int groupProperty;
	private String nameProperties;
	
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
	}
	
	public void setPoperties(int a, boolean b) {
		switch(a) {
		case 0:
			break;
		case 1:
			color1 = true;
			break;
		case 2:
			break;
		case 3:
			color3 = true;
			break;
		case 4:
			break;
		case 5:
			color5 = true;
			break;
		case 6:
			color6 = true;
			break;
		case 7:
			break;
		case 8:
			color8 = true;
			break;
		case 9:
			color9 = true;
			break;
		case 10:
			break;
		
		default:
			System.out.println("No Match");
			break;
		
		}
	}
		public boolean checkCyan() {
			boolean statusCyan;
			
				if(color6 == true& color8 == true & color9 == true) {
				statusCyan = true;
			}
			else{
				statusCyan = false;
			}
			return statusCyan;
			
		}
		public boolean checkPurple() {
			boolean statusPurple;
			if(color1 == true && color3 == true) {
				statusPurple = true;
			}
			else {
				statusPurple = false;
			}
			return statusPurple;
		}
	}

