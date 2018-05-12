package org.ab.ticTacToe.board;

import org.ab.ticTacToe.board.cell.CellData;
import org.ab.ticTacToe.constants.Constants;
import org.ab.ticTacToe.utils.ValidationUtils;

public class Board implements IBoard{
	private char[][] positions;
	
	public Board(int dimension) {
		positions = new char[dimension][dimension];
	}

	@Override
	public String display() {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i<allPositions().length; i++) b.append(allPositions()[i]).append(Constants.NEW_LINE);
		return b.toString();
	}
	
	@Override
	public void fillPosition(CellData data) {
		positions[data.getRow()][data.getColumn()]=data.getSymbol();
	}

	@Override
	public boolean validate(char[] ids) {
		return (checkWins(ids) || checkDraws()) ? false : true;
	}

	private boolean checkWins(char[] ids) {
		for (char id : ids)
			if(ValidationUtils.won(id, positions)){
				System.out.println(id + Constants.WON_TEXT);return true;
			}
		return false;
	}
	
	private boolean checkDraws(){
		if(ValidationUtils.emptyPositions(positions).isEmpty()){
			System.out.println(Constants.DRAW_TEXT);return true;
		}
		return false;
	}

	
	@Override
	public char[][] allPositions() {
		return positions.clone();
	}

}
