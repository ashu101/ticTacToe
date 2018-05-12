package org.ab.ticTacToe.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.ab.ticTacToe.board.cell.Cell;
import org.junit.Test;

public class ValidationUtilsTest {
	@Test
	public void testNoEmptyPositions() {
		assertTrue(ValidationUtils.emptyPositions( new char[][]{{'1','2','3'},{'1','2','3'},{'1','2','3'}}).size() == 0 );
	}
	
	@Test
	public void testEmptyPositions() {
		assertTrue(ValidationUtils.emptyPositions( new char[][]{{'1','2','3'},{'1','2','\0'},{'1','2','3'}}).size() > 0 );
	}
	
	@Test
	public void testCheckDiagonal1Won(){
		assertTrue(ValidationUtils.checkDiagonal1Won('O', new char[][]{{'O','X','Y'},{'X','O','\0'},{'X','X','O'}}));
	}
	
	@Test
	public void testCheckDiagonal1Lost(){
		assertFalse(ValidationUtils.checkDiagonal1Won('O', new char[][]{{'O','X','Y'},{'X','O','\0'},{'X','X','Y'}}));
	}
	
	@Test
	public void testCheckDiagonal2Won(){
		assertTrue(ValidationUtils.checkDiagonal2Won('O', new char[][]{{'O','X','O'},{'X','O','\0'},{'O','X','X'}}));
	}
	
	@Test
	public void testCheckDiagonal2Lost(){
		assertFalse(ValidationUtils.checkDiagonal2Won('O', new char[][]{{'O','X','Y'},{'X','O','\0'},{'X','X','Y'}}));
	}
	
	@Test
	public void testCheckRowWon(){
		assertTrue(ValidationUtils.checkRowWon('O', new char[][]{{'O','O','O'},{'X','O','\0'},{'O','X','X'}}));
	}
	
	@Test
	public void testCheckRowLost(){
		assertFalse(ValidationUtils.checkRowWon('O', new char[][]{{'O','X','Y'},{'X','O','\0'},{'X','X','Y'}}));
	}
	
	@Test
	public void testCheckColumnWon(){
		assertTrue(ValidationUtils.checkColumnWon('O', new char[][]{{'O','X','O'},{'O','X','\0'},{'O','O','X'}}));
	}
	
	@Test
	public void testCheckColumnLost(){
		assertFalse(ValidationUtils.checkColumnWon('O', new char[][]{{'O','X','Y'},{'X','O','\0'},{'X','X','Y'}}));
	}
	
	@Test
	public void testPutAndCheckWon(){
		assertTrue(ValidationUtils.putAndCheckWon(new Cell(1,1), 'O', new char[][]{{'O','X','Y'},{'X','\0','\0'},{'X','X','O'}}));
	}
	
	@Test
	public void testPutAndCheckLost(){
		assertFalse(ValidationUtils.putAndCheckWon(new Cell(1,1), 'O', new char[][]{{'O','X','Y'},{'X','\0','\0'},{'X','X','Y'}}));
	}
	
	@Test
	public void testWon(){
		assertTrue(ValidationUtils.won('O', new char[][]{{'O','X','Y'},{'O','\0','\0'},{'O','X','Y'}}));
	}
	
	@Test
	public void testLost(){
		assertFalse(ValidationUtils.won('O', new char[][]{{'O','X','Y'},{'X','\0','\0'},{'X','X','Y'}}));
	}
	
	
}
