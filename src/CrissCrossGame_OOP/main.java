package CrissCrossGame_OOP;

public class main {

	public static void main(String[] args) {
			if (Speaker.gameInvitation() == true) {
				Game game = new Game();
				game.go();
			} else {
				Speaker.gameOver();
			}
		}
	}


