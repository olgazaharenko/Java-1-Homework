package CrissCrossGame_OOP;

public class Board {

	public int boardWidth;
	public boolean isEmpty;
	public Token[][] winFilledBoard;
	public Token[][] gameFilledBoard;

	Board() {
		boardWidth = 3;
		isEmpty = true;

		gameFilledBoard = new Token[boardWidth][boardWidth];
		winFilledBoard = new Token[boardWidth][boardWidth];

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				gameFilledBoard[i][j] = Token.NO;
			}
		}

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				winFilledBoard[i][j] = Token.NO;
			}
		}
	}

	public int getNumberOfEmptyBoxes() {
		int numberOfEmptyBoxes = 9;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if ((gameFilledBoard[i][j].equals(Token.X) || (gameFilledBoard[i][j]
						.equals(Token.O)))) {
					numberOfEmptyBoxes = numberOfEmptyBoxes - 1;
				}
			}
		}
		return numberOfEmptyBoxes;
	}

	public boolean getWinLines() {
		boolean lines = false;
		
		for (int i = 0; i < boardWidth; i++) { //проверка столбиков
			if (gameFilledBoard[i][0] != Token.NO) {
				if (gameFilledBoard[i][0].equals(gameFilledBoard[i][1])
						&& (gameFilledBoard[i][0].equals(gameFilledBoard[i][2]))) {
					lines = true;
					break;
				}
			}
		}
				
		for (int i = 0; i < boardWidth; i++) { //проверка строк
		// если собрана 0 горизонталь
			if (gameFilledBoard[0][i] != Token.NO) {
				if (gameFilledBoard[0][i].equals(gameFilledBoard[1][i])
						&& (gameFilledBoard[0][i].equals(gameFilledBoard[2][i]))) {
					lines = true;
					break;
				}
			}
		}
		
		// если собрана левая диагональ
		if (gameFilledBoard[0][0].equals(gameFilledBoard[1][1])
				&& (gameFilledBoard[0][0].equals(gameFilledBoard[2][2]))) {
			lines = true;
		}

		// если собрана правая диагональ
		else if (gameFilledBoard[2][0].equals(gameFilledBoard[1][1])
				&& (gameFilledBoard[2][0].equals(gameFilledBoard[0][2]))) {
			lines = true;
		}
		return lines;
	}

	public boolean isCellEmpty(int i, int j) {
		boolean isEmpty = false;
		if (gameFilledBoard[i][j] == Token.NO) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public Token setCellValue(int p) {
		Token value = Token.NO;
		if (p == 0) {
			value = Token.X;
		}
		if (p == 1) {
			value = Token.O;
		}
		return value;
	}

	public String setCellEmpty(int p) {
		String value = Token.NO.toString();
		return value;
	}

	public Token[][] drawField(Team team, int p) {

		int XY[] = team.getPlayers(team.getTeam()).get(p).doMove(this);

		for (int i = 0; i <= 2; i++) {

			for (int j = 0; j <= 2; j++) {
				if ((i == XY[0]) && (j == XY[1]) && (isCellEmpty(i, j))) {
					gameFilledBoard[i][j] = setCellValue(p);
				}
			}
		}
		UserMenu.drawField(gameFilledBoard);
		return gameFilledBoard; // нужно только для работы тестов.
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public Token[][] getGameFieldBox() {
		return gameFilledBoard;
	}
	
	public Token[][] setGameFilledBox(Token[][] myField) {
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				gameFilledBoard[i][j] = myField[i][j]; 
			}
		}
		return gameFilledBoard;		
	}
}
