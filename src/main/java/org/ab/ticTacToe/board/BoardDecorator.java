package org.ab.ticTacToe.board;

import org.ab.ticTacToe.board.cell.CellData;
import org.ab.ticTacToe.constants.Constants;

public class BoardDecorator implements IBoard{
	private IBoard board;
	
	public BoardDecorator(IBoard b) {
		board=b;
	}
	
	@Override
	public String display() {
		return addHorizontalBorders(addVerticalBorders(board.display()));
	}

	private String addVerticalBorders(String str){
		StringBuilder sb = new StringBuilder();
		for(String s : str.split(Constants.SPLIT_BY_NEW_LINE)) sb.append(Constants.BOARD_DECOR).append(s).append(Constants.BOARD_DECOR).append(Constants.NEW_LINE);
		return sb.toString();
	}
	
	private String addHorizontalBorders(String str){
		String header="";
		for(int i=0; i< str.split(Constants.SPLIT_BY_NEW_LINE)[0].length();i++) header+=Constants.BOARD_DECOR;
		return header+Constants.NEW_LINE+str+header;
	}
	
	@Override
	public void fillPosition(CellData data) {
		board.fillPosition(data);
	}

	@Override
	public boolean validate(char[] ids) {
		return board.validate(ids);
	}

	@Override
	public char[][] allPositions() {
		return board.allPositions();
	}
}
