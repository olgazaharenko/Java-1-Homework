package XOX_Game;

public class Speaker {

	private String gameInvitation = "Lets play to 'X-O-X', wouldn't you? If agree, enter 1, if not, enter 2...";
	private String gameOverMessage = "Game Over. Restart application to play again.";

	private String xoPlayerName = "What is your name? Just print it...";
	private String HumanXOFigureChoice = "What is your figure to play with? Just print it...";

	private String xCoord = "Enter move's x coordinate: 0, 1 or 2: ";
	private String yCoord = "Enter move's y coordinate: 0, 1 or 2: ";

	private String gameXOWinnerIs = "Tadam! The Game Winner's Name Is... ";
	private String gameXODraw = "Draw!";
	private String gamersPairs = "You with your friend (press 1), you with me (press 2) or me with my AI (press 3)...";

	private String movePlayer = "Move of ";
 
	public int DefineGamers() {
		Integer who = 0;
		who = Integer.parseInt(ReadUserInputHelper.getUserInput(gamersPairs));
		return who;
	}

	public boolean GameInvitation() {
		boolean qu;
		Integer userAnswer = 0;
		userAnswer = Integer.parseInt(ReadUserInputHelper
				.getUserInput(gameInvitation));

		if (userAnswer == 1) {
			qu = true;
		} else {
			qu = false;
		}
		return qu;
	}

	public int readXMove() {
		Integer x = 0;
		x = Integer.parseInt(ReadUserInputHelper.getUserInput(xCoord));
		return x;
	}

	public int readYMove() {
		Integer y = 0;
		y = Integer.parseInt(ReadUserInputHelper.getUserInput(yCoord));
		return y;
	}

	public String doName() {
		String userName = "";
		userName = ReadUserInputHelper.getUserInput(xoPlayerName);
		return userName;
	}

	public void namePlayerWhoMove(String gamerName) {
		System.out.println(movePlayer + gamerName);
	}

	public char[] doFigure(int aiPlayersAmount) {

		char Fishki[] = new char[2];

		switch (aiPlayersAmount) {
		case 0: {
			String userFigure = ReadUserInputHelper.getUserInput(HumanXOFigureChoice);
			userFigure = userFigure + '_';
			for (int k = 0; k >= 1; k++)
				;
			{
				Fishki = userFigure.toCharArray();
			}

			{
				if (Fishki[0] == 'X') {
					Fishki[1] = 'O';
				} else {
					Fishki[0] = 'O';
					Fishki[1] = 'X';
				}
			}
		}
		case 1: {
			String userFigure = ReadUserInputHelper.getUserInput(HumanXOFigureChoice);
			userFigure = userFigure + '_';
			for (int k = 0; k >= 1; k++)
				;
			{
				Fishki = userFigure.toCharArray();
			}

			{
				if (Fishki[0] == 'X') {
					Fishki[1] = 'O';
				} else {
					Fishki[0] = 'O';
					Fishki[1] = 'X';
				}
			}
		}
		case 2:
			Fishki[0] = 'X';
			Fishki[1] = 'O';
		}
		return Fishki;
	}

	public void GameWinner(int WinnerKey, String WinnerName) {
		switch (WinnerKey) {
		case 0:
			System.out.print(gameXODraw);
		case 1:
			gameXOWinnerIs = gameXOWinnerIs + WinnerName;
			System.out.print(gameXOWinnerIs);
		}
	}

	public void GameOver() {
		System.out.print(gameOverMessage);
	}
}
