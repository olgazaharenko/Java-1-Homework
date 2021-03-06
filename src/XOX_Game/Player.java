package XOX_Game;

public class Player {

	private String playerName = "";
	
	public String setPlayerName(Speaker xoVoice) {
		playerName = xoVoice.doName();
		return playerName;
	}
	
	public void setPlayerName(String newPlayerName) {
		playerName = newPlayerName;
	}
	
	public int[] doMove(Speaker xoVoice) {
		int XY[] = new int[2];
		XY[0] = xoVoice.readXMove(); //x
		XY[1] = xoVoice.readYMove(); //y
		return XY;
	}	
	
	public int[] doAIMove(Board board, char[] Fishki) {
		int XY[] = new int[2];
		char emptyGameFieldBox[][] = new char [3][3];
		emptyGameFieldBox = board.returnFinalGameFieldBox();
		//TODO: перебираем все клетки поля
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				//исключая заполненные клетки
				if ((emptyGameFieldBox[i][j] != Fishki[0]) && (emptyGameFieldBox[i][j] != Fishki[1])) {
					
					//по каждой клетке проверяем, если вероятность выиграть равна 0 или 1,
					int q = checkWinBoxToMove(board, i, j, Fishki);
					if (q >= 0) {
						//то делаем ход в первую попавшуюся пустую клетку с достаточным уровнем вероятности выиграть
						System.out.println("For box "+ emptyGameFieldBox[i][j] + " ["+i+"]"+"["+j+"]"+" p = "+q);
						XY[0] = i;
						XY[1] = j;
						break;
					}
				}
			}
		} 
		return XY;
	}
	
	public static int checkWinBoxToMove(Board board, int xAI, int yAI, char[] Fishki) {
	/* Реализация критерия выбора хода компьютером
	 *
	 * определим функцию p - шанс для компьютера выиграть, сделав ход в клетку с координатами (i,j)
	 * как (1, 0, -1)
	 * p = 1, если на одной линии с клеткой (i,j) есть клетки, где уже поставлена своя фигура
	 * p = 0, если все клетки на одной линии с клеткой (i,j) пусты
	 * p = -1, если на одной линии с клеткой (i,j) более 0 клеток 
	 * уже заняты противоположной фигурой
	 *  
	 * выбираем для хода компьютера клетку с наибольшим значением функции p
	 *
	 * определим линии относительно клеток, которые нужно проверять на наличие либо
	 * своей фигуры, либо фигуры противника 
	 * и присваивать клетке значение функции p по результату проверки
	 * 
	 */
		
		char xFishka = Fishki[0];
		char oFishka = Fishki[1];
		
		//Получить состояние поля на момент оценки
		char t[][] = new char [3][3];
		t = board.returnFinalGameFieldBox();
		
		//изначально считаем, что линии пусты и готовимся к ходу
		int p = 0;

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				
			//берем незанятую клетку
			if ((t[i][j] != xFishka) && (t[i][j] != oFishka)) {

			//в зависимости от координат выбранной клетки пробегаем по линиям:

			//(0,0):
			//{(1,1),(2,2)}
			//{(0,1),(0,2)}
			//{(1,0),(2,0)}
			//
				
			if ((i==0) && (j==0)) {
				if ((t[1][1] == xFishka) || (t[2][2] == xFishka) || (t[0][1] == xFishka) || (t[0][2] == xFishka || (t[1][0] == xFishka) || (t[2][0] == xFishka))) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[1][1] == oFishka) || (t[2][2] == oFishka) || (t[0][1] == oFishka) || (t[0][2] == oFishka || (t[1][0] == oFishka) || (t[2][0] == oFishka))) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}
				
			//
			//(1,0):
			//{(0,0),(2,0)}
			//{(1,1),(1,2)}
			//
				
			if ((i==1) && (j==0)) {
				if ((t[0][0] == xFishka) || (t[2][0] == xFishka) || (t[1][1] == xFishka) || (t[1][2] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[0][0] == oFishka) || (t[2][0] == oFishka) || (t[1][1] == oFishka) || (t[1][2] == oFishka)) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}
				
			//(2,0):
			//{(0,0),(1,0)}
			//{(2,1),(2,2)}
			//{(1,1),(0,2)}
				
			if ((i==2) && (j==0)) {
				if ((t[0][0] == xFishka) || (t[1][0] == xFishka) || (t[2][1] == xFishka) || (t[2][2] == xFishka) || (t[1][1] == xFishka) || (t[0][2] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[0][0] == oFishka) || (t[1][0] == oFishka) || (t[2][1] == oFishka) || (t[2][2] == oFishka) || (t[1][1] == oFishka) || (t[0][2] == oFishka)) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}
				
			//
			//(0,1):
			//{(0,0),(0,2)}
			//{(1,1),(2,1)}
			//
				
			if ((i==0) && (j==1)) {
				if ((t[0][0] == xFishka) || (t[0][2] == xFishka) || (t[1][1] == xFishka) || (t[2][1] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[0][0] == oFishka) || (t[0][2] == oFishka) || (t[1][1] == oFishka) || (t[2][1]) == oFishka) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}			
				
			//(1,1):
			//{(0,0),(2,2)}
			//{(0,2),(2,0)}
			//{(0,1),(2,1)}
			//{(1,0),(1,2)}
			//
			if ((i==1) && (j==1)) {
				if ((t[0][0] == xFishka) || (t[2][2] == xFishka) || (t[0][2] == xFishka) || (t[0][1] == xFishka)  || (t[2][1] == xFishka)  || (t[1][0] == xFishka)  || (t[1][2] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[0][0] == oFishka) || (t[2][2] == oFishka) || (t[0][2] == oFishka) || (t[0][1] == oFishka)  || (t[2][1] == oFishka)  || (t[1][0] == oFishka)  || (t[1][2] == oFishka)) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}			

			//(2,1):
			//{(2,0),(2,2)}
			//{(0,1),(2,1)}
			//

			if ((i==2) && (j==1)) {
				if ((t[2][0] == xFishka) || (t[2][2] == xFishka) || (t[0][1] == xFishka) || (t[2][1] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[2][0] == oFishka) || (t[2][2] == oFishka) || (t[0][1] == oFishka) || (t[2][1]) == oFishka) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}			
			
			//(0,2):
			//{(0,0),(0,1)}
			//{(1,1),(2,0)}
			//{(1,2),(2,2)}
			//
				
			if ((i==0) && (j==2)) {
				if ((t[0][0] == xFishka) || (t[0][1] == xFishka) || (t[1][1] == xFishka) || (t[2][0] == xFishka) || (t[1][2] == xFishka) || (t[2][2] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[0][0] == oFishka) || (t[0][1] == oFishka) || (t[1][1] == oFishka) || (t[2][0] == oFishka) || (t[1][2] == oFishka) || (t[2][2] == oFishka)) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}
			
			//(1,2):
			//{(1,0),(1,1)}
			//{(0,2),(2,2)}
			//
				
			if ((i==1) && (j==2)) {
				if ((t[1][0] == xFishka) || (t[1][1] == xFishka) || (t[0][2] == xFishka) || (t[2][2] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[1][0] == oFishka) || (t[1][1] == oFishka) || (t[0][2] == oFishka) || (t[2][2]) == oFishka) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}
				
			//(2,2):
			//{(0,0),(1,1)}
			//{(0,2),(1,2)}
			//{(2,0),(2,1)}
			//

			if ((i==2) && (j==2)) {
				if ((t[0][0] == xFishka) || (t[1][1] == xFishka) || (t[0][2] == xFishka) || (t[1][2] == xFishka) || (t[2][0] == xFishka) || (t[2][1] == xFishka)) { 
					//если есть своя фигура на клетках линий
					p = 1;
				} else if ((t[0][0] == oFishka) || (t[1][1] == oFishka) || (t[0][2] == oFishka) || (t[1][2] == oFishka) || (t[2][0] == oFishka) || (t[2][1] == oFishka)) {
					//если есть фигура противника на клетках линий
					p = -1;
				}
			}
		}
		}
		}
		return p;
	}
			
	
}
