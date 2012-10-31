package OZA_JAVA1_ClassWork;

public class Car {
	//машина знает, сколько у нее фар
	private int numberOfLight = 4;
		
	//машина знает, какого типа у нее фары
	private Light[] mySetOfLights = new Light[numberOfLight];
	
	//конструктор метода, который создаст машину с фарами
	Car() {
		for (int j = 0; j < numberOfLight; j++) {
		mySetOfLights[j] = new Light();
		}
	}
	
	//метод для включения-выключения фар
	public void buttonTurnMyLights(boolean q) {
		//меняем состояние фар
		for (int j = 0; j < numberOfLight; j++) {
			mySetOfLights[j].setonORoff(q);
		}
		//визуализация для контроля результата
		for (int i = 0; i < numberOfLight; i++) {
			mySetOfLights[i].turnLights(q, Integer.toString(i+1));
		}
	}
}