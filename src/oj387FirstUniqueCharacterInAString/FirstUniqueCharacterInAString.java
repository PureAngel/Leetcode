package oj387FirstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index. 
 * If it doesn't exist, return -1.
 * 
 * Examples:
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 * @author Xueying Bai
 *
 */

public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
		int index = -1;
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		for(int i = 0; i < s.length(); i++) {
			if(map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return index;
	}

}
