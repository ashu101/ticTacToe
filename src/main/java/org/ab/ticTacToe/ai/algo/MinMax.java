package org.ab.ticTacToe.ai.algo;

import java.util.List;

import org.ab.ticTacToe.board.cell.Cell;
import org.ab.ticTacToe.constants.Constants;
import org.ab.ticTacToe.utils.ValidationUtils;

public class MinMax {
	private char[][] positions;
	private final char computer;
	private final char player1;
	private final char player2;
	private Cell finalMove;

	public MinMax(char[][] pos,char c,char p1,char p2){
		this.positions = pos;
		this.computer = c;
		this.player1 = p1;
		this.player2 = p2;
	}
	
	public int calculate(int depth,char player){
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		List<Cell> available = ValidationUtils.emptyPositions(positions);
		if(ValidationUtils.won(computer,positions))
			return 1;//Computer Won
		else if(ValidationUtils.won(player1,positions) || ValidationUtils.won(player2,positions))
			return -1;//Computer List
		if(available.isEmpty())
			return 0;//Draw
		
		for(int i=0;i<available.size();i++){
			Cell c = available.get(i);
			if(player == computer)
			{
				mockMove(c, player, positions);
				int local = calculate(depth+1,player1);
				max = Math.max(max,local);
				setFinalComputerPositionAtTreeTop(local,depth,c);
				if(clearPositionWhenExpectedScoreFound(local,c,1)) break;//Expected is Win = 1
				setFinalComputerPositionAtLastAvailableSpotAndLeastScore(max,depth,c,i == available.size() -1 );
			}
			else if(player == player1)
			{
				mockMove(c, player, positions);
				min = Math.min(calculate(depth+1,player2),min);
				if(clearPositionWhenExpectedScoreFound(min,c,-1)) break;//Expected is Lost = -1
			}
			else if(player == player2)
			{
				mockMove(c, player, positions);
				min = Math.min(min, calculate(depth+1,computer));
				if(clearPositionWhenExpectedScoreFound(min,c,-1)) break;//Expected is Lost = -1
			}	
			positions[c.getRow()][c.getColumn()] = Constants.EMPTY;
		}
		return player == computer ? max : min;
	}
	
	private void setFinalComputerPositionAtLastAvailableSpotAndLeastScore(int max,int depth,Cell c,boolean atLast){
		if(depth == 0 && atLast && max <0)
			finalMove = c;
	}
	
	private void setFinalComputerPositionAtTreeTop(int score,int depth,Cell c){
		if(score >= 0)
			if(depth == 0)
				finalMove=c;
	}
	
	private boolean clearPositionWhenExpectedScoreFound(int score,Cell c,int expected){
		if(score == expected){
			positions[c.getRow()][c.getColumn()] = Constants.EMPTY;
			return true;
		}
		return false;
	}
	
	private boolean mockMove(Cell cell, char player,char[][] positions){
		if(positions[cell.getRow()][cell.getColumn()] != Constants.EMPTY)
			return false;
		positions[cell.getRow()][cell.getColumn()] = player;
		return true;
	}
	
	public Cell getFinalMove(){
		return finalMove;
	}
}
