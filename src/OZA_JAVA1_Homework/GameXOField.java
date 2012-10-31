package OZA_JAVA1_Homework;

import java.util.Scanner;

public class GameXOField {
 
	/*
	 * Объект Поле
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

	public int emptyBoxesInTheField = 9;
	public int linesX = 0;
	public int linesO = 0;
	
	char gameFieldBox [][] = new char [3][3];
	char underScore = '_';

	String Border = "--------------=======================--------------";
	String lineLeft = "--------------== [";
	String lineRight = "] ==--------------";
	String lineBetween = "] [";

	String xCoord = "Enter move's x coordinate: 0, 1 or 2: ";
	String yCoord = "Enter move's y coordinate: 0, 1 or 2: ";
	
	public int returnMaxBoxesInTheField (){
		return maxBoxesInTheField;
	}

	//каждый вызов метода уменьшает счетчик на 1
	//k - число ходов
	public int returnEmptyBoxesInTheField (int k){
		while (k > 0) {
		emptyBoxesInTheField = emptyBoxesInTheField - 1 * k;
		}
		return emptyBoxesInTheField;
	}
	//каждый вызов метода увеличивает счетчик на 1
	public int returnLinesX (){
		linesX = linesX + 1;
		return linesX;
	}
	
	//каждый вызов метода увеличивает счетчик на 1
	public int returnLinesO (){
		linesO = linesO + 1;
		return linesO;
	}
	
		
	//перегруженный метод отрисовки поля без координат ходов
	public void drawField() {

		char finalGameFieldBox[][] = new char [3][3];
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; i <= 2; j++) {
				finalGameFieldBox[i][j] = underScore;
				}
			}
		
		System.out.println(Border);
		System.out.println(lineLeft + finalGameFieldBox [0][0] + lineBetween + finalGameFieldBox [1][0] + lineBetween + finalGameFieldBox [2][0] + lineRight);
		System.out.println(lineLeft + finalGameFieldBox [0][1] + lineBetween + finalGameFieldBox [1][1] + lineBetween + finalGameFieldBox [2][1] + lineRight);
		System.out.println(lineLeft + finalGameFieldBox [0][2] + lineBetween + finalGameFieldBox [1][2] + lineBetween + finalGameFieldBox [2][2] + lineRight);
		System.out.println(Border);
		
	}
	
	//перегруженный метод отрисовки поля с координатами ходов
	public void drawField(int x, int y, char F) {

		char finalGameFieldBox[][] = new char [3][3];
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; i <= 2; j++) {
				gameFieldBox[i][j] = underScore;
				}
			}
		
		gameFieldBox[x][y] = F;
		finalGameFieldBox[x][y] = gameFieldBox[x][y];
		
		System.out.println(Border);
		System.out.println(lineLeft + finalGameFieldBox [0][0] + lineBetween + finalGameFieldBox [1][0] + lineBetween + finalGameFieldBox [2][0] + lineRight);
		System.out.println(lineLeft + finalGameFieldBox [0][1] + lineBetween + finalGameFieldBox [1][1] + lineBetween + finalGameFieldBox [2][1] + lineRight);
		System.out.println(lineLeft + finalGameFieldBox [0][2] + lineBetween + finalGameFieldBox [1][2] + lineBetween + finalGameFieldBox [2][2] + lineRight);
		System.out.println(Border);
		
	}
	
	//метод считывания введенных координат по оси X
	public int readXMove () {
		int x;
    	System.out.println (xCoord);
	    Scanner xReader = new Scanner(System.in);
	    x = xReader.nextInt();
	    return x;
	}

	//метод считывания введенных координат по оси Y
	public int readYMove () {
		int y;
    	System.out.println (yCoord);
	    Scanner yReader = new Scanner(System.in);
	    y = yReader.nextInt();
	    return y;
	}
	
	//метод определения координат элементов множества пустых клеток поля
	public int [][] EmptyFieldBoxes() {
		
		int[][] setEmptyFieldBoxes = new int [3][3];
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; i <= 2; j++) {
				if (gameFieldBox[i][j] == underScore) {
					setEmptyFieldBoxes [i][j] = gameFieldBox[i][j];
				}
				}
			}
		return setEmptyFieldBoxes;
	}
	
}
