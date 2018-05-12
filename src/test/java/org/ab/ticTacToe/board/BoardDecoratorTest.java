package org.ab.ticTacToe.board;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardDecoratorTest {

	@Test
	public void testDisplayOfHorizontalBorders(){
		BoardDecorator b = new BoardDecorator(new Board(3));
		assertTrue(b.display().contains("*****"));
	}
	
	@Test
	public void testDisplayOfVerticalBorders(){
		BoardDecorator b = new BoardDecorator(new Board(3));
		assertTrue(b.display().split("\n")[1].split(String.valueOf('\0'))[0].equals("*"));
	}
}
