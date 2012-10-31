package OZA_JAVA1_ClassWork;

public class Light {

	//помним состояние фары
	private String onORoff = "Undefined";
	
	//метод изменения состояния фар
	public String setonORoff(boolean q) {
		//включаем фары
		if (q == true) {
		onORoff = "ON";
		}

		//гасим фары
		if (q == false) {
			onORoff = "OFF";
		}
	
		return onORoff;
	}
	
	public void turnLights(boolean q, String nameOfLight) {
		
		//создадим всякие вспомогательные тексты для отладки
	
		String str1 = "===================";
		String str2 = "Включаем фару " + nameOfLight;
		String str3 = "Гасим фару " + nameOfLight;
		String str4 = " Light " + nameOfLight + " is " + onORoff;
		
		if (q == true) {
			//включаем фары
			System.out.println(str1);
			System.out.println(str2);
			}
		
		if (q == false) {
			//гасим фары
			System.out.println(str1);
			System.out.println(str3);
		}
		System.out.println(str4);
	}	
	
	public void close(int numberOfLight) {
		
	} 
	
}
		

