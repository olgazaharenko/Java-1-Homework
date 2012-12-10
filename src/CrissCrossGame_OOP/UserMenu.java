package CrissCrossGame_OOP;

import java.util.ArrayList;
import java.util.List;

public class UserMenu {
	
	private static String Border = "--------------=======0===1===2=======--------------";
	private static String lineLeft = "-----------------=";
	private static String lineLeftEnd = " [";
	private static String lineRight = "=-----------------";
	private static String lineRightStart = "] ";
	private static String lineBetween = "] [";
	private static String longEmptyLine = "                                                   ";

	public static void GameRules(List<String> listOfGamersNames) {
		System.out.println("==CrissCross Game between "+ listOfGamersNames.get(0) + " and " + listOfGamersNames.get(0) + "==");
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
	}
	
	public static void drawField(String[][] box) {
		System.out.println(longEmptyLine);
		System.out.println(Border);
		System.out.println(lineLeft + "0" + lineLeftEnd + box [0][0] + lineBetween + box [1][0] + lineBetween + box [2][0] + lineRightStart + "0" + lineRight);
		System.out.println(lineLeft + "1" + lineLeftEnd + box [0][1] + lineBetween + box [1][1] + lineBetween + box [2][1] + lineRightStart + "1" + lineRight);
		System.out.println(lineLeft + "2" + lineLeftEnd + box [0][2] + lineBetween + box [1][2] + lineBetween + box [2][2] + lineRightStart + "2" + lineRight);
		System.out.println(Border);
		System.out.println(longEmptyLine);
	}
	
	public static List<String> meetTheGamers() {
		List<String> listOfGamersNames = new ArrayList<String>();
		{
			listOfGamersNames.add(0, Speaker.doName());
			listOfGamersNames.add(1, Speaker.doName());
		}
		return listOfGamersNames;	
	}
}
