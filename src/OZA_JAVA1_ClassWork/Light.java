package OZA_JAVA1_ClassWork;

public class Light {

	//помним состояние фар
	public String onORoff = "Undefined";
	
	public void turnLights(boolean q, String nameOfLight) {
		
		//создадим всякие вспомогательные тексты для отладки
	
		String str1 = "===================";
		String str2 = "Включаем фару " + nameOfLight;
		String str3 = "Гасим фару ";
		String str4 = " Light " + nameOfLight + " is " + onORoff;
		
		if (q == true) {
			//включаем фары
			onORoff = "ON";
			System.out.println(str1);
			System.out.println(str2);
			}
		
		if (q == false) {
			//гасим фары
			onORoff = "OFF";
			System.out.println(str1);
			System.out.println(str3);
		}
		System.out.println(str4);
	}	
}
		

