package CrissCrossGame_OOP;

public class Core {

	public static void main(String[] args) {
			if (Speaker.gameInvitation() == true) {
				UserMenu.GameRules();
				Game game = new Game();
				game.go();
			} else {
				Speaker.gameOver();
			}
		}
	}


