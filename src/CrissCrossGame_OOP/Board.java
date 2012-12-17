package CrissCrossGame_OOP;

import java.util.List;

public class Board<gameFieldBox> {

	public int boardWidth;
	public boolean isEmpty;
	public String[][] winFilledBoard;
	public String[][] gameFilledBoard;

	Board() {
		boardWidth = 3;
		isEmpty = true;

		gameFilledBoard = new String[this.boardWidth][this.boardWidth];
		winFilledBoard = new String[this.boardWidth][this.boardWidth];

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				gameFilledBoard[i][j] = Token.EMPTY.getGameToken();
			}
		}

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				winFilledBoard[i][j] = Token.EMPTY.getGameToken();
			}
		}
	}

	public int getNumberOfEmptyBoxes() {
		int numberOfEmptyBoxes = 9;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if ((gameFilledBoard[i][j].equals(Token.FIRST.getGameToken()) || (gameFilledBoard[i][j]
						.equals(Token.SECOND.getGameToken())))) {
					numberOfEmptyBoxes = numberOfEmptyBoxes - 1;
				}
			}
		}
		return numberOfEmptyBoxes;
	}

	public boolean getWinLines() {
		boolean lines = false;
		
		for (int i = 0; i < boardWidth; i++) { //проверка столбиков
			if (this.gameFilledBoard[i][0].equals(this.gameFilledBoard[i][1])
				&& (this.gameFilledBoard[i][0]
						.equals(this.gameFilledBoard[i][2])) && ((this.gameFilledBoard[0][0] == Token.FIRST.getGameToken()) || (this.gameFilledBoard[0][0] == Token.SECOND.getGameToken()))) {
			lines = true;
			break;
			}
		}
				
		for (int i = 0; i < boardWidth; i++) { //проверка строк
		// если собрана 0 горизонталь
		if (this.gameFilledBoard[0][i].equals(this.gameFilledBoard[1][i])
				&& (this.gameFilledBoard[0][i]
						.equals(this.gameFilledBoard[2][i]))&& ((this.gameFilledBoard[0][0] == Token.FIRST.getGameToken()) || (this.gameFilledBoard[0][0] == Token.SECOND.getGameToken()))) {
			lines = true;
			break;
		}
		}
		// если собрана левая диагональ
		if (this.gameFilledBoard[0][0].equals(this.gameFilledBoard[1][1])
				&& (this.gameFilledBoard[0][0]
						.equals(this.gameFilledBoard[2][2]))&& ((this.gameFilledBoard[0][0] == Token.FIRST.getGameToken()) || (this.gameFilledBoard[0][0] == Token.SECOND.getGameToken()))) {
			lines = true;
		}

		// если собрана правая диагональ
		if (this.gameFilledBoard[2][0].equals(this.gameFilledBoard[1][1])
				&& (this.gameFilledBoard[2][0]
						.equals(this.gameFilledBoard[0][2]))&& ((this.gameFilledBoard[0][0] == Token.FIRST.getGameToken()) || (this.gameFilledBoard[0][0] == Token.SECOND.getGameToken()))) {
			lines = true;
		}
		return lines;
	}

	public boolean isCellEmpty(int i, int j) {
		boolean isEmpty = false;
		if (gameFilledBoard[i][j] == Token.EMPTY.getGameToken()) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public String setCellValue(int p) {
		String value = Token.EMPTY.getGameToken();
		if (p == 0) {
			value = Token.FIRST.getGameToken();
		}
		if (p == 1) {
			value = Token.SECOND.getGameToken();
		}
		return value;
	}

	public String setCellEmpty(int p) {
		String value = Token.EMPTY.getGameToken();
		return value;
	}

	public String[][] drawField(Team team, int p) {

		int XY[] = team.getPlayers(team.getTeam()).get(p).doMove(this, team);

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

	public String[][] getGameFieldBox() {
		return gameFilledBoard;
	}

}
