package org.ab.ticTacToe.board;

import org.ab.ticTacToe.board.cell.CellData;

public interface IBoard {
	
	public String display();
	
	public void fillPosition(CellData data);
	
	public char[][] allPositions();
	
	public boolean validate(char[] ids);
	
}
