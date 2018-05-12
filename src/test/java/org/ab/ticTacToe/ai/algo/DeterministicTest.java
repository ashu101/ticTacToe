package org.ab.ticTacToe.ai.algo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.ab.ticTacToe.board.cell.Cell;
import org.junit.Test;

public class DeterministicTest {

	@Test
	public void testCalculateWinPosition(){
		Deterministic algo = new Deterministic(new char[][]{{'X','Y','O'},{'Y','O','X'},{'\0','\0','Y'}},'O','X','Y');
		algo.calculate( 'O');
		Cell c = algo.getFinalMove();
		assertTrue(c.getRow() == 2 && c.getColumn() == 0);
	}
	
	@Test
	public void testCalculateOpponentWinPosition(){
		Deterministic algo = new Deterministic(new char[][]{{'O','Y','X'},{'Y','X','O'},{'\0','\0','Y'}},'O','X','Y');
		algo.calculate( 'O');
		Cell c = algo.getFinalMove();
		assertTrue(c.getRow() == 2 && c.getColumn() == 0);
	}
	
	@Test
	public void testFinalMove(){
		Deterministic algo = new Deterministic(new char[][]{{'O','Y','X'},{'Y','X','O'},{'\0','\0','Y'}},'O','X','Y');
		algo.calculate( 'O');
		Cell c = algo.getFinalMove();
		assertTrue(c!=null);
	}
	
	@Test
	public void testAvailableOutcomesForPosition(){
		Deterministic algo = new Deterministic(new char[][]{{'X','Y','O'},{'Y','O','X'},{'\0','\0','Y'}},'O','X','Y');
		assertTrue(algo.availableOutcomesforPosition("20").equals("4,0,3"));
	}
	
	@Test
	public void testCheckIfPlayerCanWin(){
		Deterministic algo = new Deterministic(new char[][]{{'X','Y','O'},{'Y','O','X'},{'\0','\0','Y'}},'O','X','Y');
		Map<String,String> ptoComputer = new HashMap<String,String>();
		ptoComputer.put("20","4,1,3");
		ptoComputer.put("21","0,0,3");
		assertTrue(algo.checkIfPlayerCanWin(ptoComputer, 'O'));
	}
	
	@Test
	public void testCheckIfPlayerCanLose(){
		Deterministic algo = new Deterministic(new char[][]{{'X','Y','O'},{'Y','O','X'},{'\0','\0','Y'}},'O','X','Y');
		Map<String,String> ptoComputer = new HashMap<String,String>();
		ptoComputer.put("20","4,1,3");
		ptoComputer.put("21","0,0,3");
		assertFalse(algo.checkIfPlayerCanWin(ptoComputer, 'X'));
	}
}
