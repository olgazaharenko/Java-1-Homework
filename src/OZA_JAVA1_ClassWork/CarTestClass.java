package OZA_JAVA1_ClassWork;

public class CarTestClass {

	public static void main(String[] args) {
		Car car = new Car();
		
		//создадим 4 фары для машины
		car.getNumberOfLight();
		car.setLight();
		//включим фары
		car.buttonTurnMyLights("ON");
		//погасим фары
		car.buttonTurnMyLights("OFF");
	}

}
