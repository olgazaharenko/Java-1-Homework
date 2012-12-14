package CrissCrossGame_OOP;

public class AIPlayer extends Player {

	@Override
	public int[] doMove(Board xoBoard, Team xoTeam) {
		int XY[] = new int[2];
		String[][] emptyGameFieldBox = new String[3][3];

		emptyGameFieldBox = xoBoard.getGameFieldBox();
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				// исключая заполненные клетки
				if ((emptyGameFieldBox[i][j] != Token.FIRST.getGameToken())
						&& (emptyGameFieldBox[i][j] != Token.SECOND.getGameToken())) {

					// по каждой клетке проверяем, если вероятность выиграть
					// равна 0 или 1,
					int q = AIWinStrategy.checkWinBoxToMove(xoBoard, i, j);

					if (q >= 0) {
						// то делаем ход в первую из клеток с достаточным
						// уровнем вероятности выиграть
						XY[0] = i;
						XY[1] = j;
						break;
					}
				}
			}
		}
		return XY;
	}
}