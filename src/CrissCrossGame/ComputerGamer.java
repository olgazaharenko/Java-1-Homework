package CrissCrossGame;

public class ComputerGamer {
	
	public int[] doMove(Board board, char Fishki[]) {
		int XY[] = new int[2];
		char emptyGameFieldBox[][] = new char [3][3];
		
		emptyGameFieldBox = board.returnGameFieldBox();
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				//исключая заполненные клетки
				if ((emptyGameFieldBox[i][j] != Fishki[0]) && (emptyGameFieldBox[i][j] != Fishki[1])) {
					
					//по каждой клетке проверяем, если вероятность выиграть равна 0 или 1,
					
					int q = AIWinStrategy.checkWinBoxToMove(board, i, j, Fishki);
					
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
}
