package org.ab.ticTacToe.player;


import org.ab.ticTacToe.board.cell.Cell;
import org.ab.ticTacToe.board.cell.CellData;
import org.ab.ticTacToe.constants.Constants;

public abstract class Player {
	
	public abstract CellData move(char[][] positions);
	
	public abstract char getIdentity();
	
	public void displayPosition(Cell position,String playerName){
		System.out.println(playerName + Constants.USER_PROMPT2 +position.getRow()+Constants.SPLITTER+position.getColumn());
	}
}
