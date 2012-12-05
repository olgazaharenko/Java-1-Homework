package CrissCrossGame;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public void Play() {

		int gamers = Speaker.DefineGamers();
		Board xoBoard = new Board();

		switch (gamers) {
		case 1: {
			this.TwoHumansPlay(gamers, xoBoard);
			break;
		}
		case 2: {
			this.HumanWithAIPlay(gamers, xoBoard);
			break;
		}
		case 3: {
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

		char Fishki[] = Speaker.doFigure(gamers);

		HumanGamer gamer1 = new HumanGamer();

		int XY[] = new int[3];

		boolean Win = false;
		int zeroBoxes = 9;

		Speaker.namePlayerWhoMove(listOfGamersNames.get(0) + " " + Fishki[0]);
		XY = gamer1.doMove();
		xoBoard.drawField(XY, Fishki, 0);

		Win = xoBoard.returnLines(Fishki[0]);
		if (Win) {
			Speaker.GameWinner(1, listOfGamersNames.get(0));
		} else if ((zeroBoxes == 0) && !Win) {
			Speaker.GameWinner(0, "");
		} else {
			zeroBoxes = xoBoard.returnEmptyBoxesInTheField();
		}

		Speaker.namePlayerWhoMove(listOfGamersNames.get(1) + " " + Fishki[1]);

		ComputerGamer gamer2 = new ComputerGamer();
		XY = gamer2.doMove(xoBoard, Fishki);

		xoBoard.drawField(XY, Fishki, 1);

		Win = xoBoard.returnLines(Fishki[1]);
		if (Win) {
			Speaker.GameWinner(1, listOfGamersNames.get(1));
		} else if ((zeroBoxes == 0) && !Win) {
			Speaker.GameWinner(0, "");
		} else {
			zeroBoxes = xoBoard.returnEmptyBoxesInTheField();
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

		char Fishki[] = Speaker.doFigure(gamers);

		int XY[] = new int[3];

		boolean Win = false;
		int zeroBoxes = 9;

		for (int p = 0; p <= 1; p++) {
			Speaker.namePlayerWhoMove(listOfGamersNames.get(p) + " "
					+ Fishki[p]);
			XY = listOfGamers.get(p).doMove(xoBoard, Fishki);
			xoBoard.drawField(XY, Fishki, p);

			Win = xoBoard.returnLines(Fishki[p]);
			if (Win) {
				Speaker.GameWinner(1, listOfGamersNames.get(p));
				break;
			} else if ((zeroBoxes == 0) && !Win) {
				Speaker.GameWinner(0, "");
				break;
			} else {
				zeroBoxes = xoBoard.returnEmptyBoxesInTheField();
			}
		}
	}

	public void TwoHumansPlay(int gamers, Board xoBoard) {

		int zeroBoxes = 9;
		boolean Win = false;

		List<String> listOfGamersNames = new ArrayList<String>();

		listOfGamersNames = UserMenu.meetTheGamers(gamers);

		String gamer1Name = listOfGamersNames.get(0);
		String gamer2Name = listOfGamersNames.get(1);
		UserMenu.GameRules(gamer1Name, gamer2Name);

		char Fishki[] = Speaker.doFigure(gamers);

		HumanGamer gamer1 = new HumanGamer();
		HumanGamer gamer2 = new HumanGamer();

		List<HumanGamer> listOfGamers = new ArrayList<HumanGamer>();

		{
			listOfGamers.add(0, gamer1);
			listOfGamers.add(1, gamer2);
		}

		int XY[] = new int[3];
		
		while ((zeroBoxes > 0)) {
			while (!Win) {
				for (int p = 0; p <= 1; p++) {
					Speaker.namePlayerWhoMove(listOfGamersNames.get(p) + " "
							+ Fishki[p]);
					XY = listOfGamers.get(p).doMove();

					//System.out.println("p = "+ p);
					//System.out.println("XY[0] = "+ XY[0]);
					//System.out.println("XY[1] = "+ XY[1]);
					//System.out.println("zeroBoxes = "+ zeroBoxes);
					//System.out.println("Win = "+ Win);
			
					xoBoard.drawField(XY, Fishki, p);

					Win = xoBoard.returnLines(Fishki[p]);
					zeroBoxes = xoBoard.returnEmptyBoxesInTheField();
					
					if (Win) {
						Speaker.GameWinner(1, listOfGamersNames.get(p));
						break;
					} else if ((zeroBoxes == 0) && !Win) {
						Speaker.GameWinner(0, "");
						break;
					}
				} //end for
				break;
			} //end Win while 
		} //end zeroBoxes while
	} //end method TwoHumansPlay()
} //end class