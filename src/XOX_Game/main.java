package XOX_Game;

public class main {

	public static void main(String[] args) { 
		
		Speaker xoVoice = new Speaker();
		UserMenu xoMenu = new UserMenu();
		
		if (xoVoice.GameInvitation() == true) {
			Game xoParty = new Game();
			xoParty.GameStart(xoMenu, xoVoice);
		}
		else {
			xoVoice.GameOver();
		}
	}
}
 