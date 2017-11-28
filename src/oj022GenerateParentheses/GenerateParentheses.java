package oj022GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, 
 * write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * [
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 * @author Xueying Bai
 *
 */

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		backtrack(list, n, "", 0, 0);
		return list;
	}
	
	private void backtrack(List<String> list, int n, String string, int open, int close) {
		if(string.length() == 2 * n) {
			list.add(string);
		}
		if(open < n) {
			backtrack(list, n, string + "(", open + 1, close);
		}
		if(close < open) {
			backtrack(list, n, string + ")", open, close + 1);
		}
	}

}
