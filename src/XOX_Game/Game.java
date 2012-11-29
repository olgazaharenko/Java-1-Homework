package XOX_Game;

import java.util.ArrayList;
import java.util.List;

public class Game {

	Speaker xoVoice = new Speaker();
	UserMenu xoMenu = new UserMenu();

	boolean Win = false;
	
	int XY[] = new int[3];
	
	int gameOption = xoVoice.DefineGamers();
	
	char Fishki[] = xoVoice.doFigure();
	
	int zeroBoxes = 9; 
	
	Board xoBoard = new Board();
	
	public void GameStart() {
 		
		switch(gameOption) {
			//Human with Human
			case 1: {
				Player hPlayer1 = new Player();
				Player hPlayer2 = new Player();
				
				String hPl1 = xoVoice.doName();
				String hPl2 = xoVoice.doName();
				
				List <Player> listOfHumanPlayers = new ArrayList <Player>();{
					listOfHumanPlayers.add(0, hPlayer1);
					listOfHumanPlayers.add(1, hPlayer2);
				}
				
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
				
				this.GamePlay(listOfAIPlayers, aiPl1, aiPl2);	
				break;
			}
		}
	}

	public void GamePlay(List <Player> listOfPlayers, String Pl1, String Pl2) {
		
		xoMenu.GameRules(Pl1, Pl2);
		
		//пока есть пустые клетки на поле, либо никто не выиграл	
		while ((zeroBoxes > 0) || !Win ){ 
	
			for (int p = 0; p<1; p++) {
				//TODO: xoVoice.namePlayerWhoMove(movePlayer);
				XY = listOfPlayers.get(p).doMove();
				xoBoard.drawField(XY, Fishki);
				Win = xoBoard.returnLines(Fishki[p]);
				zeroBoxes = xoBoard.returnEmptyBoxesInTheField();
				
				if (Win) {
					xoVoice.GameWinnerNameIs(Pl1);
					break;
				} 
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