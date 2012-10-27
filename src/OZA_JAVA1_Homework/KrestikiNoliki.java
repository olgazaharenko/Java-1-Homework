package OZA_JAVA1_Homework;

import java.util.Scanner;
import java.awt.*;

public class KrestikiNoliki {
	
	public static String GameInvitation (){
		
		String userAnswer = "";
		
		System.out.print("Lets play to X or O, wouldn't you? If agree, enter Y, if not, enter N...");
		Scanner reader = new Scanner(System.in);
    	userAnswer = reader.nextLine();
    	
    	return userAnswer;
	}
	
	public static void GameOver (){
		
		String gameOverMessage = "Game Over. Restart application to play again.";
		
		System.out.print (gameOverMessage);
	}
	
	public static void GameRules() {
		System.out.println("=============================================");
		System.out.println("--------- You will see 3x3 field: -----------");
		System.out.println("--------------=================--------------");
		System.out.println("--------------== [ ] [ ] [ ] ==--------------");
		System.out.println("--------------== [ ] [ ] [ ] ==--------------");
		System.out.println("--------------== [ ] [ ] [ ] ==--------------");
		System.out.println("--------------=================--------------");
		System.out.println("---------- Fill it either X or O. -----------");
		System.out.println("------- Winner will first one, who will -----");
		System.out.println("--- able to align your X or O in one line. --");
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
	
	
	//public static void paint(Graphics g){
		//draw a rectangle starting at 100,100 width a width and height of 80
	//	  g.drawRect(100, 100, 80, 80);
	//	}
	
	public static void CreateGameField(String player1Name, String player2Name) {
		
		Graphics newGameField = null;
		
		System.out.println(player1Name + "X or O" + player2Name);
		
	//draw a rectangle starting at 100,100 width a width and height of 90
		newGameField = g.drawRect(0, 0, 90, 90);
		
		
		
		//String [][] FilledGameField = new String [3][3];
		
		//String [][] GameField = new String [3][3];
		//int i, j;
		
		//for (i = 0; i<3; i++) {
		//	for (j = 0; j<3; j++) {
		//		GameField [i][j] = "_";
		//		System.out.println (GameField [i][j]);
		//	}		
		
			
		//}	
	
	}
	
	public static void FillGameField () {
	
		// заполняем поле полученными ходами
		// перерисовываем матрицу поля
		
	}
	
}


		
