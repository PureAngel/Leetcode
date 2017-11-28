package oj049GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 [
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

 * @author Xueying Bai
 *
 */

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if(strs.length == 0) return new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for(String s: strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String keyString = String.valueOf(c);
			if(!map.containsKey(keyString)) {
				map.put(keyString, new ArrayList<String>());
			}
			map.get(keyString).add(s);
		}
		return new ArrayList<>(map.values());
	}

}
