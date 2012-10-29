package OZA_JAVA1_ClassWork;

public class Light {

	private String lFL = "FrontLeft";
	private String lFR = "FrontRight";
	private String lBL = "BackLeft"; 
	private String lBR = "BackRight";
	private String lightSide;
	
	public String getLightSide(String side) {
		if (side == "FrontLeft") {
			lightSide = lFL;
		}
		
		if (side == "FrontRight") {
			lightSide = lFR;
		}
		
		if (side == "BackLeft") {
			lightSide = lBL;
		}
		
		if (side == "BackRight") {
			lightSide = lBR;
		}
		
		return lightSide;
		
	}
		
}
