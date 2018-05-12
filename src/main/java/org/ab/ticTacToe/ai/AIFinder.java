package org.ab.ticTacToe.ai;

import org.ab.ticTacToe.ai.algo.Deterministic;
import org.ab.ticTacToe.ai.algo.MinMax;
import org.ab.ticTacToe.board.cell.Cell;
import org.ab.ticTacToe.load.Config;

public final class AIFinder {
	private static final char computer = Config.COMPUTER.getValue().charAt(0);
	private static final char player1 = Config.PLAYER1.getValue().charAt(0);
	private static final char player2 = Config.PLAYER2.getValue().charAt(0);
	
	/*
	 * Find the best position on board using Deterministic/MinMax Algo
	 */
	public static Cell getPosition(char[][] positions){
		return evaluateDeterministicAlgo(positions);
	}
	
	/**
	 * Evaluage by MinMax Algo
	 * @param positions
	 * @return
	 */
	private static Cell evaluateMinMaxAlgo(char[][] positions){
		MinMax algo = new MinMax(positions,computer,player1,player2);
		algo.calculate(0, computer);
		return algo.getFinalMove();
	}
	
	/**
	 * Evaluate by Deterministic Algo
	 * @param positions
	 * @return
	 */
	private static Cell evaluateDeterministicAlgo(char[][] positions){
		Deterministic algo = new Deterministic(positions,computer,player1,player2);
		algo.calculate(computer);
		return algo.getFinalMove();
	}
	
}
