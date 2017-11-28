package oj115DistinctSubsequence;

/**
 * Given a string S and a string T, 
 * count the number of distinct subsequences of S which equals T.
 * 
 * A subsequence of a string is a new string
 * which is formed from the original string
 * by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * 
 * @author Xueying Bai
 *
 */

/**
 * DP solution:
 * path[i][j]: T(1,...,i) in S(1,...,j)
 * Path[0][j] = 1
 * Path[i][0] = 0
 * @author Administrator
 *
 */
public class DistinctSubsequence {
	public int numDistinct(String s, String t) {
		// mĞĞnÁĞ
		int m = t.length();
		int n = s.length();
		if(m > n) return 0;
		int[][] path = new int[m + 1][n + 1];
		for(int i = 0; i <= m; i++) {
			path[i][0] = 0;
		}
		for(int i = 0; i <= n; i++) {
			path[0][i] = 1;
		}
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s.charAt(j - 1) == t.charAt(i - 1)) {
					path[i][j] = path[i - 1][j - 1] + path[i][j - 1];
				} else {
					path[i][j] = path[i][j - 1];
				}
			}
		}
		return path[m][n];
	}

}
