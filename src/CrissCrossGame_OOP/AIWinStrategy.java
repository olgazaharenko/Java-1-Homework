package CrissCrossGame_OOP;

public class AIWinStrategy {

	public static int checkWinBoxToMove(Board board, int xAI, int yAI) {
		/*
		 * Реализация критерия выбора хода компьютером
		 * 
		 * определим функцию p - шанс для компьютера выиграть, сделав ход в
		 * клетку с координатами (i,j) как (1, 0, -1) p = 1, если на одной линии
		 * с клеткой (i,j) есть клетки, где уже поставлена своя фигура p = 0,
		 * если все клетки на одной линии с клеткой (i,j) пусты p = -1, если на
		 * одной линии с клеткой (i,j) более 0 клеток уже заняты противоположной
		 * фигурой
		 * 
		 * выбираем для хода компьютера клетку с наибольшим значением функции p
		 * 
		 * определим линии относительно клеток, которые нужно проверять на
		 * наличие либо своей фигуры, либо фигуры противника и присваивать
		 * клетке значение функции p по результату проверки
		 */

		// Получить состояние поля на момент оценки
		String t[][] = new String[3][3];
		t = board.getGameFieldBox();

		// изначально считаем, что линии пусты и готовимся к ходу
		int p = 0;

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {

				// берем незанятую клетку
				if ((t[i][j] != Token.FIRST.getGameToken()) && (t[i][j] != Token.SECOND.getGameToken())) {

					// в зависимости от координат выбранной клетки пробегаем по
					// линиям:

					// (0,0):
					// {(1,1),(2,2)}
					// {(0,1),(0,2)}
					// {(1,0),(2,0)}
					//

					if ((i == 0) && (j == 0)) {
						if ((t[1][1] == Token.FIRST.getGameToken())
								|| (t[2][2] == Token.FIRST.getGameToken())
								|| (t[0][1] == Token.FIRST.getGameToken())
								|| (t[0][2] == Token.FIRST.getGameToken() || (t[1][0] == Token.FIRST.getGameToken()) || (t[2][0] == Token.FIRST.getGameToken()))) {
							// если есть своя фигура на клетках линий
							p = 1;
						} else if ((t[1][1] == Token.SECOND.getGameToken())
								|| (t[2][2] == Token.SECOND.getGameToken())
								|| (t[0][1] == Token.SECOND.getGameToken())
								|| (t[0][2] == Token.SECOND.getGameToken() || (t[1][0] == Token.SECOND.getGameToken()) || (t[2][0] == Token.SECOND.getGameToken()))) {
							// если есть фигура противника на клетках линий
							p = -1;
						}
					}

					//
					// (1,0):
					// {(0,0),(2,0)}
					// {(1,1),(1,2)}
					//

					if ((i == 1) && (j == 0)) {
						if ((t[0][0] == Token.FIRST.getGameToken()) || (t[2][0] == Token.FIRST.getGameToken())
								|| (t[1][1] == Token.FIRST.getGameToken()) || (t[1][2] == Token.FIRST.getGameToken())) {
							// если есть своя фигура на клетках линий
							p = 1;
						} else if ((t[0][0] == Token.SECOND.getGameToken()) || (t[2][0] == Token.SECOND.getGameToken())
								|| (t[1][1] == Token.SECOND.getGameToken()) || (t[1][2] == Token.SECOND.getGameToken())) {
							// если есть фигура противника на клетках линий
							p = -1;
						}
					}

					// (2,0):
					// {(0,0),(1,0)}
					// {(2,1),(2,2)}
					// {(1,1),(0,2)}

					if ((i == 2) && (j == 0)) {
						if ((t[0][0] == Token.FIRST.getGameToken()) || (t[1][0] == Token.FIRST.getGameToken())
								|| (t[2][1] == Token.FIRST.getGameToken()) || (t[2][2] == Token.FIRST.getGameToken())
								|| (t[1][1] == Token.FIRST.getGameToken()) || (t[0][2] == Token.FIRST.getGameToken())) {
							// если есть своя фигура на клетках линий
							p = 1;
						} else if ((t[0][0] == Token.SECOND.getGameToken()) || (t[1][0] == Token.SECOND.getGameToken())
								|| (t[2][1] == Token.SECOND.getGameToken()) || (t[2][2] == Token.SECOND.getGameToken())
								|| (t[1][1] == Token.SECOND.getGameToken()) || (t[0][2] == Token.SECOND.getGameToken())) {
							// если есть фигура противника на клетках линий
							p = -1;
						}
					}

					//
					// (0,1):
					// {(0,0),(0,2)}
					// {(1,1),(2,1)}
					//

					if ((i == 0) && (j == 1)) {
						if ((t[0][0] == Token.FIRST.getGameToken()) || (t[0][2] == Token.FIRST.getGameToken())
								|| (t[1][1] == Token.FIRST.getGameToken()) || (t[2][1] == Token.FIRST.getGameToken())) {
							// если есть своя фигура на клетках линий
							p = 1;
						} else if ((t[0][0] == Token.SECOND.getGameToken()) || (t[0][2] == Token.SECOND.getGameToken())
								|| (t[1][1] == Token.SECOND.getGameToken()) || (t[2][1]) == Token.SECOND.getGameToken()) {
							// если есть фигура противника на клетках линий
							p = -1;
						}
					}

					// (1,1):
					// {(0,0),(2,2)}
					// {(0,2),(2,0)}
					// {(0,1),(2,1)}
					// {(1,0),(1,2)}
					//
					if ((i == 1) && (j == 1)) {
						if ((t[0][0] == Token.FIRST.getGameToken()) || (t[2][2] == Token.FIRST.getGameToken())
								|| (t[0][2] == Token.FIRST.getGameToken()) || (t[0][1] == Token.FIRST.getGameToken())
								|| (t[2][1] == Token.FIRST.getGameToken()) || (t[1][0] == Token.FIRST.getGameToken())
								|| (t[1][2] == Token.FIRST.getGameToken())) {
							// если есть своя фигура на клетках линий
							p = 1;
						} else if ((t[0][0] == Token.SECOND.getGameToken()) || (t[2][2] == Token.SECOND.getGameToken())
								|| (t[0][2] == Token.SECOND.getGameToken()) || (t[0][1] == Token.SECOND.getGameToken())
								|| (t[2][1] == Token.SECOND.getGameToken()) || (t[1][0] == Token.SECOND.getGameToken())
								|| (t[1][2] == Token.SECOND.getGameToken())) {
							// если есть фигура противника на клетках линий
							p = -1;
						}
					}

					// (2,1):
					// {(2,0),(2,2)}
					// {(0,1),(2,1)}
					//

					if ((i == 2) && (j == 1)) {
						if ((t[2][0] == Token.FIRST.getGameToken()) || (t[2][2] == Token.FIRST.getGameToken())
								|| (t[0][1] == Token.FIRST.getGameToken()) || (t[2][1] == Token.FIRST.getGameToken())) {
							// если есть своя фигура на клетках линий
							p = 1;
						} else if ((t[2][0] == Token.SECOND.getGameToken()) || (t[2][2] == Token.SECOND.getGameToken())
								|| (t[0][1] == Token.SECOND.getGameToken()) || (t[2][1]) == Token.SECOND.getGameToken()) {
							// если есть фигура противника на клетках линий
							p = -1;
						}
					}

					// (0,2):
					// {(0,0),(0,1)}
					// {(1,1),(2,0)}
					// {(1,2),(2,2)}
					//

					if ((i == 0) && (j == 2)) {
						if ((t[0][0] == Token.FIRST.getGameToken()) || (t[0][1] == Token.FIRST.getGameToken())
								|| (t[1][1] == Token.FIRST.getGameToken()) || (t[2][0] == Token.FIRST.getGameToken())
								|| (t[1][2] == Token.FIRST.getGameToken()) || (t[2][2] == Token.FIRST.getGameToken())) {
							// если есть своя фигура на клетках линий
							p = 1;
						} else if ((t[0][0] == Token.SECOND.getGameToken()) || (t[0][1] == Token.SECOND.getGameToken())
								|| (t[1][1] == Token.SECOND.getGameToken()) || (t[2][0] == Token.SECOND.getGameToken())
								|| (t[1][2] == Token.SECOND.getGameToken()) || (t[2][2] == Token.SECOND.getGameToken())) {
							// если есть фигура противника на клетках линий
							p = -1;
						}
					}

					// (1,2):
					// {(1,0),(1,1)}
					// {(0,2),(2,2)}
					//

					if ((i == 1) && (j == 2)) {
						if ((t[1][0] == Token.FIRST.getGameToken()) || (t[1][1] == Token.FIRST.getGameToken())
								|| (t[0][2] == Token.FIRST.getGameToken()) || (t[2][2] == Token.FIRST.getGameToken())) {
							// если есть своя фигура на клетках линий
							p = 1;
						} else if ((t[1][0] == Token.SECOND.getGameToken()) || (t[1][1] == Token.SECOND.getGameToken())
								|| (t[0][2] == Token.SECOND.getGameToken()) || (t[2][2]) == Token.SECOND.getGameToken()) {
							// если есть фигура противника на клетках линий
							p = -1;
						}
					}

					// (2,2):
					// {(0,0),(1,1)}
					// {(0,2),(1,2)}
					// {(2,0),(2,1)}
					//

					if ((i == 2) && (j == 2)) {
						if ((t[0][0] == Token.FIRST.getGameToken()) || (t[1][1] == Token.FIRST.getGameToken())
								|| (t[0][2] == Token.FIRST.getGameToken()) || (t[1][2] == Token.FIRST.getGameToken())
								|| (t[2][0] == Token.FIRST.getGameToken()) || (t[2][1] == Token.FIRST.getGameToken())) {
							// если есть своя фигура на клетках линий
							p = 1;
						} else if ((t[0][0] == Token.SECOND.getGameToken()) || (t[1][1] == Token.SECOND.getGameToken())
								|| (t[0][2] == Token.SECOND.getGameToken()) || (t[1][2] == Token.SECOND.getGameToken())
								|| (t[2][0] == Token.SECOND.getGameToken()) || (t[2][1] == Token.SECOND.getGameToken())) {
							// если есть фигура противника на клетках линий
							p = -1;
						}
					}
				}
			}
		}
		return p;
	}

}
