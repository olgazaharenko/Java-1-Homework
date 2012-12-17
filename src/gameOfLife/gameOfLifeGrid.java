package gameOfLife;

public class gameOfLifeGrid {

	private char gameGrid[][] = new char[3][3];
	
	public int boxDieIfLess2(int x, int y, int matrixNeo[][]) {
		
		//если у живой клетки x,y < 2 соседей, она умирает
		int k = 0; //счетчик соседей
		if (matrixNeo[x-1][y-1] == 1) {k = k + 1;}
		if (matrixNeo[x][y-1] == 1) {k = k + 1;}
		if (matrixNeo[x+1][y-1] == 1) {k = k + 1;}
		if (matrixNeo[x-1][y] == 1) {k = k + 1;}
		if (matrixNeo[x+1][y] == 1) {k = k + 1;}
		if (matrixNeo[x-1][y+1] == 1) {k = k + 1;}
		if (matrixNeo[x][y+1] == 1) {k = k + 1;}
		if (matrixNeo[x+1][y+1] == 1) {k = k + 1;}
				
		//if (k < 2) {matrixNeo[x][y] = 0;}
		
		return k;
	}
	
	public int boxDieIfMore3(int x, int y, int matrixNeo[][]) {
		
		//если у живой клетки x,y > 3 соседей, она умирает
		int k = 0; //счетчик соседей
		if (matrixNeo[x-1][y-1] == 1) {k = k + 1;}
		if (matrixNeo[x][y-1] == 1) {k = k + 1;}
		if (matrixNeo[x+1][y-1] == 1) {k = k + 1;}
		if (matrixNeo[x-1][y] == 1) {k = k + 1;}
		if (matrixNeo[x+1][y] == 1) {k = k + 1;}
		if (matrixNeo[x-1][y+1] == 1) {k = k + 1;}
		if (matrixNeo[x][y+1] == 1) {k = k + 1;}
		if (matrixNeo[x+1][y+1] == 1) {k = k + 1;}
				
		//if (k > 3) {matrixNeo[x][y] = 0;}
		
		return k;
	}
	
	//если у живой клетки x,y >= 2,3 соседей, она остается живой 
	//если у мертвой клетки x,y = 3 соседей, она оживает
	
	public boolean boxDie(int x, int y) {
		boolean die = false;
		if (gameGrid[x][y] == '*') {
			die = true;
		}
		return die;
	}

	public boolean boxBorn(int x, int y) {
		boolean born = false;
		if (gameGrid[x][y] == '_') {
			born = true;
		}
		return born;
	}

	public char[][] getGameGrid() {
		return gameGrid;
	}

	public void setGameGrid() {
		for (int i = 0; i < gameGrid.length; i++) {
			for (int j = 0; j < gameGrid.length; j++) {
				gameGrid[i][j] = '_';
			}
		}
		gameGrid[0][0] = '*';
	}
}
