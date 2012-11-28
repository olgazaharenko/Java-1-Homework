package XOX_Game;

public class main {

	public static void main(String[] args) {
		
		Speaker xoVoice = new Speaker();
		
		if (xoVoice.GameInvitation() == true) {
			Game xoParty = new Game();
			xoParty.GameStart();
		}
		else {
			xoVoice.GameOver();
		}
	}
}
 