package org.ab.ticTacToe.ai.algo;

import java.util.HashMap;
import java.util.Map;
import org.ab.ticTacToe.ai.algo.deterministic.Evaluator;
import org.ab.ticTacToe.ai.algo.deterministic.OutcomeSorter;
import org.ab.ticTacToe.board.cell.Cell;
import org.ab.ticTacToe.constants.Constants;
import org.ab.ticTacToe.utils.ValidationUtils;

public class Deterministic {
	private char[][] positions;
	private final char computer;
	private final char player1;
	private final char player2;
	private Cell finalMove;
	
	private Map<String,String> positionToOutcomes = new HashMap<String,String>();
	
	public Deterministic(char[][] pos,char c,char p1,char p2){
		this.positions = pos;
		this.computer = c;
		this.player1 = p1;
		this.player2 = p2;
	}
	
	/**
	 * Creates a map of available position to {@link #availableOutcomesforPosition(String) availableOutcomesPerPositionForAllPlayers}. 
	 * Outcome per position per player is defined as a score forseeing the possibility of bingo through current position.
	 * The map is sorted {@link #sortByOutcomes(Map, int) sortMapForComputersMaxPossibilities} based on max outcomes of computer winning.
	 * Final Move{@link #createFinalMove(Map) createFinalMov} is evaluated based on bingo possibilities of computer then 
	 * player1 then player 2. If no bingo possibilities, The max possibility outcome from {@link #sortByOutcomes(Map, int) map} 
	 * of computer is selected as final.
	 * 
	 * @param player
	 */
	public void calculate(char player){
		for(int i=0;i<positions.length;i++){
			for(int j=0;j<positions.length;j++){
				if(positions[i][j] == Constants.EMPTY){
					String position=i+""+j;
					positionToOutcomes.put(position, availableOutcomesforPosition(position));
				}
			}
		}
		Map<String,String> positionToOutcomesForComputer = new OutcomeSorter().sort(positionToOutcomes,0,Constants.SPLITTER);
		createFinalMove(positionToOutcomesForComputer);
	}
	
	public String availableOutcomesforPosition(String position){
		Evaluator evaluator = new Evaluator(position,positions);
		return String.valueOf(evaluator.availableOutcomes(computer)+Constants.SPLITTER+evaluator.availableOutcomes(player1)+Constants.SPLITTER+evaluator.availableOutcomes(player2));
	}
	
	public void createFinalMove(Map<String,String> ptoComputer){
		if(!checkIfPlayerCanWin(ptoComputer,computer))
			if(!checkIfPlayerCanWin(ptoComputer,player1))
				if(!checkIfPlayerCanWin(ptoComputer,player2))
					finalMove= new Cell(Character.getNumericValue(String.valueOf(ptoComputer.keySet().toArray()[0]).charAt(0)),	Character.getNumericValue(String.valueOf(ptoComputer.keySet().toArray()[0]).charAt(1)));
	}
	
	public boolean checkIfPlayerCanWin(Map<String,String> ptoComputer,char player){
		for(String key : ptoComputer.keySet()){
			Cell temp = new Cell(Character.getNumericValue(key.charAt(0)), Character.getNumericValue(key.charAt(1)));
			if(ValidationUtils.putAndCheckWon(temp,player,positions)){
				finalMove = temp;
				return true;
			}	
		}
		return false;
	}
	
	public Cell getFinalMove(){
		return finalMove;
	}
}
