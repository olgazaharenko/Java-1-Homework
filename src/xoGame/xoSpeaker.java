package xoGame;

public class xoSpeaker {

	/*
	 * все общение с игроком идет через этот класс
	 * - выводит предложение сыграть - метод GameInvitation()
	 * - выводит имя победителя -  метод GameWinnerNameIs (String WinnerName)
	 * - завершает игру - метод GameOver ()
	 */

	private String gameInvitation = "Lets play to 'X-O-X', wouldn't you? If agree, enter 1, if not, enter 2..."; 
	private String gameOverMessage = "Game Over. Restart application to play again.";
	private String gameXOWinnerIs = "Tadam! The Game Winner's Name Is... ";
	private String gamersPairs = "You with your friend (press 1), you with me (press 2) or me with my AI (press 3)...";
	
	//конструктор 
	xoSpeaker() {
		
	}
	public void GameOver (){
		System.out.print (gameOverMessage);
	}
	
	public boolean GameInvitation(){
		boolean qu;
		Integer userAnswer = 0;
		userAnswer = Integer.parseInt(ReadUserInputHelper.getUserInput(gameInvitation));
    	
    	if (userAnswer == 1) {
    		qu = true;
    	}
    	else {
    		qu = false;
    	}
    	return qu;
    }
	

}
