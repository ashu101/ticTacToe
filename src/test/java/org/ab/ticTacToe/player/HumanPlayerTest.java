package org.ab.ticTacToe.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import org.ab.ticTacToe.board.cell.CellData;
import org.junit.Test;

public class HumanPlayerTest {

	@Test
	public void testValidatePlayerPositionForNullInput(){
		assertFalse(new HumanPlayer("X","P1").validPosition(null, new char[][]{{'1','2','3'},{'1','2','3'},{'1','2','3'}})); 	
	}
	
	@Test
	public void testValidatePlayerPositionForStringInput(){
		assertFalse(new HumanPlayer("X","P1").validPosition("a,b", new char[3][3])); 	
	}
	
	@Test
	public void testValidatePlayerPositionForInRangeDigitInput(){
		assertTrue(new HumanPlayer("X","P1").validPosition("1,1", new char[3][3])); 	
	}
	
	@Test
	public void testValidatePlayerPositionForOutOfRangeDigitInput(){
		assertFalse(new HumanPlayer("X","P1").validPosition("5,5", new char[3][3])); 	
	}
	
	@Test
	public void testValidatePlayerPositionForOccupiedCell(){
		assertFalse(new HumanPlayer("X","P1").validPosition("1,1", new char[][]{{'1','2','3'},{'1','2','3'},{'1','2','3'}})); 	
	}
	
	@Test
	public void testValidatePlayerPositionForEmptyCell(){
		assertTrue(new HumanPlayer("X","P1").validPosition("1,1", new char[3][3])); 	
	}
	
	@Test
	public void testTrueIdentity(){
		assertTrue(new HumanPlayer("X","P1").getIdentity()=='X');
	}
	
	@Test
	public void testFalseIdentity(){
		assertFalse(new HumanPlayer("X","P1").getIdentity()=='Y');
	}
	
	@Test
	public void testGetPositionFromPlayer() {
	    String input = "1,2";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    assertEquals("1,2", new HumanPlayer("X","P1").getPosition());
	}
	
	@Test
	public void testMoveIsValid() {
	    String input = "1,2";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    assertTrue(new HumanPlayer("X","P1").move( new char[][]{{'O','X','Y'},{'X','O','\0'},{'X','X','O'}}) instanceof CellData);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testMoveIsInvalid(){
		   String input = "1,1";
		   InputStream in = new ByteArrayInputStream(input.getBytes());
		   System.setIn(in);
		   //It goes on a loop and validates until a correct input in entered by user.
		   new HumanPlayer("X","P1").move( new char[][]{{'O','X','Y'},{'X','O','\0'},{'X','X','O'}});
	}
	
}
