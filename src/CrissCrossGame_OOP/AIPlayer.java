package CrissCrossGame_OOP;

public class AIPlayer extends Player {
	
	public Token[][] currentGameFieldBox;
	
	@Override
	public int[] doMove(Board xoBoard) {
		int XY[] = new int[2];
		
		//перечитываем текущее состояние доски
		currentGameFieldBox = new Token[xoBoard.getBoardWidth()][xoBoard.getBoardWidth()];
		currentGameFieldBox = xoBoard.getGameFieldBox();
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				// по каждой пустой клетке проверяем
				if ((currentGameFieldBox[i][j].equals(Token.NO))) {

					//если вероятность выиграть
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