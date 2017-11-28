package oj242ValidAnagram;

import java.util.Arrays;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? 
 * ow would you adapt your solution to such case?
 * 
 * @author Xueying Bai
 *
 */

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
		
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		Arrays.sort(sArray);
		Arrays.sort(tArray);
		for(int i = 0; i < sArray.length; i++) {
			if(sArray[i] != tArray[i]) {
				return false;
			}
		}
		return true;
	}

}
