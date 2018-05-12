package org.ab.ticTacToe;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameTest {
	@Test
	public void testGameIsNotOver(){
		assertTrue(new Game().gameIsNotOver());
	}
	
	@Test
	public void testTurnChange(){
		assertTrue(new Game().changeTurn());
	}
}
