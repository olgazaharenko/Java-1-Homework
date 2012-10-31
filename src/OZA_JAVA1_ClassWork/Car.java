package OZA_JAVA1_ClassWork;

public class Car {
	
	//машина знает, сколько у нее фар
	private int numberOfLight = 4;
	
	//метод для доступа к количеству фар (по логике задачи, он не нужен,
	//сам объект может получить доступ к своей переменной, но
	//может понадобиться, если будем запрашивать извне количество фар
	public int getNumberOfLight() {
		return numberOfLight;
	}
	
	//метод для изменения количества фар
	public int setNumberOfLight() {
		if (numberOfLight == 0) {
			numberOfLight = 4;
		}
		return numberOfLight;
	}
	
	//машина знает, какого типа у нее фары
	private Light[] mySetOfLights = new Light[numberOfLight];
	
	//метод, который создает фары
	public Light[] setLight(int numberOfLight) {
		for (int j = 0; j < numberOfLight; j++) {
			mySetOfLights[j] = new Light();
			}
		return mySetOfLights;
	}

	//метод для включения-выключения фар
	public void buttonTurnMyLights(boolean q) {
		for (int i = 0; i < numberOfLight+1; i++) {
			mySetOfLights[i].turnLights(q, Integer.toString(i));
		}
	}
}
	



	

