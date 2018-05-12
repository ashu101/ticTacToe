package org.ab.ticTacToe.load;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConfigTest {
	
	@Test
	public void testGameDimensionsAreProvided(){
		assertTrue(!Config.DIMENSION.getValue().equals(""));
	}
	
	@Test
	public void testGameDimensionIsValid(){
		assertTrue(Integer.valueOf(Config.DIMENSION.getValue()) >=3 && Integer.valueOf(Config.DIMENSION.getValue()) <= 10);
	}

	@Test
	public void testGamePlayer1SymbolIsProvided(){
		assertTrue(!Config.PLAYER1.getValue().equals(""));
	}
	
	@Test
	public void testGamePlayer2SymbolIsProvided(){
		assertTrue(!Config.PLAYER2.getValue().equals(""));
	}
	
	@Test
	public void testGamePlayerComputerSymbolIsProvided(){
		assertTrue(!Config.COMPUTER.getValue().equals(""));
	}
	
	@Test
	public void testGamePlayer1SymbolIsValid(){
		assertTrue(Config.PLAYER1.getValue().length() == 1 && !Config.PLAYER1.getValue().equals(" "));
	}
	
	@Test
	public void testGamePlayer2SymbolIsValid(){
		assertTrue(Config.PLAYER2.getValue().length() == 1 && !Config.PLAYER2.getValue().equals(" "));
	}
	
	@Test
	public void testGamePlayerComputerSymbolIsValid(){
		assertTrue(Config.COMPUTER.getValue().length() == 1 && !Config.COMPUTER.getValue().equals(" "));
	}
	
	@Test
	public void testGamePlayer1AndPlayer2SymbolsAreDifferent(){
		assertTrue(!Config.PLAYER1.getValue().equals(Config.PLAYER2.getValue()));
	}
	
	@Test
	public void testGamePlayer1AndComputerSymbolsAreDifferent(){
		assertTrue(!Config.PLAYER1.getValue().equals(Config.COMPUTER.getValue()));
	}
	
	@Test
	public void testGamePlayer2AndComputerSymbolsAreDifferent(){
		assertTrue(!Config.PLAYER2.getValue().equals(Config.COMPUTER.getValue()));
	}

}
