package CrissCrossGame_OOP;

import java.util.List;

public class Board {

	private int boardWidth = 3;
	private int maxBoxesInTheField = 0;
	public int lines = 0;
	boolean isEmpty = true;

	String underScore = "_";

	String gameFieldBox[][] = new String[boardWidth][boardWidth];
	{
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				gameFieldBox[i][j] = underScore;
			}
		}
	}
	
	String winFieldBox[][] = new String[boardWidth][boardWidth];

	public int getFieldWidth() {
		return boardWidth;
	}
	
	public int calcBoardArea() {
		int boardSize = boardWidth*boardWidth;
		return boardSize;
	}

	public void GameRules(List<String> listOfGamersNames) {
		UserMenu.GameRules(listOfGamersNames);
	}

	public String[][] getGameFieldBox() {
		return gameFieldBox;
	}

	public String[][] setFinalGameBox(String Box[][]) {
		gameFieldBox = Box;
		return gameFieldBox;
	}

	public int getMaxBoxesInTheField() {
		return maxBoxesInTheField;
	}

	public int getEmptyBoxesInTheField() {
		int numberOfEmptyBoxes = 9;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if ((gameFieldBox[i][j].equals(Token.X.toString()) || (gameFieldBox[i][j].equals(Token.O.toString())))) {
					numberOfEmptyBoxes = numberOfEmptyBoxes - 1;
				}
			}
		}
		return numberOfEmptyBoxes;
	}
		
	public boolean getWinLines(String Fishka) {
		boolean lines = false;
		
		for (int i = 0; i <= boardWidth - 1; i++) {
			int m = i;
			for (int j = 0; j <= boardWidth -1; j++) {
				
				// если собрана вертикаль
				winFieldBox[m][j] = Fishka;
				if (this.checkWinLine(gameFieldBox, winFieldBox)) {
					lines = true;
				}
				
				//если собрана горизонталь
				winFieldBox[i][m] = Fishka;
				if (this.checkWinLine(gameFieldBox, winFieldBox)) {
					lines = true;
				}
				
				//если собрана диагональ
				winFieldBox[i][i] = Fishka;
				if (this.checkWinLine(gameFieldBox, winFieldBox)) {
					lines = true;
				}
				}				
			}
		return lines;
	}

	public boolean checkWinLine(String[][] gameField, 	String[][] winField) {
		boolean lines = false;
		String resultField[][] = new String[boardWidth][boardWidth];
		
		for (int i = 0; i <= (boardWidth - 1)/2; i++) {
			for (int j = 0; j <= (boardWidth - 1)/2; j++) {
				if (gameField[i][j].equals(winField[i][j])) {
					resultField[i][j] = underScore;
					lines = true;
				}
				else {
					resultField[i][j] = gameField[i][j];
					lines = false;
				}
			}
		}
		return lines;
	}

	public String[][] drawField(int XY[], String[] fishki, int n) {
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if ((i == XY[0]) && (j == XY[1])
						&& (gameFieldBox[i][j] != fishki[0])
						&& (gameFieldBox[i][j] != fishki[1])) {
					gameFieldBox[i][j] = fishki[n];
				}
			}

			for (int j = 0; j <= 2; j++) {
				if ((gameFieldBox[i][j] != fishki[0])
						&& (gameFieldBox[i][j] != fishki[1])) {
					//gameFieldBox[i][j] = underScore;
					gameFieldBox[i][j] = Token.Empty.toString();
				}
			}
		}
		UserMenu.drawField(gameFieldBox);
		return gameFieldBox; // нужно только для работы тестов.
	}
}
