package XOX_Game;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public void GameStart(UserMenu xoMenu, Speaker xoVoice) {

		int gameOption = xoVoice.DefineGamers();
		int aiPlayersAmount = 0;

		Player Gamer1 = new Player();
		Player Gamer2 = new Player();

		switch (gameOption) {
		case 1:
			aiPlayersAmount = 0; // Human with Human
			break;
		case 2:
			aiPlayersAmount = 1; // Human with AI
			break;
		case 3:
			aiPlayersAmount = 2; // AI with AI
			break;
		}
		this.GamePlay(Gamer1, Gamer2, aiPlayersAmount, xoMenu, xoVoice);
	}

	public void GamePlay(Player Gamer1, Player Gamer2, int aiPlayersAmount,	UserMenu xoMenu, Speaker xoVoice) {

		List<Player> listOfPlayers = new ArrayList<Player>();

		{
			listOfPlayers.add(0, Gamer1);
			listOfPlayers.add(1, Gamer2);
		}

		String Pl1 = "";
		String Pl2 = "";

		switch (aiPlayersAmount) {
		case 0:
			Pl1 = listOfPlayers.get(0).setPlayerName(xoVoice);
			Pl2 = listOfPlayers.get(1).setPlayerName(xoVoice);
			break;
		case 1:
			Pl1 = listOfPlayers.get(0).setPlayerName(xoVoice);
			Pl2 = "Fantomaas";
			listOfPlayers.get(1).setPlayerName(Pl2);
			break;
		case 2:
			Pl1 = "Tomas";
			Pl2 = "Baron";
			listOfPlayers.get(0).setPlayerName(Pl1);
			listOfPlayers.get(1).setPlayerName(Pl2);
			break;
		}

		List<String> listOfPlayersName = new ArrayList<String>();
		{
			listOfPlayersName.add(0, Pl1);
			listOfPlayersName.add(1, Pl2);
		}

		xoMenu.GameRules(Pl1, Pl2);

		char Fishki[] = xoVoice.doFigure(aiPlayersAmount);
		int XY[] = new int[3];
		int zeroBoxes = 9;
		Board xoBoard = new Board();
		boolean Win = false;

		while ((zeroBoxes > 0)) {
			while (!Win) {
				switch (aiPlayersAmount) {
					case 0:
						for (int p = 0; p <= 1; p++) {
						xoVoice.namePlayerWhoMove(listOfPlayersName.get(p) + " " + Fishki[p]);
						XY = listOfPlayers.get(p).doMove(xoVoice);
						xoBoard.drawField(XY, Fishki, p);
						
						Win = xoBoard.returnLines(Fishki[p]);
						if (Win) {
							xoVoice.GameWinner(1, listOfPlayersName.get(p));
							break;
						}
						else if ((zeroBoxes == 0) && !Win) {
							xoVoice.GameWinner(0, "");
							break;
						}
						else {
							// TODO: вылечить ошибку не выхода из while когда уже 0 клеток осталось
							zeroBoxes = xoBoard.returnEmptyBoxesInTheField(); 
							System.out.println("Осталось свободных клеток: " + zeroBoxes);
						
							}
						}
						break;
					case 1:
						xoVoice.namePlayerWhoMove(listOfPlayersName.get(0) + " " + Fishki[0]);
						XY = listOfPlayers.get(0).doMove(xoVoice);
						xoBoard.drawField(XY, Fishki, 0);
						
						xoVoice.namePlayerWhoMove(listOfPlayersName.get(1) + " " + Fishki[1]);
						XY = listOfPlayers.get(1).doAIMove(xoBoard, Fishki);
						xoBoard.drawField(XY, Fishki, 1);
						break;
					case 2:
						for (int p = 0; p <= 1; p++) {
						xoVoice.namePlayerWhoMove(listOfPlayersName.get(p) + " " + Fishki[p]);
						XY = listOfPlayers.get(p).doAIMove(xoBoard, Fishki);
						xoBoard.drawField(XY, Fishki, p);
						
						Win = xoBoard.returnLines(Fishki[p]);
						if (Win) {
							xoVoice.GameWinner(1, listOfPlayersName.get(p));
							break;
						} 
						else if ((zeroBoxes == 0) && !Win) {
							xoVoice.GameWinner(0, "");
							break;
						}
						else {
							// TODO: вылечить ошибку не выхода из while когда уже 0 клеток осталось
							zeroBoxes = xoBoard.returnEmptyBoxesInTheField(); 
							System.out.println("Осталось свободных клеток: " + zeroBoxes);
						}
						}
						break;
					}

					
				}
			}
		}
	}