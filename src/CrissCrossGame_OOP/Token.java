package CrissCrossGame_OOP;

public enum Token {
	X("X"), O("O"), Empty("_");

	private String gameToken;

	Token(String gameToken) {
		this.gameToken = gameToken;
	}
}
