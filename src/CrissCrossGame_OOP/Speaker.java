package CrissCrossGame_OOP;

public class Speaker {

	private static String gameInvitation = "Lets play to 'Crisscross', wouldn't you? If agree, enter 1, if not, enter 2...";
	private static String gameOverMessage = "Game Over. Restart application to play again.";

	private static String xoPlayerXName = "Enter X player's nickname:";
	private static String xoPlayerOName = "Enter O player's nickname";
	
	private static String xCoord = "Enter move's x coordinate: 0, 1 or 2: ";
	private static String yCoord = "Enter move's y coordinate: 0, 1 or 2: ";

	private static String gameXOWinnerIs = "Tadam! The Game Winner's Name Is... ";
	private static String gameXODraw = "Draw!";
	private static String gamersPairs = "You with your friend (press 0), you with me (press 1) or me with my AI (press 2)...";

	private static String movePlayer = "Move of ";
 
	public static boolean gameInvitation() {
		boolean qu;
		Integer userAnswer = 0;
		userAnswer = Integer.parseInt(ReadUserInputHelper.getUserInput(gameInvitation));

		if (userAnswer == 1) {
			qu = true;
		} else {
			qu = false;
		}
		return qu;
	}
	
	public static int defineGamersPair() {
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

	public static String doXName() {
		String userName = "";
		userName = ReadUserInputHelper.getUserInput(xoPlayerXName);
		return userName;
	}
	
	public static String doOName() {
		String userName = "";
		userName = ReadUserInputHelper.getUserInput(xoPlayerOName);
		return userName;
	}

	public static void namePlayerWhoMove(Team team, int p) {
		System.out.println(movePlayer + team.getNames(p) + " "+ team.getTokens().get(p));
	}
	
	public static void gameWin(Team team, int winner) {
		System.out.print(gameXOWinnerIs + team.getNames(winner));
	}

	public static void gameDraw() {
		System.out.print(gameXODraw);
	}
	
	public static void gameOver() {
		System.out.print(gameOverMessage);
	}
}
