package CrissCrossGame_OOP;

public class Game {
	public Board xoBoard;
	public Team team;
	
	public boolean win = false;
	public boolean draw = false;
	public boolean stopGame = false;

	Game() {
		xoBoard = new Board();
		team = new Team();
	}

	public void go() {
		play(xoBoard);
	}

	private void play(Board xoBoard) {
		while (!stopGame) {
			for (int turn = 0; turn <= 1; turn++) {
				Speaker.namePlayerWhoMove(team, turn);
				System.out.println("turn = " + turn);
				makeMove(turn);
				stopGame = checkWin(turn);
			}
		}
	}

	private boolean checkWin(int turn) {
		
		int zeroBoxes = xoBoard.getNumberOfEmptyBoxes();
		win = xoBoard.getWinLines();
		
		if ((zeroBoxes == 0) && !win) {draw = true;}
				
		if (win) {
			Speaker.gameWin(team, turn);
			stopGame = true;
		} else if (draw) {
			Speaker.gameDraw();
			stopGame = true;
		}
		
		return stopGame;		
	}

	private void makeMove(int turn) {
		xoBoard.drawField(team, turn);
	}
}