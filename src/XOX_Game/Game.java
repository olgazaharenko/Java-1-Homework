package XOX_Game;

import java.util.ArrayList;
import java.util.List;

public class Game {

	Speaker xoVoice = new Speaker();
	UserMenu xoMenu = new UserMenu();

	boolean Win1 = false;
	boolean Win2 = false;
	
	int XY[] = new int[3];
	
	int g = xoVoice.DefineGamers();
	
	char Fishki[] = xoVoice.doFigure();
	
	Board xoBoard = new Board();
	int zeroBoxes = 9; 
	{
	xoBoard.drawField(xoBoard.finalGameFieldBox);
	}
	
	public void GameStart() {
 		
		switch(g) {
			//Human with Human
			case 1: {
				Player hPlayer1 = new Player();
				Player hPlayer2 = new Player();
				
				String hPl1 = xoVoice.doName();
				String hPl2 = xoVoice.doName();
				
				List <Player> listOfHumanPlayers = new ArrayList <Player>();{
					listOfHumanPlayers.add(1, hPlayer1);
					listOfHumanPlayers.add(2, hPlayer2);
				}
				
				xoMenu.GameRules(hPl1, hPl2);
				
				this.GamePlay(listOfHumanPlayers, hPl1, hPl2);
				break; 
				}
			//Human with AI
			case 2: {
				Player hPlayer1 = new Player();
				Player aiPlayer1 = new Player();
				
				String hPl1 = xoVoice.doName();
				String aiPl1 = "Dr. Zlo";
				
				List <Player> listOfMixPlayers = new ArrayList <Player>();{
					listOfMixPlayers.add(1, hPlayer1);
					listOfMixPlayers.add(2, aiPlayer1);
				}
				
				xoMenu.GameRules(hPl1, aiPl1);
				
				this.GamePlay(listOfMixPlayers, hPl1, aiPl1);				
				break; 
				}
			//AI with AI
			case 3: {
				Player aiPlayer1 = new Player();
				Player aiPlayer2 = new Player();
				
				String aiPl1 = "Fantomaaas";
				String aiPl2 = "Dr. Zlo";
				
				List <Player> listOfAIPlayers = new ArrayList <Player>();{
					listOfAIPlayers.add(1, aiPlayer1);
					listOfAIPlayers.add(2, aiPlayer2);
				}
				xoMenu.GameRules(aiPl1, aiPl2);
				
				this.GamePlay(listOfAIPlayers, aiPl1, aiPl2);	
				break;
			}
		}
	}

	public void GamePlay(List <Player> listOfPlayers, String Pl1, String Pl2) {
		//пока есть пустые клетки на поле, либо никто не выиграл	
		while ((zeroBoxes > 0) || !Win1 || !Win2 ){ 
	
			for (int p = 1; p<3; p++) {
				XY = listOfPlayers.get(p).doMove();
				xoBoard.drawField(XY, Fishki);
				Win1 = xoBoard.returnLines(Fishki[0]);
				Win2 = xoBoard.returnLines(Fishki[1]);
				zeroBoxes = xoBoard.returnEmptyBoxesInTheField();
			}
			if (Win1) {
				xoVoice.GameWinnerNameIs(Pl1);
				break;
			} 
			
			if (Win2) {
				xoVoice.GameWinnerNameIs(Pl2);
				break;
			} 
		}	
	}
	
	//выбрать, кто с кем играет
	public int DefineGamers () {
		Integer who = 0;
		who = xoVoice.DefineGamers();
		return who;
	}
}