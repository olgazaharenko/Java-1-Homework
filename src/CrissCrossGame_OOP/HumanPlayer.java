package CrissCrossGame_OOP;

public class HumanPlayer extends Player {

	@Override
	public int[] doMove(Board xoBoard, String Fishki[]) {
		int XY[] = new int[2];
		XY[0] = Speaker.readXMove(); //x
		XY[1] = Speaker.readYMove(); //y
		return XY;
	}
	
}
