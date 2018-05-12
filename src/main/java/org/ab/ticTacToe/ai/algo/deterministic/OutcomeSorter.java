package org.ab.ticTacToe.ai.algo.deterministic;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutcomeSorter {

	public Map<String, String> sort(Map<String, String> map,final int player,final String SPLITTER)
    {
		Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        List<Entry<String, String>> list = new LinkedList<Entry<String, String>>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<String, String>>(){
            public int compare(Entry<String, String> o1,Entry<String, String> o2) {
                return Integer.valueOf(o2.getValue().split(SPLITTER)[player]).compareTo(Integer.valueOf(o1.getValue().split(SPLITTER)[player]));
            }
        });
        for (Entry<String, String> entry : list)
            sortedMap.put(entry.getKey(), entry.getValue());
        return sortedMap;
    }
}
