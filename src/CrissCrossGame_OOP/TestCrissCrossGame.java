package CrissCrossGame_OOP;

import org.junit.Assert;
import org.junit.Test;

public class TestCrissCrossGame {
	
	boolean lines = false;
	boolean win = false;
	int zeroBoxes = 9;
	Board xoBoard = new Board();

	/*
	@Test
	@SuppressWarnings("deprecation")
	public void testDrawField() {
		
		String expectedBoard[][] = new String[3][3];
		expectedBoard[0][0] = Token.EMPTY.setGameToken();
		expectedBoard[0][1] = Token.FIRST.setGameToken();
		expectedBoard[0][2] = Token.EMPTY.setGameToken();
		expectedBoard[1][0] = Token.EMPTY.setGameToken();
		expectedBoard[1][1] = Token.EMPTY.setGameToken();
		expectedBoard[1][2] = Token.EMPTY.setGameToken();
		expectedBoard[2][0] = Token.EMPTY.setGameToken();
		expectedBoard[2][1] = Token.EMPTY.setGameToken();
		expectedBoard[2][2] = Token.EMPTY.setGameToken();
		
		int xy[] = new int[2];
		xy[0] = 0;
		xy[1] = 1;
		
		Team testTeam = new Team();
		testTeam.gamers = 2;
		
		testTeam.listOfGamersNames.add("Test AIPlayer 1");
		testTeam.listOfGamersNames.add("Test AIPlayer 2");
		
		testTeam.listOfPlayersFigures.add(Token.FIRST.toString());
		testTeam.listOfPlayersFigures.add(Token.SECOND.toString());
		
		String[][] actualBoard = new String[3][3];
		actualBoard = xoBoard.drawField(testTeam,0);
		
		Assert.assertEquals(actualBoard, expectedBoard);
	}*/
	
	@Test
	public void testCaseDraw() {
		
		String[][] testBoard = new String[3][3];
		testBoard[0][0] = Token.FIRST.getGameToken();
		testBoard[0][1] = Token.SECOND.getGameToken();
		testBoard[0][2] = Token.FIRST.getGameToken();
		testBoard[1][0] = Token.FIRST.getGameToken();
		testBoard[1][1] = Token.SECOND.getGameToken();
		testBoard[1][2] = Token.SECOND.getGameToken();
		testBoard[2][0] = Token.SECOND.getGameToken();
		testBoard[2][1] = Token.FIRST.getGameToken();
		testBoard[2][2] = Token.FIRST.getGameToken();
		
		zeroBoxes = xoBoard.getNumberOfEmptyBoxes();
		Assert.assertTrue(zeroBoxes == 0);
	}
	
	@Test
	public void testCaseNoDraw() {
		
		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.EMPTY.getGameToken();;
		testBoard[0][1] = Token.EMPTY.getGameToken();;
		testBoard[0][2] = Token.EMPTY.getGameToken();;
		testBoard[1][0] = Token.EMPTY.getGameToken();;
		testBoard[1][1] = Token.FIRST.getGameToken();;
		testBoard[1][2] = Token.EMPTY.getGameToken();;
		testBoard[2][0] = Token.EMPTY.getGameToken();;
		testBoard[2][1] = Token.EMPTY.getGameToken();;
		testBoard[2][2] = Token.EMPTY.getGameToken();;
		
		zeroBoxes = xoBoard.getNumberOfEmptyBoxes();
		Assert.assertFalse(zeroBoxes == 0);		
	}
	
	@Test
	public void testCaseNoDrawNoWin() {
		
		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.EMPTY.getGameToken();
		testBoard[0][1] = Token.EMPTY.getGameToken();
		testBoard[0][2] = Token.EMPTY.getGameToken();
		testBoard[1][0] = Token.EMPTY.getGameToken();
		testBoard[1][1] = Token.FIRST.getGameToken();
		testBoard[1][2] = Token.EMPTY.getGameToken();
		testBoard[2][0] = Token.SECOND.getGameToken();
		testBoard[2][1] = Token.EMPTY.getGameToken();
		testBoard[2][2] = Token.EMPTY.getGameToken();
		
		zeroBoxes = xoBoard.getNumberOfEmptyBoxes();
		Assert.assertTrue(zeroBoxes == 7);		
	}


	@Test
	public void testCaseXVerticalLeftLineWin() {

		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.FIRST.getGameToken();
		testBoard[0][1] = Token.FIRST.getGameToken();
		testBoard[0][2] = Token.FIRST.getGameToken();
		testBoard[1][0] = Token.SECOND.getGameToken();
		testBoard[1][1] = Token.FIRST.getGameToken();
		testBoard[1][2] = Token.SECOND.getGameToken();
		testBoard[2][0] = Token.FIRST.getGameToken();
		testBoard[2][1] = Token.SECOND.getGameToken();
		testBoard[2][2] = Token.SECOND.getGameToken();

		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);
	}

	@Test
	public void testCaseOVerticalLeftLineWin() {
		
		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.SECOND.getGameToken();
		testBoard[0][1] = Token.SECOND.getGameToken();
		testBoard[0][2] = Token.SECOND.getGameToken();
		testBoard[1][0] = Token.FIRST.getGameToken();
		testBoard[1][1] = Token.SECOND.getGameToken();
		testBoard[1][2] = Token.FIRST.getGameToken();
		testBoard[2][0] = Token.SECOND.getGameToken();
		testBoard[2][1] = Token.FIRST.getGameToken();
		testBoard[2][2] = Token.FIRST.getGameToken();

		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);

	}
	
	@Test
	public void testCaseOVerticalMediumLineWin() {
		
		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.FIRST.getGameToken();
		testBoard[0][1] = Token.SECOND.getGameToken();
		testBoard[0][2] = Token.FIRST.getGameToken();
		testBoard[1][0] = Token.SECOND.getGameToken();
		testBoard[1][1] = Token.SECOND.getGameToken();
		testBoard[1][2] = Token.SECOND.getGameToken();
		testBoard[2][0] = Token.SECOND.getGameToken();
		testBoard[2][1] = Token.FIRST.getGameToken();
		testBoard[2][2] = Token.FIRST.getGameToken();

		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);

	}
	
	@Test
	public void testCaseOVerticalRightLineWin() {
		
		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.FIRST.getGameToken();
		testBoard[0][1] = Token.SECOND.getGameToken();
		testBoard[0][2] = Token.FIRST.getGameToken();
		testBoard[1][0] = Token.SECOND.getGameToken();
		testBoard[1][1] = Token.FIRST.getGameToken();
		testBoard[1][2] = Token.FIRST.getGameToken();
		testBoard[2][0] = Token.SECOND.getGameToken();
		testBoard[2][1] = Token.SECOND.getGameToken();
		testBoard[2][2] = Token.SECOND.getGameToken();

		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);

	}
	
	@Test
	public void testCaseXVerticalRightLineWin() {
		
		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.SECOND.getGameToken();
		testBoard[0][1] = Token.FIRST.getGameToken();
		testBoard[0][2] = Token.SECOND.getGameToken();
		testBoard[1][0] = Token.FIRST.getGameToken();
		testBoard[1][1] = Token.SECOND.getGameToken();
		testBoard[1][2] = Token.SECOND.getGameToken();
		testBoard[2][0] = Token.FIRST.getGameToken();
		testBoard[2][1] = Token.FIRST.getGameToken();
		testBoard[2][2] = Token.FIRST.getGameToken();

		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);

	}
	
	@Test
	public void testCaseXLeftDiagonalWin() {

		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.FIRST.getGameToken();
		testBoard[0][1] = Token.SECOND.getGameToken();
		testBoard[0][2] = Token.SECOND.getGameToken();
		testBoard[1][0] = Token.SECOND.getGameToken();
		testBoard[1][1] = Token.FIRST.getGameToken();
		testBoard[1][2] = Token.FIRST.getGameToken();
		testBoard[2][0] = Token.FIRST.getGameToken();
		testBoard[2][1] = Token.SECOND.getGameToken();
		testBoard[2][2] = Token.FIRST.getGameToken();

		lines = xoBoard.getWinLines();
		
		Assert.assertTrue(lines == true);
	}
	
	@Test
	public void testCaseOLeftDiagonalWin() {

		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.SECOND.getGameToken();
		testBoard[0][1] = Token.FIRST.getGameToken();
		testBoard[0][2] = Token.FIRST.getGameToken();
		testBoard[1][0] = Token.FIRST.getGameToken();
		testBoard[1][1] = Token.SECOND.getGameToken();
		testBoard[1][2] = Token.SECOND.getGameToken();
		testBoard[2][0] = Token.SECOND.getGameToken();
		testBoard[2][1] = Token.FIRST.getGameToken();
		testBoard[2][2] = Token.SECOND.getGameToken();

		lines = xoBoard.getWinLines();
		
		Assert.assertTrue(lines == true);
		
	}
	
	@Test
	public void testCaseOTopHorizontalWin() {

		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.SECOND.getGameToken();
		testBoard[0][1] = Token.FIRST.getGameToken();
		testBoard[0][2] = Token.FIRST.getGameToken();
		testBoard[1][0] = Token.SECOND.getGameToken();
		testBoard[1][1] = Token.SECOND.getGameToken();
		testBoard[1][2] = Token.FIRST.getGameToken();
		testBoard[2][0] = Token.SECOND.getGameToken();
		testBoard[2][1] = Token.FIRST.getGameToken();
		testBoard[2][2] = Token.SECOND.getGameToken();

		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);
	}

	@Test
	public void testCaseOVilkaWin() {

		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.SECOND.getGameToken();
		testBoard[0][1] = Token.FIRST.getGameToken();
		testBoard[0][2] = Token.FIRST.getGameToken();
		testBoard[1][0] = Token.SECOND.getGameToken();
		testBoard[1][1] = Token.SECOND.getGameToken();
		testBoard[1][2] = Token.FIRST.getGameToken();
		testBoard[2][0] = Token.SECOND.getGameToken();
		testBoard[2][1] = Token.FIRST.getGameToken();
		testBoard[2][2] = Token.SECOND.getGameToken();

		lines = xoBoard.getWinLines();
		
		Assert.assertTrue(lines == true);
	}
	
	@Test
	public void testCaseOBottomHorizontalWin() {

		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.FIRST.getGameToken();
		testBoard[0][1] = Token.SECOND.getGameToken();
		testBoard[0][2] = Token.SECOND.getGameToken();
		testBoard[1][0] = Token.FIRST.getGameToken();
		testBoard[1][1] = Token.FIRST.getGameToken();
		testBoard[1][2] = Token.SECOND.getGameToken();
		testBoard[2][0] = Token.SECOND.getGameToken();
		testBoard[2][1] = Token.FIRST.getGameToken();
		testBoard[2][2] = Token.SECOND.getGameToken();

		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);
	}
	
	@Test
	public void testCaseXBottomHorizontalWin() {

		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.SECOND.getGameToken();
		testBoard[0][1] = Token.FIRST.getGameToken();
		testBoard[0][2] = Token.FIRST.getGameToken();
		testBoard[1][0] = Token.SECOND.getGameToken();
		testBoard[1][1] = Token.SECOND.getGameToken();
		testBoard[1][2] = Token.FIRST.getGameToken(); 
		testBoard[2][0] = Token.FIRST.getGameToken();
		testBoard[2][1] = Token.SECOND.getGameToken();
		testBoard[2][2] = Token.FIRST.getGameToken();

		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);
	}
	
	@Test
	public void testCaseXMediumHorizontalWin() {
		
		String testBoard[][] = new String[3][3];
		testBoard[0][0] = Token.SECOND.getGameToken();
		testBoard[0][1] = Token.FIRST.getGameToken();
		testBoard[0][2] = Token.FIRST.getGameToken();
		testBoard[1][0] = Token.SECOND.getGameToken();
		testBoard[1][1] = Token.FIRST.getGameToken();
		testBoard[1][2] = Token.SECOND.getGameToken();
		testBoard[2][0] = Token.FIRST.getGameToken();
		testBoard[2][1] = Token.FIRST.getGameToken();
		testBoard[2][2] = Token.SECOND.getGameToken();

		lines = xoBoard.getWinLines();

		Assert.assertTrue(lines == true);

	}

}
