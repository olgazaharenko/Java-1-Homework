package CrissCrossGame;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public boolean win = false;

	public Board xoBoard = new Board();
	public int zeroBoxes = xoBoard.calcBoardArea() * xoBoard.calcBoardArea();

	public int xy[] = new int[2];

	public List<String> listOfGamersNames = new ArrayList<String>();
	
	Game() {
		listOfGamersNames = UserMenu.meetTheGamers();
		UserMenu.GameRules(listOfGamersNames);
	}

	public void play(int gamers) {

		switch (gamers) {
		case 0: {
			this.TwoHumansPlay(gamers, xoBoard);
			break;
		}
		case 1: {
			this.HumanWithAIPlay(gamers, xoBoard);
			break;
		}
		case 2: {
			this.TwoAIPlay(gamers, xoBoard);
			break;
		}
		}
	}

	public void HumanWithAIPlay(int gamers, Board xoBoard) {

		listOfGamersNames = UserMenu.meetTheGamers();
		String gamer1Name = listOfGamersNames.get(0);
		String gamer2Name = listOfGamersNames.get(1);

		UserMenu.GameRules(listOfGamersNames);

		String Fishki[] = Speaker.doFigure(gamers);

		HumanGamer gamer1 = new HumanGamer();

		while ((zeroBoxes > 0)) {
			while (!win) {

				Speaker.namePlayerWhoMove(listOfGamersNames.get(0) + " "
						+ Fishki[0]);
				xy = gamer1.doMove();
				xoBoard.drawField(xy, Fishki, 0);

				
				win = xoBoard.getWinLines(Fishki[0]);
				zeroBoxes = xoBoard.getEmptyBoxesInTheField();

				if (win) {
					Speaker.gameWinner(1, listOfGamersNames.get(0));
					break;
				} else if (!win && (zeroBoxes == 0)) {
					Speaker.gameWinner(0, "");
					break;
				}

				Speaker.namePlayerWhoMove(listOfGamersNames.get(1) + " "
						+ Fishki[1]);

				ComputerGamer gamer2 = new ComputerGamer();
				xy = gamer2.doMove(xoBoard, Fishki);

				xoBoard.drawField(xy, Fishki, 1);

				win = xoBoard.getWinLines(Fishki[1]);
				zeroBoxes = xoBoard.getEmptyBoxesInTheField();

				if (win) {
					Speaker.gameWinner(1, listOfGamersNames.get(1));
					break;
				} else if ((zeroBoxes == 0) && !win) {
					Speaker.gameWinner(0, "");
					break;
				}
				break;
			}
		}
	}

	public void TwoAIPlay(int gamers, Board xoBoard) {
		ComputerGamer gamer1 = new ComputerGamer();
		ComputerGamer gamer3 = new ComputerGamer();

		List<ComputerGamer> listOfGamers = new ArrayList<ComputerGamer>();

		{
			listOfGamers.add(0, gamer1);
			listOfGamers.add(1, gamer3);
		}
		
		String Fishki[] = Speaker.doFigure(gamers);

		while ((zeroBoxes > 0)) {
			while (!win) {

				for (int p = 0; p <= 1; p++) {
					Speaker.namePlayerWhoMove(listOfGamersNames.get(p) + " "
							+ Fishki[p]);
					xy = listOfGamers.get(p).doMove(xoBoard, Fishki);
					xoBoard.drawField(xy, Fishki, p);

					win = xoBoard.getWinLines(Fishki[p]);
					zeroBoxes = xoBoard.getEmptyBoxesInTheField();

					if (win) {
						Speaker.gameWinner(1, listOfGamersNames.get(p));
						break;
					} else if ((zeroBoxes == 0) && !win) {
						Speaker.gameWinner(0, "");
						break;
					}
				}
			}
		}
	}

	public void TwoHumansPlay(int gamers, Board xoBoard) {

		String Fishki[] = Speaker.doFigure(gamers);

		HumanGamer gamer1 = new HumanGamer();
		HumanGamer gamer2 = new HumanGamer();

		List<HumanGamer> listOfGamers = new ArrayList<HumanGamer>();

		{
			listOfGamers.add(0, gamer1);
			listOfGamers.add(1, gamer2);
		}

		while ((zeroBoxes > 0)) {
			while (!win) {
				for (int p = 0; p <= 1; p++) {
					Speaker.namePlayerWhoMove(listOfGamersNames.get(p) + " "
							+ Fishki[p]);
					xy = listOfGamers.get(p).doMove();

					xoBoard.drawField(xy, Fishki, p);

					win = xoBoard.getWinLines(Fishki[p]);

					zeroBoxes = xoBoard.getEmptyBoxesInTheField();

					if (win) {
						Speaker.gameWinner(1, listOfGamersNames.get(p));
						break;
					} else if ((zeroBoxes == 0) && !win) {
						Speaker.gameWinner(0, "");
						break;
					}
				}
				break;
			}
		}
	}
}