package oj344ReverseString;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * 
 * Example:
 * Given s = "hello", return "olleh".
 * 
 * @author Xueying Bai
 *
 */

public class ReverseString {
	public String reverseString(String s) {
		char[] ch = s.toCharArray();
		int i = 0, j = s.length() - 1;
		while(i < j) {
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i++;
			j--;
		}
		return new String(ch);
	}

}
