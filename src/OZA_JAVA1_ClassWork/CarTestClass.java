package OZA_JAVA1_ClassWork;

public class CarTestClass {

	public static void main(String[] args) {
		Car car = new Car();
		
		//включим фары
		car.buttonTurnMyLights(true);
		
		//погасим фары
		car.buttonTurnMyLights(false);
	}

}
