package xoGame;

public class xoGameBoard {
 
	/*
	 * Объект Поле
	 * - выводит правила игры на поле - метод GameRules()
	 * - отрисовывает графику поля (пустого или с ходом) одним перегруженным методом drawField ()
	 * или drawField (int x, int y, char F)
	 * - считывает ходы Игрока (неважно какого) - ReadXMove(), ReadYMove()
	 * - возвращает массив координат элементов множества пустых Клеток - EmptyFieldBoxes() 
	 * - хранит и возвращает информацию о максимальном количестве Клеток в поле - maxBoxInTheField
	 * - хранит и возвращает доступное количество пустых Клеток после каждого хода - returnEmptyBoxInTheField()
	 * - хранит и возвращает информацию о количестве заполненных Х линиях поля - returnLinesX()
	 * - хранит и возвращает информацию о количестве заполненных О линиях поля - returnLinesO()
	 */
	
	//переменная на случай крестиков-ноликов на бОльшем, чем 3х3 поле.
	//в данном случае равна 9, в общем случае равна x*x, где х длина стороны поля в клетках.
	public int maxBoxesInTheField = 9;

	public int lines = 0;
	
	char gameFieldBox [][] = new char [3][3];
	char finalGameFieldBox[][] = new char [3][3];
	char emptyBoxesInTheField[][] = new char [3][3];
	char setEmptyFieldBoxes[][] = new char [3][3];
	
	char underScore = '_';
	
	String Border = "--------------=======0===1===2=======--------------";
	String lineLeft = "-----------------=";
	String lineLeftEnd = " [";
	String lineRight = "=-----------------";
	String lineRightStart = "] ";
	String lineBetween = "] [";
	String longEmptyLine = "                                                   ";

	String xCoord = "Enter move's x coordinate: 0, 1 or 2: ";
	String yCoord = "Enter move's y coordinate: 0, 1 or 2: ";
	
	public void GameRules(String nameX, String nameO) {
		System.out.println("==X-O-X Game between "+ nameX + " and " + nameO + "==");
		System.out.println("=============================================");
		System.out.println("--------- You will see 3x3 field: -----------");
		System.out.println("--------------====0===1===2====--------------");
		System.out.println("--------------0= [ ] [ ] [ ] =0--------------");
		System.out.println("--------------1= [ ] [ ] [ ] =1--------------");
		System.out.println("--------------2= [ ] [ ] [ ] =2--------------");
		System.out.println("--------------====0===1===2====--------------");
		System.out.println("---------- Fill it either X or O. -----------");
		System.out.println("------- Winner will first one, who will -----");
		System.out.println("--- able to align your X or O in one line. --");
		System.out.println("=============================================");
	}

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
	public void drawField() {
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				finalGameFieldBox[i][j] = underScore;
				}
			}
		System.out.println(longEmptyLine);
		System.out.println(Border);
		System.out.println(lineLeft + "0" + lineLeftEnd + finalGameFieldBox [0][0] + lineBetween + finalGameFieldBox [1][0] + lineBetween + finalGameFieldBox [2][0] + lineRightStart + "0" + lineRight);
		System.out.println(lineLeft + "1" + lineLeftEnd + finalGameFieldBox [0][1] + lineBetween + finalGameFieldBox [1][1] + lineBetween + finalGameFieldBox [2][1] + lineRightStart + "1" + lineRight);
		System.out.println(lineLeft + "2" + lineLeftEnd + finalGameFieldBox [0][2] + lineBetween + finalGameFieldBox [1][2] + lineBetween + finalGameFieldBox [2][2] + lineRightStart + "2" + lineRight);
		System.out.println(Border);
		System.out.println(longEmptyLine);
	}
	
	//перегруженный метод отрисовки поля с координатами ходов
	/**
	 * @param humanXY
	 * @param aiXY
	 * @param fHuman
	 * @param fAI
	 */
	public void drawField(int humanXY[], int aiXY[], char fHuman, char fAI) {
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				//отрисовываем пустые, не совпавшие с ходом клетки подчеркиванием
				if ((gameFieldBox[i][j] != fHuman) && (gameFieldBox[i][j] != fAI)) {
					gameFieldBox[i][j] = underScore;
				} 
				
				//отрисовываем ход человека
				//если дошли до элемента массива с заданными координатами
				//и он свободен,
				if ((i == humanXY[0]) && (j == humanXY[1]) && (gameFieldBox[i][j] != underScore) && (gameFieldBox[i][j] != fAI) && (gameFieldBox[i][j] != fHuman)) {
					//вписываем символ в этот элемент
					gameFieldBox[i][j] = fHuman;
					//запоминаем его же в массив для печати
					finalGameFieldBox[i][j] = gameFieldBox[i][j];
				}
					
				//отрисовываем ход компьютера
				//если дошли до элемента массива с заданными координатами
				//и он свободен
				if ((i == aiXY[0]) && (j == aiXY[1]) && (gameFieldBox[i][j] != fAI) && (gameFieldBox[i][j] != fHuman)) {
					//вписываем символ в клетку с указанными координатами
					gameFieldBox[i][j] = fAI;
					//запоминаем его же в массив для печати
					finalGameFieldBox[i][j] = gameFieldBox[i][j];
				}
			}		
		}
			System.out.println(longEmptyLine);
			System.out.println(Border);
			System.out.println(lineLeft + "0" + lineLeftEnd + finalGameFieldBox [0][0] + lineBetween + finalGameFieldBox [1][0] + lineBetween + finalGameFieldBox [2][0] + lineRightStart + "0" + lineRight);
			System.out.println(lineLeft + "1" + lineLeftEnd + finalGameFieldBox [0][1] + lineBetween + finalGameFieldBox [1][1] + lineBetween + finalGameFieldBox [2][1] + lineRightStart + "1" + lineRight);
			System.out.println(lineLeft + "2" + lineLeftEnd + finalGameFieldBox [0][2] + lineBetween + finalGameFieldBox [1][2] + lineBetween + finalGameFieldBox [2][2] + lineRightStart + "2" + lineRight);
			System.out.println(Border);
			System.out.println(longEmptyLine);
	}
	
	//метод считывания введенных координат по оси X
	public int readXMove () {
		Integer x = 0;
    	x = Integer.parseInt(ReadUserInputHelper.getUserInput(xCoord));
	    return x;
	}

	//метод считывания введенных координат по оси Y
	public int readYMove () {
		Integer y = 0;
    	y = Integer.parseInt(ReadUserInputHelper.getUserInput(yCoord));
	    return y;
	}
	
}
