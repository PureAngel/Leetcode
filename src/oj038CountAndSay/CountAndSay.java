package oj038CountAndSay;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

 * @author Xueying Bai
 *
 */

public class CountAndSay {
	public String countAndSay(int n) {
		if(n == 0) return "";
		String result = "1";
		for(int j = 1; j < n; j++) {
			String tempString = "";
			for(int i = 0; i < result.length(); i++) {
				int count = 1;
				while(i < result.length() - 1 && result.charAt(i) == result.charAt(i + 1)) {
					count++;
					i++;
				}
				tempString += Integer.toString(count) + result.charAt(i);
			}
			result = tempString;
		}
		return result;
	}

}
