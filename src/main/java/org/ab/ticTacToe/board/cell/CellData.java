package org.ab.ticTacToe.board.cell;

public class CellData {
	private int row;
	private int column;
	private char symbol;
	
	public CellData(int row,int column, char symbol){
		this.row=row;
		this.column=column;
		this.symbol=symbol;
	}
	
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
}
