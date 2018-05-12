package org.ab.ticTacToe.player;

import java.util.Scanner;

import org.ab.ticTacToe.board.cell.Cell;
import org.ab.ticTacToe.board.cell.CellData;
import org.ab.ticTacToe.constants.Constants;
import org.ab.ticTacToe.utils.StringUtils;

public class HumanPlayer extends Player{
	private char symbol;
	private String playerName;
	private Scanner scan = new Scanner(System.in);
	
	public HumanPlayer(String symbol,String name){
		this.symbol=symbol.charAt(0);
		this.playerName=name;
	}
	
	public String getPosition() {
		System.out.println(Constants.USER_PROMPT1 +playerName +Constants.USER_PROMPT2);
		String position = scan.nextLine();
		return position;
	}
	
	public boolean validPosition(String position,char[][] positions){
		if(StringUtils.isSplittableIntoTwo(position,Constants.SPLITTER) && StringUtils.isSplittableIntoDigits(position, Constants.SPLITTER) && StringUtils.areStringableDigitsInDimension(position,Constants.SPLITTER, positions.length) && !StringUtils.areStringableDigitsOccupied(position,Constants.SPLITTER,positions))
			displayPosition(new Cell(Integer.valueOf(position.split(Constants.SPLITTER)[0]),Integer.valueOf(position.split(Constants.SPLITTER)[1])), this.playerName);
		else return false;
		return true;
	}
	
	@Override
	public CellData move(char[][] positions)  {
		String position;
		do{
			position = getPosition();
		}while(!validPosition(position,positions));
		return new CellData(Integer.valueOf(position.split(Constants.SPLITTER)[0]),Integer.valueOf(position.split(Constants.SPLITTER)[1]),this.symbol);
	}

	@Override
	public char getIdentity() {
		return this.symbol;
	}
	

}
