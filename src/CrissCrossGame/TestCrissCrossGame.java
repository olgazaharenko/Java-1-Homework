package CrissCrossGame;

import org.junit.Assert;
import org.junit.Test;

public class TestCrissCrossGame {
	
	boolean lines = false;
	int zeroBoxes = 9;
	Board xoBoard = new Board();

	@Test
	@SuppressWarnings("deprecation")
	public void testDrawField() {
		
		char fishki[] = new char[2];
		fishki[0] = 'X';
		fishki[1] = 'O';

		char expectedBoard[][] = new char[3][3];
		expectedBoard[0][0] = '_';
		expectedBoard[0][1] = 'X';
		expectedBoard[0][2] = '_';
		expectedBoard[1][0] = '_';
		expectedBoard[1][1] = '_';
		expectedBoard[1][2] = '_';
		expectedBoard[2][0] = '_';
		expectedBoard[2][1] = '_';
		expectedBoard[2][2] = '_';
		
		int XY[] = new int[2];
		XY[0] = 0;
		XY[1] = 1;
		
		char actualBoard[][] = new char[3][3];
		actualBoard = xoBoard.drawField(XY, fishki, 0);
		
		Assert.assertEquals(actualBoard, expectedBoard);
	}
	
	
	@Test
	public void testTwoHumansPlayCaseDraw() {
		
		char testBoard[][] = new char[3][3];
		testBoard[0][0] = 'X';
		testBoard[0][1] = 'O';
		testBoard[0][2] = 'X';
		testBoard[1][0] = 'X';
		testBoard[1][1] = 'O';
		testBoard[1][2] = 'O';
		testBoard[2][0] = 'O';
		testBoard[2][1] = 'X';
		testBoard[2][2] = 'X';
		
		zeroBoxes = xoBoard.returnEmptyBoxesInTheField();
		Assert.assertTrue(zeroBoxes == 0);
		
	}

	@Test
	public void testTwoHumansPlayCaseXVerticalWin() {

		char testBoard[][] = new char[3][3];
		testBoard[0][0] = 'X';
		testBoard[0][1] = 'X';
		testBoard[0][2] = 'X';
		testBoard[1][0] = 'O';
		testBoard[1][1] = 'O';
		testBoard[1][2] = 'O'; 
		testBoard[2][0] = 'X';
		testBoard[2][1] = 'O';
		testBoard[2][2] = 'X';

		char Fishka = 'X';
		xoBoard.setFinalGameBox(testBoard);
		lines = xoBoard.returnLines(Fishka);

		Assert.assertTrue(lines == true);
	}

	@Test
	public void testTwoHumansPlayCaseOVerticalWin() {
		
		char testBoard[][] = new char[3][3];
		testBoard[0][0] = 'O';
		testBoard[0][1] = 'O';
		testBoard[0][2] = 'O';
		testBoard[1][0] = 'X';
		testBoard[1][1] = 'X';
		testBoard[1][2] = 'X'; 
		testBoard[2][0] = 'O';
		testBoard[2][1] = 'X';
		testBoard[2][2] = 'O';

		char Fishka = 'O';
		xoBoard.setFinalGameBox(testBoard);
		lines = xoBoard.returnLines(Fishka);

		Assert.assertTrue(lines == true);

	}
	
	@Test
	public void testTwoHumansPlayCaseXLeftDiagonalWin() {

		char testBoard[][] = new char[3][3];
		testBoard[0][0] = 'X';
		testBoard[0][1] = 'O';
		testBoard[0][2] = 'O';
		testBoard[1][0] = 'O';
		testBoard[1][1] = 'X';
		testBoard[1][2] = 'X'; 
		testBoard[2][0] = 'X';
		testBoard[2][1] = 'O';
		testBoard[2][2] = 'X';

		char Fishka = 'X';
		xoBoard.setFinalGameBox(testBoard);
		lines = xoBoard.returnLines(Fishka);
		
		Assert.assertTrue(lines == true);
	}
	
	@Test
	public void testTwoHumansPlayCaseOLeftDiagonalWin() {

		char testBoard[][] = new char[3][3];
		testBoard[0][0] = 'O';
		testBoard[0][1] = 'X';
		testBoard[0][2] = 'X';
		testBoard[1][0] = 'X';
		testBoard[1][1] = 'O';
		testBoard[1][2] = 'O'; 
		testBoard[2][0] = 'O';
		testBoard[2][1] = 'X';
		testBoard[2][2] = 'O';

		char Fishka = 'O';
		xoBoard.setFinalGameBox(testBoard);
		lines = xoBoard.returnLines(Fishka);
		
		Assert.assertTrue(lines == true);
		
	}
	
	@Test
	public void testTwoHumansPlayCaseOHorizontalWin() {

		char testBoard[][] = new char[3][3];
		testBoard[0][0] = 'O';
		testBoard[0][1] = 'X';
		testBoard[0][2] = 'X';
		testBoard[1][0] = 'O';
		testBoard[1][1] = 'O';
		testBoard[1][2] = 'X'; 
		testBoard[2][0] = 'O';
		testBoard[2][1] = 'X';
		testBoard[2][2] = 'O';

		char Fishka = 'O';
		xoBoard.setFinalGameBox(testBoard);
		lines = xoBoard.returnLines(Fishka);

		Assert.assertTrue(lines == true);
	}

	@Test
	public void testTwoHumansPlayCaseXHorizontalWin() {
		
		char testBoard[][] = new char[3][3];
		testBoard[0][0] = 'O';
		testBoard[0][1] = 'X';
		testBoard[0][2] = 'X';
		testBoard[1][0] = 'O';
		testBoard[1][1] = 'X';
		testBoard[1][2] = 'O'; 
		testBoard[2][0] = 'X';
		testBoard[2][1] = 'X';
		testBoard[2][2] = 'O';

		char Fishka = 'X';
		xoBoard.setFinalGameBox(testBoard);
		lines = xoBoard.returnLines(Fishka);

		Assert.assertTrue(lines == true);

	}

}
