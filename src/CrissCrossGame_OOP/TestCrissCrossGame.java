package CrissCrossGame_OOP;

import org.junit.Assert;
import org.junit.Test;

public class TestCrissCrossGame {
	
	boolean lines = false;
	boolean win = false;
	int zeroBoxes = 9;
	Board xoBoard = new Board();
	Token[][] testBoard = new Token[3][3];
	
	@Test
	public void testCaseDraw() {
		
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
	public void testCaseNoDrawNoWinZeroBoxes7() {
		
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
	public void testCaseNoDrawNoWinNoLines() {

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
		lines = xoBoard.getWinLines();
		Assert.assertFalse(lines);
	}
	
	
	@Test
	public void testCaseXVerticalLeftLineWin() {

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

		Assert.assertTrue(lines);

	}
	
	@Test
	public void testCaseOVerticalMediumLineWin() {
		
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

		Assert.assertTrue(lines);

	}
	
	@Test
	public void testCaseOVerticalRightLineWin() {
		
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

		Assert.assertTrue(lines);

	}
	
	@Test
	public void testCaseXVerticalRightLineWin() {
		
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

		Assert.assertTrue(lines);

	}
	
	@Test
	public void testCaseXLeftDiagonalWin() {

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
		
		Assert.assertTrue(lines);
	}
	
	@Test
	public void testCaseOLeftDiagonalWin() {

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
		
		Assert.assertTrue(lines);
		
	}
	
	@Test
	public void testCaseOTopHorizontalWin() {

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

		Assert.assertTrue(lines);
	}

	@Test
	public void testCaseOVilkaWin() {

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
		
		Assert.assertTrue(lines);
	}
	
	@Test
	public void testCaseOBottomHorizontalWin() {

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

		Assert.assertTrue(lines);
	}
	
	@Test
	public void testCaseXBottomHorizontalWin() {

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

		Assert.assertTrue(lines);
	}
	
	@Test
	public void testCaseXMediumHorizontalWin() {
		
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

		Assert.assertTrue(lines);
	}
}
