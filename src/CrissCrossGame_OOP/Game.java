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
		this.play(xoBoard);
	}

	private void play(Board xoBoard) {
		while (!stopGame) {
			for (int turn = 0; turn <= 1; turn++) {
				System.out.println("turn = " + turn);
				Speaker.namePlayerWhoMove(team, turn);
				this.makeMove(turn);
				stopGame = this.checkWin(turn);
			}
		}
	}

	private boolean checkWin(int turn) {
		
		int zeroBoxes = xoBoard.getNumberOfEmptyBoxes();
		win = xoBoard.getWinLines();
		System.out.println("zeroBoxes = " + zeroBoxes);
		System.out.println("win = " + win);

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