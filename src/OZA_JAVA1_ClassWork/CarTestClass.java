package OZA_JAVA1_ClassWork;

public class CarTestClass {

	public static void main(String[] args) {
		
		Car myCar = new Car();
		Light myLeftFrontLight = new Light();
		Light myRightFrontLight = new Light();
		Light myLeftBackLight = new Light();
		Light myRightBackLight = new Light();
		
		final String lFL = "FrontLeft";
		final String lFR = "FrontRight";
		final String lBL = "BackLeft"; 
		final String lBR = "BackRight";
	
		//гасим фары
		System.out.println("Гасим фары: ");		
		System.out.println(myCar.turnLight(myLeftFrontLight, lFL, false));
		System.out.println(myCar.turnLight(myRightFrontLight, lFR, false));
		System.out.println(myCar.turnLight(myLeftBackLight, lBL, false));
		System.out.println(myCar.turnLight(myRightBackLight, lBR, false));
		
		//включаем фары
		System.out.println("Включаем фары: ");		
		System.out.println(myCar.turnLight(myLeftFrontLight, lFL, true));
		System.out.println(myCar.turnLight(myRightFrontLight, lFR, true));
		System.out.println(myCar.turnLight(myLeftBackLight, lBL, true));
		System.out.println(myCar.turnLight(myRightBackLight, lBR, true));
				
	}

}
