package CrissCrossGame;

import org.junit.Assert;
import org.junit.Test;

public class TestCrissCrossGame {
	
	boolean lines = false;
	boolean win = false;
	int zeroBoxes = 9;
	Board xoBoard = new Board();

	@Test
	@SuppressWarnings("deprecation")
	public void testDrawField() {
		
		String fishki[] = new String[2];
		fishki[0] = "X";
		fishki[1] = "O";

		String expectedBoard[][] = new String[3][3];
		expectedBoard[0][0] = "_";
		expectedBoard[0][1] = "X";
		expectedBoard[0][2] = "_";
		expectedBoard[1][0] = "_";
		expectedBoard[1][1] = "_";
		expectedBoard[1][2] = "_";
		expectedBoard[2][0] = "_";
		expectedBoard[2][1] = "_";
		expectedBoard[2][2] = "_";
		
		int xy[] = new int[2];
		xy[0] = 0;
		xy[1] = 1;
		
		String actualBoard[][] = new String[3][3];
		actualBoard = xoBoard.drawField(xy, fishki, 0);
		
		Assert.assertEquals(actualBoard, expectedBoard);
	}
	
	@Test
	public void testCaseDraw() {
		
		String testBoard[][] = new String[3][3];
		testBoard[0][0] = "X";
		testBoard[0][1] = "O";
		testBoard[0][2] = "X";
		testBoard[1][0] = "X";
		testBoard[1][1] = "O";
		testBoard[1][2] = "O";
		testBoard[2][0] = "O";
		testBoard[2][1] = "X";
		testBoard[2][2] = "X";
		
		xoBoard.setFinalGameBox(testBoard);
		zeroBoxes = xoBoard.getEmptyBoxesInTheField();
		Assert.assertTrue(zeroBoxes == 0);
	}
	
	@Test
	public void testCaseNoDraw() {
		
		String testBoard[][] = new String[3][3];
		testBoard[0][0] = "_";
		testBoard[0][1] = "_";
		testBoard[0][2] = "_";
		testBoard[1][0] = "_";
		testBoard[1][1] = "X";
		testBoard[1][2] = "_";
		testBoard[2][0] = "_";
		testBoard[2][1] = "_";
		testBoard[2][2] = "_";
		
		xoBoard.setFinalGameBox(testBoard);
		zeroBoxes = xoBoard.getEmptyBoxesInTheField();
		Assert.assertFalse(zeroBoxes == 0);		
	}
	
	@Test
	public void testCaseNoDrawNoWin() {
		
		String testBoard[][] = new String[3][3];
		testBoard[0][0] = "_";
		testBoard[0][1] = "_";
		testBoard[0][2] = "_";
		testBoard[1][0] = "_";
		testBoard[1][1] = "X";
		testBoard[1][2] = "_";
		testBoard[2][0] = "O";
		testBoard[2][1] = "_";
		testBoard[2][2] = "_";
		
		xoBoard.setFinalGameBox(testBoard);
		zeroBoxes = xoBoard.getEmptyBoxesInTheField();
		Assert.assertTrue(zeroBoxes == 7);		
	}


	@Test
	public void testCaseXVerticalWin() {

		String testBoard[][] = new String[3][3];
		testBoard[0][0] = "X";
		testBoard[0][1] = "X";
		testBoard[0][2] = "X";
		testBoard[1][0] = "O";
		testBoard[1][1] = "O";
		testBoard[1][2] = "O"; 
		testBoard[2][0] = "X";
		testBoard[2][1] = "O";
		testBoard[2][2] = "X";

		String Fishka = "X";
		xoBoard.setFinalGameBox(testBoard);
		lines = xoBoard.getWinLines(Fishka);

		Assert.assertTrue(lines == true);
	}

	@Test
	public void testCaseOVerticalWin() {
		
		String testBoard[][] = new String[3][3];
		testBoard[0][0] = "O";
		testBoard[0][1] = "O";
		testBoard[0][2] = "O";
		testBoard[1][0] = "X";
		testBoard[1][1] = "X";
		testBoard[1][2] = "X"; 
		testBoard[2][0] = "O";
		testBoard[2][1] = "X";
		testBoard[2][2] = "O";

		String Fishka = "O";
		xoBoard.setFinalGameBox(testBoard);
		lines = xoBoard.getWinLines(Fishka);

		Assert.assertTrue(lines == true);

	}
	
	@Test
	public void testCaseXLeftDiagonalWin() {

		String testBoard[][] = new String[3][3];
		testBoard[0][0] = "X";
		testBoard[0][1] = "O";
		testBoard[0][2] = "O";
		testBoard[1][0] = "O";
		testBoard[1][1] = "X";
		testBoard[1][2] = "X"; 
		testBoard[2][0] = "X";
		testBoard[2][1] = "O";
		testBoard[2][2] = "X";

		String Fishka = "X";
		xoBoard.setFinalGameBox(testBoard);
		lines = xoBoard.getWinLines(Fishka);
		
		Assert.assertTrue(lines == true);
	}
	
	@Test
	public void testCaseOLeftDiagonalWin() {

		String testBoard[][] = new String[3][3];
		testBoard[0][0] = "O";
		testBoard[0][1] = "X";
		testBoard[0][2] = "X";
		testBoard[1][0] = "X";
		testBoard[1][1] = "O";
		testBoard[1][2] = "O"; 
		testBoard[2][0] = "O";
		testBoard[2][1] = "X";
		testBoard[2][2] = "O";

		String Fishka = "O";
		xoBoard.setFinalGameBox(testBoard);
		lines = xoBoard.getWinLines(Fishka);
		
		Assert.assertTrue(lines == true);
		
	}
	
	@Test
	public void testCaseOHorizontalWin() {

		String testBoard[][] = new String[3][3];
		testBoard[0][0] = "O";
		testBoard[0][1] = "X";
		testBoard[0][2] = "X";
		testBoard[1][0] = "O";
		testBoard[1][1] = "O";
		testBoard[1][2] = "X"; 
		testBoard[2][0] = "O";
		testBoard[2][1] = "X";
		testBoard[2][2] = "O";

		String Fishka = "O";
		xoBoard.setFinalGameBox(testBoard);
		lines = xoBoard.getWinLines(Fishka);

		Assert.assertTrue(lines == true);
	}

	@Test
	public void testCaseXHorizontalWin() {
		
		String testBoard[][] = new String[3][3];
		testBoard[0][0] = "O";
		testBoard[0][1] = "X";
		testBoard[0][2] = "X";
		testBoard[1][0] = "O";
		testBoard[1][1] = "X";
		testBoard[1][2] = "O"; 
		testBoard[2][0] = "X";
		testBoard[2][1] = "X";
		testBoard[2][2] = "O";

		String Fishka = "X";
		xoBoard.setFinalGameBox(testBoard);
		lines = xoBoard.getWinLines(Fishka);

		Assert.assertTrue(lines == true);

	}
	
	@Test
	public void testCheckWinLine() {
		String testBoard1[][] = new String[3][3];
		testBoard1[0][0] = "O";
		testBoard1[0][1] = "X";
		testBoard1[0][2] = "X";
		testBoard1[1][0] = "O";
		testBoard1[1][1] = "X";
		testBoard1[1][2] = "O"; 
		testBoard1[2][0] = "X";
		testBoard1[2][1] = "X";
		testBoard1[2][2] = "O";
		
		String testBoard2[][] = new String[3][3];
		testBoard2[0][0] = "O";
		testBoard2[0][1] = "X";
		testBoard2[0][2] = "X";
		testBoard2[1][0] = "O";
		testBoard2[1][1] = "X";
		testBoard2[1][2] = "O"; 
		testBoard2[2][0] = "X";
		testBoard2[2][1] = "X";
		testBoard2[2][2] = "O";
		
		lines = xoBoard.checkWinLine(testBoard1, testBoard2);
		Assert.assertTrue(lines == true);
		
	}

}
