package OZA_JAVA1_Homework;

import java.util.Scanner;

public class KrestikiNoliki {
	
	public static String GameInvitation (){
		
		String userAnswer = "";
		
		System.out.print("Lets play to X or O, wouldn't you? If agree, enter Y, if not, enter N...");
		Scanner reader = new Scanner(System.in);
    	userAnswer = reader.nextLine();
    	
    	return userAnswer;
	}
	
	public void GameRules() {
		System.out.println("=============================================");
		System.out.println("----------You will see 3x3 field:------------");
		System.out.println("-----------------[ ] [ ] [ ] ----------------");
		System.out.println("-----------------[ ] [ ] [ ] ----------------");
		System.out.println("-----------------[ ] [ ] [ ] ----------------");
		System.out.println("-------------Fill it either X or O.----------");
		System.out.println("---Winner will first one from us, who will---");
		System.out.println("---able to align your X or O in one line.----");
		System.out.println("=============================================");
	}
	
	public static String LetMeKnowWhatIsYourName () {
		
		String userName = "";
		
		System.out.print("My name is Dr. Z-z-zlo. And yours? Just print it...");
		
		Scanner reader = new Scanner(System.in);
		while (reader.nextLine() != " ") {
			userName = userName + reader.nextLine();
		}
		
    	return userName;
	}
	
	public static String LetMeKnowWhatIsYourFigure () {
		
		String userFigure = "";
		
		System.out.print("What is your figure to play with? Just print it...");
		Scanner reader = new Scanner(System.in);
    	userFigure = reader.nextLine();
		
		return userFigure;
	}
	
	
	public static String [][] CreateGameField () {
		String [][] GameField = new String [3][3];
		int i, j;
		
		for (i = 0; i<3; i++) {
			for (j = 0; j<3; j++) {
				GameField [i][j] = "_";
				System.out.println (GameField [i][j]);
			}			
		}	
	
		return GameField;		
	}
	
	public static String [][] FillGameField () {
		String [][] FilledGameField = new String [3][3];
		// заполняем поле полученными ходами
		// перерисовываем матрицу поля
		return FilledGameField;		
	}
	
}


		
