package org.ab.ticTacToe.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testIsSplittableIntoTwoForNull(){
		assertFalse(StringUtils.isSplittableIntoTwo(null,","));
	}
	
	@Test
	public void testIsSplittableIntoTwoForMissingSplitter(){
		assertFalse(StringUtils.isSplittableIntoTwo("5.4", ","));
	}
	
	@Test
	public void testIsSplittableIntoTwoForValidInput(){
		assertTrue(StringUtils.isSplittableIntoTwo("5,4", ","));
	}
	
	@Test
	public void testIsSplittableIntoTwoForMultipleSplitters(){
		assertFalse(StringUtils.isSplittableIntoTwo("5,4,5", ","));
	}
	
	@Test
	public void testIsSplittableIntoDigitsForNonSplittableStringInput(){
		assertFalse(StringUtils.isSplittableIntoDigits("abc", ","));
	}
	
	@Test
	public void testIsSplittableIntoDigitsForSplittableStringInput(){
		assertFalse(StringUtils.isSplittableIntoDigits("abc,c", ","));
	}
	
	@Test
	public void testIsSplittableIntoDigitsForNegativeInput(){
		assertFalse(StringUtils.isSplittableIntoDigits("-1,4", ","));
	}
	
	@Test
	public void testIsSplittableIntoDigitsForValidInput(){
		assertTrue(StringUtils.isSplittableIntoDigits("5,4", ","));
	}
	
	@Test
	public void testAreStringableDigitsInDimensionForColumnElementOutside(){
		assertFalse(StringUtils.areStringableDigitsInDimension("3,4", ",", 4));
	}
	
	@Test
	public void testAreStringableDigitsInDimensionForRowElementOutside(){
		assertFalse(StringUtils.areStringableDigitsInDimension("4,3", ",", 4));
	}

	@Test
	public void testAreStringableDigitsInDimensionForRowAndColumnElementOutside(){
		assertFalse(StringUtils.areStringableDigitsInDimension("4,4", ",", 4));
	}

	@Test
	public void testAreStringableDigitsInDimensionForRowAndColumnInside(){
		assertTrue(StringUtils.areStringableDigitsInDimension("2,2", ",", 4));
	}

	@Test
	public void testAreStringableDigitsOccupiedForEmptiness(){
		assertFalse(StringUtils.areStringableDigitsOccupied("2,2", ",", new char[4][4]));
	}
	
	@Test
	public void testAreStringableDigitsOccupiedForNonEmptiness(){
		assertTrue(StringUtils.areStringableDigitsOccupied("2,2", ",", new char[][]{{'1','2','3'},{'1','2','3'},{'1','2','3'}} ));
	}
}
