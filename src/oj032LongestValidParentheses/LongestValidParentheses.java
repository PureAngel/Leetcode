package oj032LongestValidParentheses;

/**
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", 
 * which has length = 4.
 * 
 * @author Xueying Bai
 *
 */

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int max = 0;
		int[] dp = new int[s.length()]; // dp[i] represents for the longest valid parentheses at the end of s.charAt(i)
		for(int i = 1; i < s.length(); i++) {
			// if(s.charAt(i) == '(', dp[i] = 0
			if(s.charAt(i) == ')') {
				if(s.charAt(i - 1) == '(') {
					if(i >= 2) {
						dp[i] = dp[i - 2] + 2;
					} else {
						dp[i] = 2;
					}
				} else if(i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '('){
					if(i - 2 - dp[i - 1] >= 0) {
						dp[i] = dp[i - 1] + dp[i - 2 - dp[i - 1]] + 2;
					} else {
						dp[i] = dp[i - 1] + 2;
					}
				}
				max = Math.max(max, dp[i]);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		LongestValidParentheses lvp = new LongestValidParentheses();
		String string = "()(())";
		System.out.println(lvp.longestValidParentheses(string));
	}

}
