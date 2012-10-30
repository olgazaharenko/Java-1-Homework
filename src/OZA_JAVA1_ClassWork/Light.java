package OZA_JAVA1_ClassWork;

public class Light {

	public void turnLights(String onOFF, String nameOfLight) {
		
		//создадим всякие вспомогательные тексты для отладки
		String str1 = "===================";
		String str2 = "Включаем фару " + nameOfLight;
		String str3 = "Гасим фару ";
		String str4 = " Light " + nameOfLight + " is " + onOFF;
		
		if (onOFF == "ON") {
			//включаем фары
			System.out.println(str1);
			System.out.println(str2);
			}
		else {
			//гасим фары
			System.out.println(str1);
			System.out.println(str3);
		}
		System.out.println(str4);

	}	
}
		

