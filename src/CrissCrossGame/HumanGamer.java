package CrissCrossGame;

public class HumanGamer {

	private String playerName = "";
	
	public String setHumanGamerName() {
		playerName = Speaker.doName();
		return playerName;
	}
	
	public void setComputerPlayerName(String newPlayerName) {
		playerName = newPlayerName;
	}
	
	public String getComputerPlayerName() {
		return playerName;
	}
	
	public int[] doMove() {
		int XY[] = new int[2];
		XY[0] = Speaker.readXMove(); //x
		XY[1] = Speaker.readYMove(); //y
		return XY;
	}
}
