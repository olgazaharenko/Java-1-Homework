package CrissCrossGame;

public class Board {

	Speaker xoVoice = new Speaker();
	UserMenu xoMenu = new UserMenu();
	
	public void GameRules(String nameX, String nameO) {
		UserMenu.GameRules(nameX, nameO);
	}
	 
	private int maxBoxesInTheField = 9;

	public int lines = 0;
	
	String underScore = "_";
	
	String gameFieldBox [][] = new String [3][3];
	{
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				gameFieldBox[i][j] = underScore;
			}
		}
	}
	
	//char finalGameFieldBox[][] = new char [3][3];
	//char emptyBoxesInTheField[][] = new char [3][3];
	//char setEmptyFieldBoxes[][] = new char [3][3];
	
	public String[][] returnGameFieldBox() {
		return gameFieldBox;
	}
	
	/*public char[][] setEmptyGameBox(char Box[][]) {
		emptyBoxesInTheField = Box;
		return emptyBoxesInTheField;
	}*/
	
	public String[][] setFinalGameBox(String Box[][]) {
		gameFieldBox = Box;
		return gameFieldBox;
	}
	
	public int returnMaxBoxesInTheField (){
		return maxBoxesInTheField;
	}

	public int returnEmptyBoxesInTheField (){
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

	/* public boolean returnLines (char Fishka){
		boolean lines = false;
		//собрана левая вертикаль
		if 	((finalGameFieldBox[0][0] == Fishka) && (finalGameFieldBox[0][1] == Fishka) && (finalGameFieldBox[0][2] == Fishka)) {lines = true;}
			
		//собрана центральная вертикаль
		if 	((finalGameFieldBox[1][0] == Fishka) && (finalGameFieldBox[1][1] == Fishka) && (finalGameFieldBox[1][2] == Fishka)) {lines = true;}
				
		//собрана правая вертикаль
		if 	((finalGameFieldBox[2][0] == Fishka) && (finalGameFieldBox[2][1] == Fishka) && (finalGameFieldBox[2][2] == Fishka)) {lines = true;}
			
		//собрана верхняя горизонталь
		if 	((finalGameFieldBox[0][0] == Fishka) && (finalGameFieldBox[1][0] == Fishka) && (finalGameFieldBox[2][0] == Fishka)) {lines = true;}
			
		//собрана центральная горизонталь
		if 	((finalGameFieldBox[0][1] == Fishka) && (finalGameFieldBox[1][1] == Fishka) && (finalGameFieldBox[2][1] == Fishka)) {lines = true;}
			
		//собрана нижняя горизонталь
		if 	((finalGameFieldBox[0][2] == Fishka) && (finalGameFieldBox[1][2] == Fishka) && (finalGameFieldBox[2][2] == Fishka)) {lines = true;}

		//собрана центральная левая диагональ
		if 	((finalGameFieldBox[0][0] == Fishka) && (finalGameFieldBox[1][1] == Fishka) && (finalGameFieldBox[2][2] == Fishka)) {lines = true;}
			
		//собрана центральная правая диагональ
		if 	((finalGameFieldBox[2][0] == Fishka) && (finalGameFieldBox[1][1] == Fishka) && (finalGameFieldBox[0][2] == Fishka)) {lines = true;}

		return lines;
	}*/
		
	public boolean returnLines (String Fishka){
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
	
	//перегруженный метод отрисовки поля без координат ходов
	public void drawField(String Box[][]) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					Box[i][j] = underScore;
					}
				}
		UserMenu.drawField(Box);
	}
	
	//перегруженный метод отрисовки поля с координатами ходов
	//public char [][] drawField(int XY[], char fishki[], int n) {
	public String[][] drawField(int XY[], String[] fishki, int n) {
		String fPl1 = fishki[0];
		String fPl2 = fishki[1];
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
	
				//если дошли до элемента массива с координатами ходов
				//и он не занят ни крестиком, ни ноликом
				if ((i == XY[0]) && (j == XY[1]) && (gameFieldBox[i][j] != fPl2) && (gameFieldBox[i][j] != fPl1)) {
				//if ((i == XY[0]) && (j == XY[1]) && (gameFieldBox[i][j] != underScore) && (gameFieldBox[i][j] != fPl2) && (gameFieldBox[i][j] != fPl1)) {
					//вписываем символ в этот элемент
					gameFieldBox[i][j] = fishki[n];
					//запоминаем его же в массив для печати
					//finalGameFieldBox[i][j] = gameFieldBox[i][j];
				}
			}

			//отрисовываем пустые, не совпавшие с ходом клетки подчеркиванием
			for (int j = 0; j <= 2; j++) {
				//if ((finalGameFieldBox[i][j] != fPl1) && (finalGameFieldBox[i][j] != fPl2)) {
				//	finalGameFieldBox[i][j] = underScore;
				//}
				if ((gameFieldBox[i][j] != fPl1) && (gameFieldBox[i][j] != fPl2)) {
					gameFieldBox[i][j] = underScore;
				}
				
			}		
		}
		UserMenu.drawField(gameFieldBox);
		
		return gameFieldBox;
	}
}
