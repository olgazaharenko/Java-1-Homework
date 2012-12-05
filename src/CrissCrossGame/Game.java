package CrissCrossGame;

import java.util.ArrayList;
import java.util.List;

public class Game {

	int zeroBoxes = 9;
	boolean Win = false;
	int XY[] = new int[2];

	public void Play() {

		int gamers = Speaker.DefineGamers();
		Board xoBoard = new Board();

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

		List<String> listOfGamersNames = new ArrayList<String>();

		listOfGamersNames = UserMenu.meetTheGamers(gamers);

		String gamer1Name = listOfGamersNames.get(0);
		String gamer2Name = listOfGamersNames.get(1);
		UserMenu.GameRules(gamer1Name, gamer2Name);

		String Fishki[] = Speaker.doFigure(gamers);

		HumanGamer gamer1 = new HumanGamer();

		while ((zeroBoxes > 0)) {
			while (!Win) {

				Speaker.namePlayerWhoMove(listOfGamersNames.get(0) + " " + Fishki[0]);
				XY = gamer1.doMove();
				xoBoard.drawField(XY, Fishki, 0);

				Win = xoBoard.getWinLines(Fishki[0]);
				zeroBoxes = xoBoard.getEmptyBoxesInTheField();

				if (Win) {
					Speaker.GameWinner(1, listOfGamersNames.get(0));
					break;
				} else if (!Win && (zeroBoxes == 0)) {
					Speaker.GameWinner(0, "");
					break;
				}

				Speaker.namePlayerWhoMove(listOfGamersNames.get(1) + " "+ Fishki[1]);

				ComputerGamer gamer2 = new ComputerGamer();
				XY = gamer2.doMove(xoBoard, Fishki);

				xoBoard.drawField(XY, Fishki, 1);

				Win = xoBoard.getWinLines(Fishki[1]);
				zeroBoxes = xoBoard.getEmptyBoxesInTheField();

				if (Win) {
					Speaker.GameWinner(1, listOfGamersNames.get(1));
					break;
				} else if ((zeroBoxes == 0) && !Win) {
					Speaker.GameWinner(0, "");
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

		List<String> listOfGamersNames = new ArrayList<String>();
		listOfGamersNames = UserMenu.meetTheGamers(gamers);

		{
			listOfGamers.add(0, gamer1);
			listOfGamers.add(1, gamer3);
		}
		String gamer1Name = listOfGamersNames.get(0);
		String gamer2Name = listOfGamersNames.get(1);
		UserMenu.GameRules(gamer1Name, gamer2Name);

		String Fishki[] = Speaker.doFigure(gamers);
		System.out.println("Fishki[0] = " + Fishki[0]);
		System.out.println("Fishki[1] = " + Fishki[1]);

		while ((zeroBoxes > 0)) {
			while (!Win) {

				for (int p = 0; p <= 1; p++) {
					Speaker.namePlayerWhoMove(listOfGamersNames.get(p) + " "
							+ Fishki[p]);
					XY = listOfGamers.get(p).doMove(xoBoard, Fishki);
					xoBoard.drawField(XY, Fishki, p);

					Win = xoBoard.getWinLines(Fishki[p]);
					zeroBoxes = xoBoard.getEmptyBoxesInTheField();

					if (Win) {
						Speaker.GameWinner(1, listOfGamersNames.get(p));
						break;
					} else if ((zeroBoxes == 0) && !Win) {
						Speaker.GameWinner(0, "");
						break;
					}
				}
			}
		}
	}

	public void TwoHumansPlay(int gamers, Board xoBoard) {

		List<String> listOfGamersNames = new ArrayList<String>();

		listOfGamersNames = UserMenu.meetTheGamers(gamers);

		String gamer1Name = listOfGamersNames.get(0);
		String gamer2Name = listOfGamersNames.get(1);
		UserMenu.GameRules(gamer1Name, gamer2Name);

		String Fishki[] = Speaker.doFigure(gamers);

		HumanGamer gamer1 = new HumanGamer();
		HumanGamer gamer2 = new HumanGamer();

		List<HumanGamer> listOfGamers = new ArrayList<HumanGamer>();

		{
			listOfGamers.add(0, gamer1);
			listOfGamers.add(1, gamer2);
		}

		while ((zeroBoxes > 0)) {
			while (!Win) {
				for (int p = 0; p <= 1; p++) {
					Speaker.namePlayerWhoMove(listOfGamersNames.get(p) + " "
							+ Fishki[p]);
					XY = listOfGamers.get(p).doMove();

					xoBoard.drawField(XY, Fishki, p);

					Win = xoBoard.getWinLines(Fishki[p]);

					zeroBoxes = xoBoard.getEmptyBoxesInTheField();

					if (Win) {
						Speaker.GameWinner(1, listOfGamersNames.get(p));
						break;
					} else if ((zeroBoxes == 0) && !Win) {
						Speaker.GameWinner(0, "");
						break;
					}
				}
				break;
			}
		}
	}
}