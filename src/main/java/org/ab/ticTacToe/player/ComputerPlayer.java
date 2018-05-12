package org.ab.ticTacToe.player;

import org.ab.ticTacToe.ai.AIFinder;
import org.ab.ticTacToe.board.cell.Cell;
import org.ab.ticTacToe.board.cell.CellData;

public class ComputerPlayer extends Player {
	private char symbol;
	private String playerName;
	
	public ComputerPlayer(String symbol,String playerName){
		this.symbol=symbol.charAt(0);
		this.playerName=playerName;
	}
	
	@Override
	public CellData move(char[][] positions) {
		Cell position = AIFinder.getPosition(positions);
		displayPosition(position,this.playerName);
		return new CellData(position.getRow(),position.getColumn(),this.symbol);
	}

	@Override
	public char getIdentity() {
		return this.symbol;
	}

}
