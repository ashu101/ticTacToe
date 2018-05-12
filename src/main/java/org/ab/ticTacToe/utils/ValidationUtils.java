package org.ab.ticTacToe.utils;

import java.util.ArrayList;
import java.util.List;

import org.ab.ticTacToe.board.cell.Cell;
import org.ab.ticTacToe.constants.Constants;

public class ValidationUtils {

	public static List<Cell> emptyPositions(char[][] positions){
		List<Cell> availableCells = new ArrayList<Cell>();
		for(int i=0;i<positions.length;i++)
			for(int j=0;j<positions.length;j++)
				if(positions[i][j] == Constants.EMPTY)
					availableCells.add(new Cell(i,j));
		return availableCells;
	}
	
	public static boolean won(char player,char[][] positions){
		return checkDiagonal1Won(player,positions) || checkDiagonal2Won(player,positions) || 
				checkRowWon(player,positions) || checkColumnWon(player,positions);
	}
	
	public static boolean checkDiagonal1Won(char player,char positions[][]){
		for(int i=0;i<positions.length;i++){
			if(i+1 < positions.length){
				if(positions[i][i] == positions[i+1][i+1] && positions[i][i] == player)
					continue;
				else
					return false;
			}
		}
		return true;
	}
	
	public static boolean checkDiagonal2Won(char player,char positions[][]){
		for(int i=0;i<positions.length;i++){
			if(i+1 < positions.length){
				if(positions[positions.length-(i+1)][i] == positions[positions.length-(i+2)][i+1] && positions[positions.length-(i+1)][i] == player)
					continue;
				else
					return false;
			}
		}
		return true;
	}
	
	public static boolean checkRowWon(char player,char positions[][]){
		int cnt = 0;
		for(int i=0;i<positions.length;i++){
			for(int j=0;j<positions.length;j++){
				if(j+1 < positions.length){
					if((positions[i][j] == positions[i][j+1] && positions[i][j] == player))
						cnt++;
					else 
						break;
				}
			}
			if(cnt==positions.length-1)
				return true;
			cnt=0;
		}
		return false;
	}
	
	public static boolean checkColumnWon(char player,char positions[][]){
		int cnt = 0;
		for(int i=0;i<positions.length;i++){
			for(int j=0;j<positions.length;j++){
				if(j+1 < positions.length){
					if(positions[j][i] == positions[j+1][i] && positions[j][i] == player)
						cnt++;
					else 
						break;
				}
			}
			if(cnt==positions.length-1)
				return true;
			cnt=0;
		}
		return false;
	}
	
	public static boolean putAndCheckWon(Cell cell,char player,char[][] positions){
		boolean status=false;
		positions[cell.getRow()][cell.getColumn()] = player;
		if(ValidationUtils.won(player, positions))	status= true;
		positions[cell.getRow()][cell.getColumn()] = Constants.EMPTY;
		return status;
	}
}
