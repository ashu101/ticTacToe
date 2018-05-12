package org.ab.ticTacToe.player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.ab.ticTacToe.board.cell.CellData;
import org.junit.Test;

public class ComputerPlayerTest {

	@Test
	public void testMoveIsValid() {
	    assertTrue(new ComputerPlayer("X","P1").move( new char[][]{{'O','X','Y'},{'X','O','\0'},{'X','X','O'}}) instanceof CellData);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testMoveIsInvalid(){
		//This scenario will never occur as the move is evaluated by board after every turn.
		new ComputerPlayer("X","P1").move( new char[][]{{'O','X','Y'},{'X','O','X'},{'X','X','Y'}});
	}
	
	@Test
	public void testTrueIdentity(){
		assertTrue(new ComputerPlayer("X","P1").getIdentity()=='X');
	}
	
	@Test
	public void testFalseIdentity(){
		assertFalse(new ComputerPlayer("X","P1").getIdentity()=='Y');
	}
	
}
