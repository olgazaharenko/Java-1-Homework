package CrissCrossGame;

public class main {

	public static void main(String[] args) { 
		
		if (Speaker.GameInvitation() == true) {
			Game game = new Game();
			game.Play();
		} 
		else {
			Speaker.GameOver();
		}
	}
}
 