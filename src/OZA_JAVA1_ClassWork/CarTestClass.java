package OZA_JAVA1_ClassWork;

public class CarTestClass {

	public static void main(String[] args) {
		Car car = new Car();
		
		//создадим 4 фары для машины
		car.setLight(car.getNumberOfLight());
		//включим фары
		car.buttonTurnMyLights(true);
		//погасим фары
		car.buttonTurnMyLights(false);
	}

}
