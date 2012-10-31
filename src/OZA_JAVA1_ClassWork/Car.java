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
	private Light[] realSetOfLights = new Light[numberOfLight];
	
	//метод для создания и включения-выключения фар
	public void buttonTurnMyLights(boolean q) {
		//try {
			for (int j = 0; j < numberOfLight; j++) {
			
				//создаем фары
				
				//тут нужна проверка, не существует ли уже комплект фар, чтобы не 
				//перепутать ссылки и не работать с новым комплектом фар для выключения
				if (mySetOfLights != realSetOfLights) {mySetOfLights[j] = new Light();}
				
				//mySetOfLights[j] = new Light();
				
				//скопируем массив объектов во временный массив, ссылку на который 
				//будем использовать для проверки, не был ли уже создан комплект фар
				realSetOfLights[j] = mySetOfLights[j];
				
				//меняем состояние фар
				mySetOfLights[j].setonORoff(q);
			}
		
			//визуализация для контроля результата
			for (int i = 0; i < numberOfLight; i++) {
				mySetOfLights[i].turnLights(q, Integer.toString(i+1));
			}
		
			}
		
		//finally {
		//	for (int i = 0; i < numberOfLight; i++) {
		//		mySetOfLights[i].close(numberOfLight);
		//	}
}
	



	

