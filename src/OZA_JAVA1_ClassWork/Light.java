package OZA_JAVA1_ClassWork;

public class Light {

	//помним состояние фар
	
	public void turnLights(boolean onOFF, String nameOfLight) {
		
		//создадим всякие вспомогательные тексты для отладки
		String onORoff = "";
		String str1 = "===================";
		String str2 = "Включаем фару " + nameOfLight;
		String str3 = "Гасим фару ";
		String str4 = " Light " + nameOfLight + " is " + onORoff;
		
		if (onOFF == true) {
			//включаем фары
			onORoff = "ON";
			System.out.println(str1);
			System.out.println(str2);
			}
		
		if (onOFF == false) {
			//гасим фары
			onORoff = "OFF";
			System.out.println(str1);
			System.out.println(str3);
		}
		System.out.println(str4);
	}	
}
		

