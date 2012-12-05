package CrissCrossGame;

public class Speaker {

	private static String gameInvitation = "Lets play to 'Crisscross', wouldn't you? If agree, enter 1, if not, enter 2...";
	private static String gameOverMessage = "Game Over. Restart application to play again.";

	private static String xoPlayerName = "Print your nick name: ";
	private static String HumanXOFigureChoice = "Print figure to play, X or O: ";

	private static String xCoord = "Enter move's x coordinate: 0, 1 or 2: ";
	private static String yCoord = "Enter move's y coordinate: 0, 1 or 2: ";

	private static String gameXOWinnerIs = "Tadam! The Game Winner's Name Is... ";
	private static String gameXODraw = "Draw!";
	private static String gamersPairs = "You with your friend (press 0), you with me (press 1) or me with my AI (press 2)...";

	private static String movePlayer = "Move of ";
 
	public static boolean GameInvitation() {
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
	
	public static int DefineGamers() {
		Integer who = 0;
		who = Integer.parseInt(ReadUserInputHelper.getUserInput(gamersPairs));
		return who;
	}

	public static int readXMove() {
		Integer x = 0;
		x = Integer.parseInt(ReadUserInputHelper.getUserInput(xCoord));
		return x;
	}

	public static int readYMove() {
		Integer y = 0;
		y = Integer.parseInt(ReadUserInputHelper.getUserInput(yCoord));
		return y;
	}

	public static String doName() {
		String userName = "";
		userName = ReadUserInputHelper.getUserInput(xoPlayerName);
		return userName;
	}

	public static void namePlayerWhoMove(String gamerName) {
		System.out.println(movePlayer + gamerName);
	}

	public static String[] doFigure(int aiPlayersAmount) {

		String Fishki[] = new String[2];

		switch (aiPlayersAmount) {
		case 0: {
			Fishki[0] = ReadUserInputHelper.getUserInput(HumanXOFigureChoice);
			System.out.println("Fishki[0] = " + Fishki[0]);
			{
				if (Fishki[0].equals("X")) {
					Fishki[1] = "O";
				} else if (Fishki[0].equals("O")) {
					Fishki[1] = "X";
				}
			}
			break;
		}
		case 1: {
			Fishki[0] = ReadUserInputHelper.getUserInput(HumanXOFigureChoice);
			{
				if (Fishki[0].equals("X")) {
					Fishki[1] = "O";
				} else if (Fishki[0].equals("O")) {
					Fishki[1] = "X";
				}
			}
			break;
		}
		case 2:
			Fishki[0] = "O";
			Fishki[1] = "X";
			break;
		}
		return Fishki;
	}

	public static void GameWinner(int WinnerKey, String WinnerName) {
		switch (WinnerKey) {
		case 0:
			System.out.print(gameXODraw);
			break;
		case 1:
			gameXOWinnerIs = gameXOWinnerIs + WinnerName;
			System.out.print(gameXOWinnerIs);
			break;
		}
	}

	public static void GameOver() {
		System.out.print(gameOverMessage);
	}
}
