package org.ab.ticTacToe.board;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.ab.ticTacToe.board.cell.CellData;
import org.junit.Test;

public class BoardTest {
	
	@Test
	public void testEmptyBoardDisplay(){
		Board b = new Board(3);
		assertTrue(!b.display().contains("X") && !b.display().contains("Y")
				&& !b.display().contains("O"));
	}
	
	@Test
	public void testFillEmptyPosition(){
		Board b = new Board(3);
		CellData c = new CellData(0, 0, 'O');
		b.fillPosition(c);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testFillNonExistingPosition(){
		Board b = new Board(3);
		CellData c = new CellData(4, 4, 'O');
		b.fillPosition(c);
	}
	
	@Test
	public void testBoardValid(){
		Board b = new Board(3);
		b.fillPosition(new CellData(0, 0, 'O'));
		assertTrue(b.validate(new char[]{'O'}));
	}
	
	@Test
	public void testBoardInValidDueToDraw(){
		Board b = new Board(3);
		b.fillPosition(new CellData(0, 0, 'O'));
		b.fillPosition(new CellData(0, 1, 'X'));
		b.fillPosition(new CellData(0, 2, 'Y'));
		b.fillPosition(new CellData(1, 0, 'X'));
		b.fillPosition(new CellData(1, 1, 'Y'));
		b.fillPosition(new CellData(1, 2, 'O'));
		b.fillPosition(new CellData(2, 0, 'O'));
		b.fillPosition(new CellData(2, 1, 'X'));
		b.fillPosition(new CellData(2, 2, 'Y'));
		assertFalse(b.validate(new char[]{'O','X','Y'}));
	}
	
	@Test
	public void testBoardInValidDueToWin(){
		Board b = new Board(3);
		b.fillPosition(new CellData(0, 0, 'O'));
		b.fillPosition(new CellData(0, 1, 'O'));
		b.fillPosition(new CellData(0, 2, 'O'));
		assertFalse(b.validate(new char[]{'O','X','Y'}));
	}
	
	@Test
	public void testAllPositions(){
		Board b  = new Board(3);
		assertTrue(b.allPositions().length==3 && b.allPositions()[0].length ==3);
	}
}
