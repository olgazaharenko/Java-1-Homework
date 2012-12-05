package CrissCrossGame;

public class Board {

	Speaker xoVoice = new Speaker();
	UserMenu xoMenu = new UserMenu();
	
	public void GameRules(String nameX, String nameO) {
		UserMenu.GameRules(nameX, nameO);
	}
	 
	private int maxBoxesInTheField = 9;

	public int lines = 0;
	
	char gameFieldBox [][] = new char [3][3];
	//char finalGameFieldBox[][] = new char [3][3];
	char emptyBoxesInTheField[][] = new char [3][3];
	char setEmptyFieldBoxes[][] = new char [3][3];
	
	char underScore = '_';

	public char[][] returnGameFieldBox() {
		return gameFieldBox;
	}
	
	public char[][] setEmptyGameBox(char Box[][]) {
		emptyBoxesInTheField = Box;
		return emptyBoxesInTheField;
	}
	
	public char[][] setFinalGameBox(char Box[][]) {
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
				if 	(gameFieldBox[i][j] != underScore) {
					numberOfEmptyBoxes = numberOfEmptyBoxes - 1;
					}	
				}
			}
		return numberOfEmptyBoxes;
	}

	//метод определения координат элементов множества пустых клеток поля
		/*	public char [][] returnEmptyFieldBoxes() {

				char[][] setEmptyFieldBoxes = new char [3][3];

				for (int i = 0; i <= 2; i++) {
					for (int j = 0; i <= 2; j++) {
						if (gameFieldBox[i][j] == underScore) {
							setEmptyFieldBoxes [i][j] = gameFieldBox[i][j];
						}
						}
					}
				return setEmptyFieldBoxes;
			}*/
	
	/*public boolean returnLines (char Fishka){
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
	
	public boolean returnLines (char Fishka){
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
	public void drawField(char Box[][]) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					Box[i][j] = underScore;
					}
				}
		UserMenu.drawField(Box);
	}
		
	//перегруженный метод отрисовки поля с координатами ходов
	public char [][] drawField(int XY[], char fishki[], int n) {
		char fPl1 = fishki[0];
		char fPl2 = fishki[1];
		
		System.out.println("fPl1 = " + fishki[0]);
		System.out.println("fPl2 = " + fishki[1]);
		
		System.out.println("XY[0] = " + XY[0]);
		System.out.println("XY[1] = " + XY[1]);
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
	
				//если дошли до элемента массива с заданными координатами
				//и он свободен,
				if ((i == XY[0]) && (j == XY[1]) && (gameFieldBox[i][j] != underScore) && (gameFieldBox[i][j] != fPl2) && (gameFieldBox[i][j] != fPl1)) {
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
		//UserMenu.drawField(gameFieldBox);
		
		return gameFieldBox;
	}
}
