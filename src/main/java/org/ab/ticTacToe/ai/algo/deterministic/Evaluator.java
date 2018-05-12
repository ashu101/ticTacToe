package org.ab.ticTacToe.ai.algo.deterministic;

import org.ab.ticTacToe.board.cell.Cell;
import org.ab.ticTacToe.constants.Constants;

public class Evaluator {
	private char[][] positions;
	private Cell cell;
	
	public Evaluator(String position,char[][] positions){
		this.cell = new Cell(Character.getNumericValue(position.charAt(0)),Character.getNumericValue(position.charAt(1)));
		this.positions=positions;
	}

	public int availableOutcomes(char player){
		return (isOnDiagonal1() ? getDiagonal1Score(player) : 0) + (isOnDiagonal2() ? getDiagonal2Score(player) : 0) + getRowScore(player) + getColumnScore(player);
	}
	
	public boolean isOnDiagonal1(){
		return cell.getRow()==cell.getColumn();
	}
	
	public boolean isOnDiagonal2(){
		return cell.getRow()+cell.getColumn() == positions.length-1;
	}
	
	public int getDiagonal1Score(char player){
		int temp = 0;
		for(int i=0;i<positions.length;i++){
				if(positions[i][i] == Constants.EMPTY && cell.getRow()!= i && cell.getColumn() != i){
					temp++;
				}
				else if(positions[i][i] != Constants.EMPTY && positions[i][i] != player){
					return 0;
				}
				else if(positions[i][i] != Constants.EMPTY && positions[i][i] == player){
					temp+=2;
				}
		}
		return temp;
	}
	
	public int getDiagonal2Score(char player){
		int temp = 0;
		for(int i=0;i<positions.length;i++){
				if(positions[positions.length-(i+1)][i] == Constants.EMPTY && cell.getRow()!= positions.length-(i+1) && cell.getColumn() != i){
					temp++;
				}
				else if(positions[positions.length-(i+1)][i] != Constants.EMPTY && positions[positions.length-(i+1)][i] != player){
					return 0;
				}
				else if(positions[positions.length-(i+1)][i] != Constants.EMPTY && positions[positions.length-(i+1)][i] == player){
					temp+=2;
				}
		}
		return temp;
	}
	
	public int getColumnScore(char player){
		int temp = 0;
		for(int i=0;i<positions.length;i++){
				if(positions[i][cell.getColumn()] == Constants.EMPTY && cell.getRow()!= i){
					temp++;
				}
				else if(positions[i][cell.getColumn()] != Constants.EMPTY && positions[i][cell.getColumn()] != player){
					return 0;
				}
				else if(positions[i][cell.getColumn()] != Constants.EMPTY && positions[i][cell.getColumn()] == player){
					temp+=2;
				}
		}
		return temp;
	}
	
	public int getRowScore(char player){
		int temp = 0;
		for(int i=0;i<positions.length;i++){
				if(positions[cell.getRow()][i] == Constants.EMPTY && cell.getColumn()!= i){
					temp++;
				}
				else if(positions[cell.getRow()][i] != Constants.EMPTY && positions[cell.getRow()][i] != player){
					return 0;
				}
				else if(positions[cell.getRow()][i] != Constants.EMPTY && positions[cell.getRow()][i] == player){
					temp+=2;
				}
		}
		return temp;
	}
}
