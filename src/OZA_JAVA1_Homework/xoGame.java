package OZA_JAVA1_Homework;

import java.util.Scanner;

public class xoGame {

	/*
	 * Объект КрестикиНоликиИгра (По псевдокоду = Игра)
	 * - выводит предложение сыграть - метод GameInvitation()
	 * - запрашивает, считывает и возвращает тип игроков: 
	 * (человек-человек, человек-компьютер, компьютер-компьютер)  - метод DefineGamers()
	 * 
	 * - выводит имя победителя -  метод GameWinnerNameIs (String WinnerName)
	 * - завершает игру - метод GameOver ()
	 */
	
	private String gameInvitation = "Lets play to 'X-O-X', wouldn't you? If agree, enter Y, if not, enter N..."; 
	private String gameOverMessage = "Game Over. Restart application to play again.";
	private String gameXOWinnerIs = "Tadam! The Game Winner's Name Is... ";
	private String gamersPairs = "You with your friend (press 1), you with me (press 2) or me with my AI (press 3)...";
	
	//конструктор класса xoGame
	xoGame() {
		
		//создаем игроков
		xoPlayer xPlayer = new xoPlayer();
		xoPlayer oPlayer = new xoPlayer();
		
		//создаем доску
		xoGameBoard xoBoard = new xoGameBoard();
		
		xPlayer.doName();
		oPlayer.doName();
		
		//выводим правила игры
		xoBoard.GameRules();
		
		//выводим приглашение выбрать фигуру
		
		xPlayer.doFigure();
		oPlayer.doFigure();
		
	}
	
	public void GameStart(int g) {
 		
		switch(g) {
			//Human with Human
			case 1: {
				
				
				
			}
			//Human with AI
			case 2: {
				
				
				
			}
			//AI with AI
			case 3: {
				
			}
		}
	}
	
	public boolean GameInvitation(){
		boolean qu;
		String userAnswer = "";
		System.out.print(gameInvitation);
		Scanner reader = new Scanner(System.in);
    	userAnswer = reader.nextLine();
    	if (userAnswer =="Y") {
    		qu = true;
    	}
    	else {
    		qu = false;
    	}
    	return qu;
    }
	
	public void GameOver (){
		System.out.print (gameOverMessage);
	}
	
	public void GameWinnerNameIs (String WinnerName){
		gameXOWinnerIs = gameXOWinnerIs + WinnerName;
		System.out.print (gameXOWinnerIs);		
	}
	
	

	//выбрать, кто с кем играет
	public int DefineGamers () {
		
		int who;
		
		System.out.print(gamersPairs);
		Scanner reader = new Scanner(System.in);
		who = reader.nextInt();
		
		return who;
	}
	
	
	
}


		
