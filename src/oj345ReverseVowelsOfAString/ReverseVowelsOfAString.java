package oj345ReverseVowelsOfAString;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * 
 * Example 1:
 * Given s = "hello", return "holle".
 * 
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * 
 * Note:
 * The vowels does not include the letter "y".
 * 
 * @author Xueying Bai
 *
 */

public class ReverseVowelsOfAString {
	public String reverseVowels(String s) {
		char[] ch = s.toCharArray();
		Set<Character> set = new HashSet<>();
		set.add('a'); set.add('A');
		set.add('e'); set.add('E');
		set.add('i'); set.add('I');
		set.add('o'); set.add('O');
		set.add('u'); set.add('U');
		int i = 0, j = s.length() - 1;
		while(i < j) {
			if(!set.contains(ch[i])) {
				i++;
			}
			if(!set.contains(ch[j])) {
				j--;
			}
			if(set.contains(ch[i]) && set.contains(ch[j])) {
				char temp = ch[i];
				ch[i] = ch[j];
				ch[j] = temp;
				i++;
				j--;
			}
		}
		return new String(ch);
	}

}
