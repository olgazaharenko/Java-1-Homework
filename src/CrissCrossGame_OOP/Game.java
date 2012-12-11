package CrissCrossGame_OOP;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public int gamers;
	
	public List<Player> listOfPlayers = new ArrayList<Player>();
	public Player player1;
	public Player player2;
	
	public Board xoBoard;
	public List<String> listOfGamersNames = new ArrayList<String>();
	public String Fishki[] = new String[2];
	public boolean win = false;
	public boolean stopGame = false;
	public int zeroBoxes;
	public int xy[] = new int[2];

	Game() {
		gamers = Speaker.defineGamersPair();

		listOfGamersNames = UserMenu.meetTheGamers();
		UserMenu.GameRules(listOfGamersNames);

		Fishki = Speaker.doFigure(gamers);

		xoBoard = new Board();
		zeroBoxes = xoBoard.calcBoardArea();
	}

	public void go() {
		this.play(gamers, xoBoard);
	}

	private void play(int gamers, Board xoBoard) {
		
		switch (gamers) {
		case 0: {
			HumanPlayer player1 = new HumanPlayer();
			HumanPlayer player2 = new HumanPlayer();
			listOfPlayers.add(player1);
			listOfPlayers.add(player2);
			break;
		}
		case 1: {
			HumanPlayer player1 = new HumanPlayer();
			AIPlayer player2 = new AIPlayer();
			listOfPlayers.add(player1);
			listOfPlayers.add(player2);
			break;
		}
		case 2: {
			AIPlayer player1 = new AIPlayer();
			AIPlayer player2 = new AIPlayer();
			listOfPlayers.add(player1);
			listOfPlayers.add(player2);
			break;
		}
	
		}
	
		while (!stopGame) {
			for (int p = 0; p <= (gamers - 1); p++) {
				this.makeMove(p);
				stopGame = this.checkWin(p);
			}
		}
	}

	private boolean checkWin(int p) {
	
		win = xoBoard.getWinLines(Fishki[p]);
		zeroBoxes = xoBoard.getEmptyBoxesInTheField();
		
		if (win) {
			Speaker.gameWinner(1, listOfGamersNames.get(p));
			stopGame = true;
		} else if ((zeroBoxes == 0) && !win) {
			Speaker.gameWinner(0, "");
			stopGame = true;
		}
		return stopGame;		
	}

	private void makeMove(int p) {
		Speaker.namePlayerWhoMove(listOfGamersNames.get(p) + " "
				+ Fishki[p]);
		xy = listOfPlayers.get(p).doMove(xoBoard, Fishki);
		xoBoard.drawField(xy, Fishki, p);
	}
}