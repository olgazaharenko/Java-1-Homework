package XOX_Game;

public class Board {
 
	/*
	 * Объект Поле
	 * - считывает ходы Игрока (неважно какого) - ReadXMove(), ReadYMove()
	 * - возвращает массив координат элементов множества пустых Клеток - EmptyFieldBoxes() 
	 * - хранит и возвращает информацию о максимальном количестве Клеток в поле - maxBoxInTheField
	 * - хранит и возвращает доступное количество пустых Клеток после каждого хода - returnEmptyBoxInTheField()
	 * - хранит и возвращает информацию о количестве заполненных Х линиях поля - returnLinesX()
	 * - хранит и возвращает информацию о количестве заполненных О линиях поля - returnLinesO()
	 */
	
	Speaker xoVoice = new Speaker();
	UserMenu xoMenu = new UserMenu();
	
	public void GameRules(String nameX, String nameO) {
		xoMenu.GameRules(nameX, nameO);
	}
	
	private int maxBoxesInTheField = 9;

	public int lines = 0;
	
	char gameFieldBox [][] = new char [3][3];
	char finalGameFieldBox[][] = new char [3][3];
	char emptyBoxesInTheField[][] = new char [3][3];
	char setEmptyFieldBoxes[][] = new char [3][3];
	
	char underScore = '_';

	public char[][] returnFinalGameFieldBox() {
		return finalGameFieldBox;
	}
	
	public int returnMaxBoxesInTheField (){
		return maxBoxesInTheField;
	}

	public int returnEmptyBoxesInTheField (){
		int numberOfEmptyBoxes = 9;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if 	(finalGameFieldBox[i][j] != underScore) {
					numberOfEmptyBoxes = numberOfEmptyBoxes - 1;
					}	
				}
			}
		return numberOfEmptyBoxes;
	}

	//метод определения координат элементов множества пустых клеток поля
		public char [][] returnEmptyFieldBoxes() {

			char[][] setEmptyFieldBoxes = new char [3][3];

			for (int i = 0; i <= 2; i++) {
				for (int j = 0; i <= 2; j++) {
					if (gameFieldBox[i][j] == underScore) {
						setEmptyFieldBoxes [i][j] = gameFieldBox[i][j];
					}
					}
				}
			return setEmptyFieldBoxes;
		}
	
	public boolean returnLines (char Fishka){
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
	}
	
	//перегруженный метод отрисовки поля без координат ходов
	public void drawField(char Box[][]) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					Box[i][j] = underScore;
					}
				}
		xoMenu.drawField(Box);
	}
		
		
	//перегруженный метод отрисовки поля с координатами ходов
	public void drawField(int XY[], char fishki[]) {
		char fHuman = fishki[0];
		char fAI = fishki[1];

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				
				//отрисовываем пустые, не совпавшие с ходом клетки подчеркиванием
				if ((gameFieldBox[i][j] != fHuman) && (gameFieldBox[i][j] != fAI)) {
					gameFieldBox[i][j] = underScore;
				} 
				
				//если дошли до элемента массива с заданными координатами
				//и он свободен,
				
				if ((i == XY[0]) && (j == XY[1]) && (gameFieldBox[i][j] != underScore) && (gameFieldBox[i][j] != fAI) && (gameFieldBox[i][j] != fHuman)) {
					//вписываем символ в этот элемент
					gameFieldBox[i][j] = fHuman;
					//запоминаем его же в массив для печати
					finalGameFieldBox[i][j] = gameFieldBox[i][j];
				}
			}		
		}
		xoMenu.drawField(finalGameFieldBox);
	}
}
