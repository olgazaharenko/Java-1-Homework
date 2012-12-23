package CrissCrossGame_OOP;

import org.junit.Assert;
import org.junit.Test;

public class TestCrissCrossGame {
	
	boolean lines = false;
	boolean win = false;
	int zeroBoxes = 9;
	Board xoBoard = new Board();
	
	@Test
	public void testCaseDraw() {
		
		Token[][] testBoard = new Token[3][3];
		testBoard[0][0] = Token.X;
		testBoard[0][1] = Token.O;
		testBoard[0][2] = Token.X;
		testBoard[1][0] = Token.X;
		testBoard[1][1] = Token.O;
		testBoard[1][2] = Token.O;
		testBoard[2][0] = Token.O;
		testBoard[2][1] = Token.X;
		testBoard[2][2] = Token.X;
		
		xoBoard.setGameFilledBox(testBoard);		
		zeroBoxes = xoBoard.getNumberOfEmptyBoxes();
		Assert.assertTrue(zeroBoxes == 0);
	}
	
	@Test
	public void testCaseNoDraw() {
		
		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.NO;
		testBoard[0][1] = Token.NO;
		testBoard[0][2] = Token.NO;
		testBoard[1][0] = Token.NO;
		testBoard[1][1] = Token.X;
		testBoard[1][2] = Token.NO;
		testBoard[2][0] = Token.NO;
		testBoard[2][1] = Token.NO;
		testBoard[2][2] = Token.NO;
		
		xoBoard.setGameFilledBox(testBoard);
		zeroBoxes = xoBoard.getNumberOfEmptyBoxes();
		Assert.assertFalse(zeroBoxes == 0);		
	}
	
	@Test
	public void testCaseNoDrawNoWin() {
		
		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.NO;
		testBoard[0][1] = Token.NO;
		testBoard[0][2] = Token.NO;
		testBoard[1][0] = Token.NO;
		testBoard[1][1] = Token.X;
		testBoard[1][2] = Token.NO;
		testBoard[2][0] = Token.O;
		testBoard[2][1] = Token.NO;
		testBoard[2][2] = Token.NO;
		
		xoBoard.setGameFilledBox(testBoard);
		zeroBoxes = xoBoard.getNumberOfEmptyBoxes();
		Assert.assertTrue(zeroBoxes == 7);		
	}


	@Test
	public void testCaseXVerticalLeftLineWin() {

		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.X;
		testBoard[0][1] = Token.X;
		testBoard[0][2] = Token.X;
		testBoard[1][0] = Token.O;
		testBoard[1][1] = Token.X;
		testBoard[1][2] = Token.O;
		testBoard[2][0] = Token.X;
		testBoard[2][1] = Token.O;
		testBoard[2][2] = Token.O;

		xoBoard.setGameFilledBox(testBoard);
		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines);
	}

	@Test
	public void testCaseOVerticalLeftLineWin() {
		
		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.O;
		testBoard[0][1] = Token.O;
		testBoard[0][2] = Token.O;
		testBoard[1][0] = Token.X;
		testBoard[1][1] = Token.O;
		testBoard[1][2] = Token.X;
		testBoard[2][0] = Token.O;
		testBoard[2][1] = Token.X;
		testBoard[2][2] = Token.X;

		xoBoard.setGameFilledBox(testBoard);
		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);

	}
	
	@Test
	public void testCaseOVerticalMediumLineWin() {
		
		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.X;
		testBoard[0][1] = Token.O;
		testBoard[0][2] = Token.X;
		testBoard[1][0] = Token.O;
		testBoard[1][1] = Token.O;
		testBoard[1][2] = Token.O;
		testBoard[2][0] = Token.O;
		testBoard[2][1] = Token.X;
		testBoard[2][2] = Token.X;
		
		xoBoard.setGameFilledBox(testBoard);
		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);

	}
	
	@Test
	public void testCaseOVerticalRightLineWin() {
		
		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.X;
		testBoard[0][1] = Token.O;
		testBoard[0][2] = Token.X;
		testBoard[1][0] = Token.O;
		testBoard[1][1] = Token.X;
		testBoard[1][2] = Token.X;
		testBoard[2][0] = Token.O;
		testBoard[2][1] = Token.O;
		testBoard[2][2] = Token.O;
		
		xoBoard.setGameFilledBox(testBoard);
		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);

	}
	
	@Test
	public void testCaseXVerticalRightLineWin() {
		
		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.O;
		testBoard[0][1] = Token.X;
		testBoard[0][2] = Token.O;
		testBoard[1][0] = Token.X;
		testBoard[1][1] = Token.O;
		testBoard[1][2] = Token.O;
		testBoard[2][0] = Token.X;
		testBoard[2][1] = Token.X;
		testBoard[2][2] = Token.X;
		
		xoBoard.setGameFilledBox(testBoard);
		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);

	}
	
	@Test
	public void testCaseXLeftDiagonalWin() {

		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.X;
		testBoard[0][1] = Token.O;
		testBoard[0][2] = Token.O;
		testBoard[1][0] = Token.O;
		testBoard[1][1] = Token.X;
		testBoard[1][2] = Token.X;
		testBoard[2][0] = Token.X;
		testBoard[2][1] = Token.O;
		testBoard[2][2] = Token.X;

		xoBoard.setGameFilledBox(testBoard);
		lines = xoBoard.getWinLines();
		
		Assert.assertTrue(lines == true);
	}
	
	@Test
	public void testCaseOLeftDiagonalWin() {

		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.O;
		testBoard[0][1] = Token.X;
		testBoard[0][2] = Token.X;
		testBoard[1][0] = Token.X;
		testBoard[1][1] = Token.O;
		testBoard[1][2] = Token.O;
		testBoard[2][0] = Token.O;
		testBoard[2][1] = Token.X;
		testBoard[2][2] = Token.O;

		xoBoard.setGameFilledBox(testBoard);
		lines = xoBoard.getWinLines();
		
		Assert.assertTrue(lines == true);
		
	}
	
	@Test
	public void testCaseOTopHorizontalWin() {

		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.O;
		testBoard[0][1] = Token.X;
		testBoard[0][2] = Token.X;
		testBoard[1][0] = Token.O;
		testBoard[1][1] = Token.O;
		testBoard[1][2] = Token.X;
		testBoard[2][0] = Token.O;
		testBoard[2][1] = Token.X;
		testBoard[2][2] = Token.O;

		xoBoard.setGameFilledBox(testBoard);
		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);
	}

	@Test
	public void testCaseOVilkaWin() {

		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.O;
		testBoard[0][1] = Token.X;
		testBoard[0][2] = Token.X;
		testBoard[1][0] = Token.O;
		testBoard[1][1] = Token.O;
		testBoard[1][2] = Token.X;
		testBoard[2][0] = Token.O;
		testBoard[2][1] = Token.X;
		testBoard[2][2] = Token.O;

		xoBoard.setGameFilledBox(testBoard);
		lines = xoBoard.getWinLines();
		
		Assert.assertTrue(lines == true);
	}
	
	@Test
	public void testCaseOBottomHorizontalWin() {

		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.X;
		testBoard[0][1] = Token.O;
		testBoard[0][2] = Token.O;
		testBoard[1][0] = Token.X;
		testBoard[1][1] = Token.X;
		testBoard[1][2] = Token.O;
		testBoard[2][0] = Token.O;
		testBoard[2][1] = Token.X;
		testBoard[2][2] = Token.O;
		
		xoBoard.setGameFilledBox(testBoard);
		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);
	}
	
	@Test
	public void testCaseXBottomHorizontalWin() {

		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.O;
		testBoard[0][1] = Token.X;
		testBoard[0][2] = Token.X;
		testBoard[1][0] = Token.O;
		testBoard[1][1] = Token.O;
		testBoard[1][2] = Token.X; 
		testBoard[2][0] = Token.X;
		testBoard[2][1] = Token.O;
		testBoard[2][2] = Token.X;

		xoBoard.setGameFilledBox(testBoard);
		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);
	}
	
	@Test
	public void testCaseXMediumHorizontalWin() {
		
		Token testBoard[][] = new Token[3][3];
		testBoard[0][0] = Token.O;
		testBoard[0][1] = Token.X;
		testBoard[0][2] = Token.X;
		testBoard[1][0] = Token.O;
		testBoard[1][1] = Token.X;
		testBoard[1][2] = Token.O;
		testBoard[2][0] = Token.X;
		testBoard[2][1] = Token.X;
		testBoard[2][2] = Token.O;

		xoBoard.setGameFilledBox(testBoard);
		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);
	}
}
