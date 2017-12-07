package oj044WildcardMatching;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ¡ú false
isMatch("aa","aa") ¡ú true
isMatch("aaa","aa") ¡ú false
isMatch("aa", "*") ¡ú true
isMatch("aa", "a*") ¡ú true
isMatch("ab", "?*") ¡ú true
isMatch("aab", "c*a*b") ¡ú false

 * @author Xueying Bai
 *
 */

public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		int len_s = s.length();
		int len_p = p.length();
		boolean[][] match = new boolean[len_s + 1][len_p + 1];
		match[len_s][len_p] = true;
		for(int i = len_p - 1; i >= 0; i--) {
			if(p.charAt(i) != '*') break;
			match[len_s][i] = true;
		}
		for(int i = len_s - 1; i >= 0; i--) {
			for(int j = len_p - 1; j >= 0; j--) {
				if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
					match[i][j] = match[i + 1][j + 1];
				} else if (p.charAt(j) == '*') {
					match[i][j] = match[i][j + 1] || match[i + 1][j];
				} else {
					match[i][j] = false;
				}
			}
		}
		return match[0][0];
	}

}
