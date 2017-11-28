package oj187RepeatedDNASequences;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
 * for example: "ACGAATTCCG". When studying DNA, 
 * it is sometimes useful to identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) 
 * that occur more than once in a DNA molecule.
 * 
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @author Xueying Bai
 *
 */

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<String>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length() - 9; i++) {
        	String item = s.substring(i, i + 10);
        	if(!map.containsKey(item)) {
        		map.put(item, 1);
        	} else {
				map.put(item, map.get(item) + 1);
			}
        }
        for (String string : map.keySet()) {
			if(map.get(string) > 1) {
				result.add(string);
			}
		}
        return result;
    }

}
