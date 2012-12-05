package CrissCrossGame;

public class Board {

	private int fieldWidth = 3;
	private int maxBoxesInTheField = 0;
	public int lines = 0;
	
	String underScore = "_";
	
	String gameFieldBox [][] = new String [fieldWidth][fieldWidth];
	{
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				gameFieldBox[i][j] = underScore;
			}
		}
	}
	
	public int getFieldWidth() {
		return fieldWidth;
	}
	
	public void GameRules(String nameX, String nameO) {
		UserMenu.GameRules(nameX, nameO);
	}
	 
	public String[][] getGameFieldBox() {
		return gameFieldBox;
	}
	
	public String[][] setFinalGameBox(String Box[][]) {
		gameFieldBox = Box;
		return gameFieldBox;
	}
	
	public int getMaxBoxesInTheField (){
		return maxBoxesInTheField;
	}

	public int getEmptyBoxesInTheField (){
		int numberOfEmptyBoxes = 9;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if 	((gameFieldBox[i][j].equals("X")) || (gameFieldBox[i][j].equals("O"))) {
					numberOfEmptyBoxes = numberOfEmptyBoxes - 1;
					}	
				}
			}
		return numberOfEmptyBoxes;
	}

	public boolean getWinLines (String Fishka){
		boolean lines = false;
		//собрана левая вертикаль
		if 	((gameFieldBox[0][0] == Fishka) && (gameFieldBox[0][1] == Fishka) && (gameFieldBox[0][2] == Fishka)) {lines = true;}
			
		//собрана центральная вертикаль
		if 	((gameFieldBox[1][0] == Fishka) && (gameFieldBox[1][1] == Fishka) && (gameFieldBox[1][2] == Fishka)) {lines = true;}
				
		//собрана правая вертикаль
		if 	((gameFieldBox[2][0] == Fishka) && (gameFieldBox[2][1] == Fishka) && (gameFieldBox[2][2] == Fishka)) {lines = true;}
			
		//собрана верхняя горизонталь
		if 	((gameFieldBox[0][0] == Fishka) && (gameFieldBox[1][0] == Fishka) && (gameFieldBox[2][0] == Fishka)) {lines = true;}
			
		//собрана центральная горизонталь
		if 	((gameFieldBox[0][1] == Fishka) && (gameFieldBox[1][1] == Fishka) && (gameFieldBox[2][1] == Fishka)) {lines = true;}
			
		//собрана нижняя горизонталь
		if 	((gameFieldBox[0][2] == Fishka) && (gameFieldBox[1][2] == Fishka) && (gameFieldBox[2][2] == Fishka)) {lines = true;}

		//собрана центральная левая диагональ
		if 	((gameFieldBox[0][0] == Fishka) && (gameFieldBox[1][1] == Fishka) && (gameFieldBox[2][2] == Fishka)) {lines = true;}
			
		//собрана центральная правая диагональ
		if 	((gameFieldBox[2][0] == Fishka) && (gameFieldBox[1][1] == Fishka) && (gameFieldBox[0][2] == Fishka)) {lines = true;}

		return lines;
	}
	
	public String[][] drawField(int XY[], String[] fishki, int n) {
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if ((i == XY[0]) && (j == XY[1]) && (gameFieldBox[i][j] != fishki[0]) && (gameFieldBox[i][j] != fishki[1])) {
					gameFieldBox[i][j] = fishki[n];
				}
			}

			for (int j = 0; j <= 2; j++) {
				if ((gameFieldBox[i][j] != fishki[0]) && (gameFieldBox[i][j] != fishki[1])) {
					gameFieldBox[i][j] = underScore;
				}
			}		
		}
		UserMenu.drawField(gameFieldBox);
		return gameFieldBox; //нужно только для работы тестов.
	}
}
