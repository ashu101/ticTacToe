package org.ab.ticTacToe;

import java.util.Random;

import org.ab.ticTacToe.board.Board;
import org.ab.ticTacToe.board.BoardDecorator;
import org.ab.ticTacToe.board.IBoard;
import org.ab.ticTacToe.load.Config;
import org.ab.ticTacToe.player.ComputerPlayer;
import org.ab.ticTacToe.player.HumanPlayer;
import org.ab.ticTacToe.player.Player;

public final class Game {
	private IBoard board = new BoardDecorator(new Board(Integer.valueOf(Config.DIMENSION.getValue())));
	private Player[] players = {new HumanPlayer(Config.PLAYER1.getValue(), Config.PLAYER1.name()), 
	                            new HumanPlayer(Config.PLAYER2.getValue(),Config.PLAYER2.name()),
	                             new ComputerPlayer(Config.COMPUTER.getValue(),Config.COMPUTER.name())};
	private int turn = new Random().nextInt(players.length);

	public void execute()  {
		do {	play();
			    showBoard();
		} while (gameIsNotOver());
	}
	
	public static void main(String[] args) {
		new Game().execute();
	}
	
	public boolean changeTurn() {
		if (++turn == players.length)	turn = 0;
		return true;
	}

	public void play() {
		board.fillPosition(players[turn].move(board.allPositions()));
	}

	public void showBoard() {
		System.out.println(board.display());
	}

	public boolean gameIsNotOver() {
		return board.validate(fetchPlayerIdentities()) ? changeTurn() : false;
	}
	
	private char[] fetchPlayerIdentities() {
		int i=0;
		char[] identities = new char[players.length];
		for(Player plyr : players)
			identities[i++]=plyr.getIdentity();
		return identities;
	}
	
}
