package org.ab.ticTacToe.utils;

import org.ab.ticTacToe.constants.Constants;

public class StringUtils {
	
	public static boolean isSplittableIntoTwo(String input,String splitter){
		return input!=null && input.contains(splitter) && input.split(splitter).length==2;
	}
	
	public static boolean isSplittableIntoDigits(String input,String splitter){
		return Character.isDigit(input.split(splitter)[0].charAt(0)) && Character.isDigit(input.split(splitter)[1].charAt(0));
	}
	
	public static boolean areStringableDigitsInDimension(String input,String splitter,int dimension){
		return (Integer.valueOf(input.split(splitter)[0]) < dimension && Integer.valueOf(input.split(splitter)[0]) >=0) &&
				(Integer.valueOf(input.split(splitter)[1]) < dimension && Integer.valueOf(input.split(splitter)[1]) >=0);
	}
	
	public static boolean areStringableDigitsOccupied(String position,String splitter,char[][] positions){
		return positions[Integer.valueOf(position.split(splitter)[0])][Integer.valueOf(position.split(splitter)[1])] != Constants.EMPTY;
	}
}
