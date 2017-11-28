package oj003LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersOptimize {
	public int lengthOfLongestSubstring(String s) {
		int len = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0, j = 0; j < s.length(); j++) {
			if(map.containsKey(s.charAt(j))) {
				i = Math.max(i, map.get(s.charAt(j)));
			} 
			len = Math.max(len, j - i);
			map.put(s.charAt(j), j);
		}
		return len;
	}

}
