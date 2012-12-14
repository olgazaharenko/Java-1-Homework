package CrissCrossGame_OOP;

public enum Token {
	FIRST("X"), SECOND("O"), EMPTY("_");

	private String gameToken;

	Token(String gameToken) {
		this.gameToken = gameToken;
	}
	
	public String getGameToken() {
		return this.gameToken;
	}
}
