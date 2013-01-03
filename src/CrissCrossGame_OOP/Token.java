package CrissCrossGame_OOP;

public enum Token {
	X("X"), O("O"), NO("_");

	private String value;

	Token(String gameToken) {
		this.value = gameToken;
	}
		
	@Override
	public String toString() {
		return value;
	}
	
}
