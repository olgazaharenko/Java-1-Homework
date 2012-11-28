package XOX_Game;

/*
 * отрисовывает поле до хода
 * отрисовывает поле после хода
 * выводит правила игры на поле
*/

public class UserMenu {
	
	private String Border = "--------------=======0===1===2=======--------------";
	private String lineLeft = "-----------------=";
	private String lineLeftEnd = " [";
	private String lineRight = "=-----------------";
	private String lineRightStart = "] ";
	private String lineBetween = "] [";
	private String longEmptyLine = "                                                   ";

	public boolean GameRules(String nameX, String nameO) {
		boolean menuPrint = true;
		System.out.println("==X-O-X Game between "+ nameX + " and " + nameO + "==");
		System.out.println("=============================================");
		System.out.println("--------- You will see 3x3 field: -----------");
		System.out.println("--------------====0===1===2====--------------");
		System.out.println("--------------0= [ ] [ ] [ ] =0--------------");
		System.out.println("--------------1= [ ] [ ] [ ] =1--------------");
		System.out.println("--------------2= [ ] [ ] [ ] =2--------------");
		System.out.println("--------------====0===1===2====--------------");
		System.out.println("---------- Fill it either X or O. -----------");
		System.out.println("------- Winner will first one, who will -----");
		System.out.println("--- able to align your X or O in one line. --");
		System.out.println("=============================================");
		return menuPrint;
	}
	
	//отрисовка текущего состояния поля по-клеточно
	public void drawField(char Box[][]) {
		System.out.println(longEmptyLine);
		System.out.println(Border);
		System.out.println(lineLeft + "0" + lineLeftEnd + Box [0][0] + lineBetween + Box [1][0] + lineBetween + Box [2][0] + lineRightStart + "0" + lineRight);
		System.out.println(lineLeft + "1" + lineLeftEnd + Box [0][1] + lineBetween + Box [1][1] + lineBetween + Box [2][1] + lineRightStart + "1" + lineRight);
		System.out.println(lineLeft + "2" + lineLeftEnd + Box [0][2] + lineBetween + Box [1][2] + lineBetween + Box [2][2] + lineRightStart + "2" + lineRight);
		System.out.println(Border);
		System.out.println(longEmptyLine);
	}
}
