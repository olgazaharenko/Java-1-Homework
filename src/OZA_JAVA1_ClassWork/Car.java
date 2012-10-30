package OZA_JAVA1_ClassWork;

public class Car {
	
	public void buttonTurnMyLights(String q) {
		
		//резервируем память под 4 фары
		Light light[] = new Light[4];
		
		//помещаем туда ссылки на 4 фары
		light[0] = new Light();
		light[1] = new Light();
		light[2] = new Light();
		light[3] = new Light();
		
		//будем передавать номер фары, чтобы убедиться, что все 4 объекта отработали
		String tmp;

		//вызываем метод для включения либо выключения фар
		for (int i = 0; i < 4; i++) {
			tmp = Integer.toString(i+1);
			light[i].turnLights(q, tmp);
		}
	}
}
	



	

