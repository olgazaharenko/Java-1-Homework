package CrissCrossGame_OOP;

public class Board {

	public int boardWidth;
	public boolean isEmpty;
	public Token[][] winFilledBoard;
	public Token[][] gameFilledBoard;

	Board() {
		boardWidth = 3;
		isEmpty = true;

		gameFilledBoard = new Token[this.boardWidth][this.boardWidth];
		winFilledBoard = new Token[this.boardWidth][this.boardWidth];

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
			if (this.gameFilledBoard[i][0] == (this.gameFilledBoard[i][1])
				&& (this.gameFilledBoard[i][0] == (this.gameFilledBoard[i][2])) && ((this.gameFilledBoard[i][0] != Token.NO))) {
			lines = true;
			break;
			}
		}
				
		for (int i = 0; i < boardWidth; i++) { //проверка строк
		// если собрана 0 горизонталь
		if (this.gameFilledBoard[0][i] == (this.gameFilledBoard[1][i])
				&& (this.gameFilledBoard[0][i] == (this.gameFilledBoard[2][i]))&&((this.gameFilledBoard[i][0] != Token.NO))) {
			lines = true;
			break;
		}
		}
		// если собрана левая диагональ
		if (this.gameFilledBoard[0][0].equals(this.gameFilledBoard[1][1])
				&& (this.gameFilledBoard[0][0]
						.equals(this.gameFilledBoard[2][2]))&& ((this.gameFilledBoard[0][0] == Token.X) || (this.gameFilledBoard[0][0] == Token.O))) {
			lines = true;
		}

		// если собрана правая диагональ
		if (this.gameFilledBoard[2][0].equals(this.gameFilledBoard[1][1])
				&& (this.gameFilledBoard[2][0]
						.equals(this.gameFilledBoard[0][2]))&& ((this.gameFilledBoard[0][0] == Token.X) || (this.gameFilledBoard[0][0] == Token.O))) {
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
				System.out.println("Is i : j CellEmpty?" + i + " : " + j + " "
						+ this.isCellEmpty(i, j));
				if ((i == XY[0]) && (j == XY[1]) && (this.isCellEmpty(i, j))) {
					gameFilledBoard[i][j] = this.setCellValue(p);
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
