package org.ab.ticTacToe.ai.algo.deterministic;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class OutcomeSorterTest {

	@Test
	public void testValidInput() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("10", "1,2,3");
		map.put("00", "3,2,1");
		Map<String,String> sorted = new OutcomeSorter().sort(map, 0, ",");
		assertTrue(map.get(sorted.keySet().toArray()[0]).equals("3,2,1"));
	}

	@Test
	public void testEmptyInput() {
		Map<String,String> map = new HashMap<String,String>();
		Map<String,String> sorted = new OutcomeSorter().sort(map, 0, ",");
		assertTrue(sorted.keySet().size()==0);
	}

}

