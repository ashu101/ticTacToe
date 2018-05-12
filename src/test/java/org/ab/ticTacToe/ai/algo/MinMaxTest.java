package org.ab.ticTacToe.ai.algo;

import static org.junit.Assert.assertTrue;

import org.ab.ticTacToe.board.cell.Cell;
import org.junit.Test;

public class MinMaxTest {
	
	@Test
	public void testCalculateWinPosition(){
		MinMax algo = new MinMax(new char[][]{{'X','Y','O'},{'Y','O','X'},{'\0','\0','Y'}},'O','X','Y');
		algo.calculate(0, 'O');
		Cell c = algo.getFinalMove();
		assertTrue(c.getRow() == 2 && c.getColumn() == 0);
	}
	
	@Test
	public void testCalculateOpponentWinPosition(){
		MinMax algo = new MinMax(new char[][]{{'O','Y','X'},{'Y','X','O'},{'\0','\0','Y'}},'O','X','Y');
		algo.calculate(0, 'O');
		Cell c = algo.getFinalMove();
		assertTrue(c.getRow() == 2 && c.getColumn() == 0);
	}
	
	@Test
	public void testFinalMove(){
		MinMax algo = new MinMax(new char[][]{{'O','Y','X'},{'Y','X','O'},{'\0','\0','Y'}},'O','X','Y');
		algo.calculate(0, 'O');
		Cell c = algo.getFinalMove();
		assertTrue(c!=null);
	}
}
