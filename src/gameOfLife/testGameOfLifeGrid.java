 package gameOfLife;

import junit.framework.Assert;

import org.junit.Test;

public class testGameOfLifeGrid {
	
	@Test
	public void testGameField() {
		gameOfLifeGrid myGrid = new gameOfLifeGrid();
		Assert.assertEquals(3, myGrid.getGameGrid().length);
	}
	
	@Test
	public void testFigureLive1() {
		
		gameOfLifeGrid myGrid = new gameOfLifeGrid();
		int matrixNeo[][] = new int[3][3];
		
		//для теста все клетки сначала живые 
		for (int i = 0; i < myGrid.getGameGrid().length; i++) {
			for (int j = 0; j < myGrid.getGameGrid().length; j++) {
				matrixNeo[i][j] = 1; 
			}
		}

		int x = 1;
		int y = 1;
		matrixNeo[0][0] = 1;
		matrixNeo[0][1] = 1;
		matrixNeo[0][2] = 0;
		matrixNeo[1][0] = 0;
		matrixNeo[2][0] = 0;
		matrixNeo[2][1] = 0;
		matrixNeo[1][2] = 0;
		matrixNeo[2][2] = 0;
		
		Assert.assertEquals(2, myGrid.boxDieIfLess2(x, y, matrixNeo));
	}
	
	@Test
	public void testFigureLive2() {
		
		gameOfLifeGrid myGrid = new gameOfLifeGrid();
		int matrixNeo[][] = new int[3][3];
		
		//для теста все клетки сначала живые 
		for (int i = 0; i < myGrid.getGameGrid().length; i++) {
			for (int j = 0; j < myGrid.getGameGrid().length; j++) {
				matrixNeo[i][j] = 1; 
			}
		}

		int x = 1;
		int y = 1;
		matrixNeo[0][0] = 1;
		matrixNeo[0][1] = 1;
		matrixNeo[0][2] = 1;
		matrixNeo[1][0] = 1;
		matrixNeo[2][0] = 0;
		matrixNeo[2][1] = 0;
		matrixNeo[1][2] = 0;
		matrixNeo[2][2] = 0;
		
		Assert.assertEquals(4, myGrid.boxDieIfMore3(x, y, matrixNeo));
	}
	
	
	
	@Test
	public void testFigureDie() {
		gameOfLifeGrid myGrid = new gameOfLifeGrid();
		myGrid.setGameGrid();
		Assert.assertTrue(myGrid.boxDie(0, 0));
	}
	
	@Test
	public void testFigureBorn() {
		gameOfLifeGrid myGrid = new gameOfLifeGrid();
		myGrid.setGameGrid();
		Assert.assertTrue(myGrid.boxBorn(1, 1));
	}


}
