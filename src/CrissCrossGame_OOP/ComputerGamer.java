package CrissCrossGame_OOP;

public class ComputerGamer {
	
	public int[] doMove(Board board, String[] fishki) {
		int XY[] = new int[2];
		String[][] emptyGameFieldBox = new String [3][3];
		
		emptyGameFieldBox = board.getGameFieldBox();
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				//и�?ключа�? заполненные клетки
				if ((emptyGameFieldBox[i][j] != fishki[0]) && (emptyGameFieldBox[i][j] != fishki[1])) {
					
					//по каждой клетке провер�?ем, е�?ли веро�?тно�?ть выиграть равна 0 или 1,
					int q = AIWinStrategy.checkWinBoxToMove(board, i, j, fishki);
					
					if (q >= 0) {
						//то делаем ход в первую из клеток �? до�?таточным уровнем веро�?тно�?ти выиграть
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
