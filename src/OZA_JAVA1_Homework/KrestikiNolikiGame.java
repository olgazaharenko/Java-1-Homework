package OZA_JAVA1_Homework;

import java.util.Scanner;

public class KrestikiNolikiGame {

	/*
	 * Объект КрестикиНоликиИгра (По псевдокоду = Игра)
	 * - выводит предложение сыграть - метод GameInvitation()
	 * - выводит правила игры - метод GameRules()
	 * - запрашивает, считывает и возвращает имя игрока - метод LetMeKnowWhatIsYourName (String ComputerXOPlayerName) 
	 * - запрашивает, считывает и возвращает фигуры игроков - метод LetMeKnowWhatIsYourFigure ()
	 * 
	 * - запрашивает, считывает и возвращает тип игроков: 
	 * (человек-человек, человек-компьютер, компьютер-компьютер)  - метод DefineGamers()
	 * 
	 * - выводит имя победителя -  метод GameWinnerNameIs (String WinnerName)
	 * - завершает игру - метод GameOver ()
	 */
	
	static String gameInvitation = "Lets play to X or O, wouldn't you? If agree, enter Y, if not, enter N..."; 
	static String gameOverMessage = "Game Over. Restart application to play again.";
	static String computer1Name = "My name is Dr. Z-z-zlo. ";
	static String computerTalk = "And yours? Just print it...";
	static String computer2Name = "No, it's my name is Dr. Z-z-zlo. ";
	static String HumanXOFigureChoice = "What is your figure to play with? Just print it...";
	static String gameXOWinnerIs = "Tadam! The Game Winner's Name Is... ";
	static String gamePlayersXOChoiseIs1 = "You will play with Human (H), with Computer (C) or you will look how two Robots play (R)?";
	static String gamePlayersXOChoiseIs2 = "Enter H, C or R to make a choice...";
	
	public String GameInvitation(){
		String userAnswer = "";
		System.out.print(gameInvitation);
		Scanner reader = new Scanner(System.in);
    	userAnswer = reader.nextLine();
    	return userAnswer;
	}
	
	public void GameOver (){
		System.out.print (gameOverMessage);
	}
	
	public void GameWinnerNameIs (String WinnerName){
		gameXOWinnerIs = gameXOWinnerIs + WinnerName;
		System.out.print (gameXOWinnerIs);		
	}
	
	public String GamePlayersPairChoice (){
		String ChoiseIs;
		System.out.print(gamePlayersXOChoiseIs1 + gamePlayersXOChoiseIs2);
		Scanner reader = new Scanner(System.in);
    	ChoiseIs = reader.nextLine();
    	return ChoiseIs;
	}
	
	public void GameRules() {
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
	
	public String LetMeKnowWhatIsYourName (String ComputerXOPlayerName) {
		
		String userName = "";
		System.out.print(ComputerXOPlayerName);
		Scanner reader = new Scanner(System.in);
		while (reader.nextLine() != " ") {
			userName = userName + reader.nextLine();
		}
		return userName;
	}

	//выбрать, кто с кем играет
	public int DefineGamers () {
		
		int who;
		
		String gamersPairs = "You with your friend (press 1), you with me (press 2) or me with my AI (press 3)...";
		
		System.out.print(gamersPairs);
		Scanner reader = new Scanner(System.in);
		who = reader.nextInt();
		
		return who;
	}
	
	public String LetMeKnowWhatIsYourFigure () {
		
		String userFigure = "";
		
		System.out.print(HumanXOFigureChoice);
		Scanner reader = new Scanner(System.in);
    	userFigure = reader.nextLine();
		return userFigure;
	}
	
}


		
