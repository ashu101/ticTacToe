package org.ab.ticTacToe.ai.algo.deterministic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EvaluatorTest {

	@Test
	public void testIsOnDiagonal1() {
		Evaluator e = new Evaluator("22",  new char[][]{{'1','2','3'},{'1','2','\0'},{'1','2','3'}});
		assertTrue(e.isOnDiagonal1());
	}

	@Test
	public void testIsNotOnDiagonal1() {
		Evaluator e = new Evaluator("20",  new char[][]{{'1','2','3'},{'1','2','\0'},{'\0','2','3'}});
		assertFalse(e.isOnDiagonal1());
	}
	
	@Test
	public void testDiagonal1ScoreWhenFavourable(){
		Evaluator e = new Evaluator("11",  new char[][]{{'1','\0','3'},{'1','\0','\0'},{'\0','2','1'}});
		assertTrue(e.getDiagonal1Score('1')==4);
	}
	
	@Test
	public void testDiagonal1ScoreWhenNotFavourable(){
		Evaluator e = new Evaluator("11",  new char[][]{{'1','\0','3'},{'1','\0','\0'},{'\0','2','2'}});
		assertTrue(e.getDiagonal1Score('1')==0);
	
	}
	
	@Test
	public void testIsOnDiagonal2() {
		Evaluator e = new Evaluator("20",  new char[][]{{'1','2','3'},{'1','2','\0'},{'\0','2','3'}});
		assertTrue(e.isOnDiagonal2());
	}

	@Test
	public void testIsNotOnDiagonal2() {
		Evaluator e = new Evaluator("10",  new char[][]{{'1','2','3'},{'1','2','\0'},{'\0','2','3'}});
		assertFalse(e.isOnDiagonal2());
	
	}
	
	@Test
	public void testDiagonal2ScoreWhenFavourable(){
		Evaluator e = new Evaluator("20",  new char[][]{{'1','2','\0'},{'1','2','\0'},{'\0','2','3'}});
		assertTrue(e.getDiagonal2Score('2')==3);
	
	}
	
	@Test
	public void testDiagonal2ScoreWhenNotFavourable(){
		Evaluator e = new Evaluator("20",  new char[][]{{'1','2','\0'},{'1','2','\0'},{'1','2','3'}});
		assertTrue(e.getDiagonal2Score('2')==0);
	
	}
	
	@Test
	public void testRowScoreWhenFavourable(){
		Evaluator e = new Evaluator("20",  new char[][]{{'1','2','\0'},{'1','2','\0'},{'\0','\0','\0'}});
		assertTrue(e.getRowScore('2')==2);
	}
	
	@Test
	public void testRowScoreWhenNotFavourable(){
		Evaluator e = new Evaluator("20",  new char[][]{{'1','2','\0'},{'1','2','\0'},{'\0','2','3'}});
		assertTrue(e.getRowScore('2')==0);
	}
	
	@Test
	public void testColumnScoreWhenFavourable(){
		Evaluator e = new Evaluator("20",  new char[][]{{'1','2','\0'},{'1','2','\0'},{'\0','\0','\0'}});
		assertTrue(e.getColumnScore('1')==4);
	}
	
	@Test
	public void testColumnScoreWhenNotFavourable(){
		Evaluator e = new Evaluator("20",  new char[][]{{'1','2','\0'},{'1','2','\0'},{'\0','2','3'}});
		assertTrue(e.getColumnScore('2')==0);
	}
	
	@Test
	public void testAvailableOutcomes(){
		Evaluator e = new Evaluator("20",  new char[][]{{'1','2','\0'},{'1','2','\0'},{'\0','2','3'}});
		assertTrue(e.availableOutcomes('2')==3);
	}
	
	
}
