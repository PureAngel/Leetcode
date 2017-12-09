package oj097InterleavingString;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * @author Xueying Bai
 *
 */

// DP
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s1.length() == 0) {
			return s2.equals(s3);
		}
		if(s2 == null || s2.length() == 0) {
			return s1.equals(s3);
		}
		int len1= s1.length(), len2 = s2.length(), len3 = s3.length();
		if(len1 + len2 != len3) return false;
		boolean[][] match = new boolean[len1 + 1][len2 + 1];
		match[0][0] = true;
		for(int i = 1; i <= len1; i++) {
			if(s1.charAt(i - 1) != s3.charAt(i - 1)) {
				for(int j = i; j <= len1; j++) {
					match[j][0] = false;
				}
				break;
			} else {
				match[i][0] = true;
			}
		}
		for(int i = 1; i <= len2; i++) {
			if(s2.charAt(i - 1) != s3.charAt(i - 1)) {
				for(int j = i; j <= len2; j++) {
					match[0][j] = false;
				}
				break;
			} else {
				match[0][i] = true;
			}
		}
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				if(s1.charAt(i - 1) != s3.charAt(i + j - 1) && s2.charAt(j - 1) != s3.charAt(i + j - 1)) {
					match[i][j] = false;
				} else if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && match[i - 1][j]) {
					match[i][j] = true;
				} else if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && match[i][j - 1]) {
					match[i][j] = true;
				} else {
					match[i][j] = false;
				}
			}
		}
		return match[len1][len2];
	}

}
