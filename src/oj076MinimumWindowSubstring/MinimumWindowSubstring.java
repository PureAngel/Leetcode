package oj076MinimumWindowSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string S and a string T, 
 * find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * 
 * If there are multiple such windows, 
 * you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * @author Xueying Bai
 *
 */

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		
		// store characters in t
		Map<Character, Integer> map_t = new HashMap<>();
		for(int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if(!map_t.containsKey(c)) {
				map_t.put(c, 1);
			} else {
				map_t.put(c, map_t.get(c) + 1);
			}
		}
		
		Map<Character, Integer> map_window = new HashMap<>();
		
		int begin = 0;
		String result = "";
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if(map_window.containsKey(c)) {
        		map_window.put(c, map_window.get(c) + 1);
        	} else {
				map_window.put(c, 1);
			}
        	
        	while(begin < i) {
        		if(!map_t.containsKey(s.charAt(begin))) { // t not contains begin character
            		begin++;
            	} else if (map_window.get(s.charAt(begin)) > map_t.get(s.charAt(begin))) {
    				map_window.put(s.charAt(begin), map_window.get(s.charAt(begin)) - 1);
    				begin++;
    			} else {
    				break;
    			}
        	}
        	
        	// 更新result
        	if(is_window_ok(map_window, map_t)) {
        		int new_window_length = i - begin + 1;
        		if(result == "" || result.length() > new_window_length) {
        			result = s.substring(begin, begin + new_window_length);
        		}
        	}
		}
        return result;
	}
	
	private boolean is_window_ok(Map<Character, Integer> map_window, Map<Character, Integer> map_t) {
		for (Character character : map_t.keySet()) {
			// t中的字符比窗口中的该字符数目多
			if(!map_window.containsKey(character) || map_t.get(character) > map_window.get(character)) {
				return false;
			}
		}
		return true;
	}

}
