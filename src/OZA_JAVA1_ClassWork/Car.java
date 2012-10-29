package OZA_JAVA1_ClassWork;

public class Car {
	
	private String trigger = "OFF";
	private String lightOnOff;
	private String inbetween = " Light is ";
	
	public String turnLight (Light myLight, String sideLight, boolean keyOnOff) {
		
	if (keyOnOff == false) {trigger = "ON";} else {trigger = "OFF";}
	
	lightOnOff = myLight.getLightSide(sideLight) + inbetween + trigger;
	
	return lightOnOff;
	
	}
	
}



	

