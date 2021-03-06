package oj003LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author Xueying Bai
 *
 */

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int length = s.length();
		int i = 0, j = 0; // i is left, j is right
		Set<Character> set = new HashSet<>();
		while(i < length && j < length) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		
		return max;
	}

}
