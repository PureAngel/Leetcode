package oj409LongestPalindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string which consists of lowercase or uppercase letters, 
 * find the length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * Input:
 * "abccccdd"
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * @author Xueying Bai
 *
 */

public class LongestPalindrome {
	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		
		int result = 0;
		boolean isEven = true;
		for(Character character: map.keySet()) {
			if(map.get(character) % 2 == 0) {
				result += map.get(character);
			} else {
				result += map.get(character) - 1;
				isEven = false;
			}
		}
		
		if(!isEven) {
			result += 1;
		}
		
		return result;
	}

}
