package CrissCrossGame;

public class main {

	public static void main(String[] args) {
			if (Speaker.gameInvitation() == true) {
				
				Game game = new Game();
				game.play(Speaker.defineGamers());
			} else {
				Speaker.gameOver();
			}
		}
	}


