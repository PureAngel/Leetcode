package oj072EditDistance;

/**
 * Given two words word1 and word2, 
 * find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * @author Xueying Bai
 *
 */

public class EditDistance {
	public int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
        if(len1 == 0) return len2;
		if(len2 == 0) return len1;
		int[][] result = new int[len1 + 1][len2 + 1];
		for(int i = 0; i <= len1; i++) {
			result[i][0] = i;
		}
		for(int j = 0; j <= len2; j++) {
			result[0][j] = j;
		}
		for(int i = 0; i < len1; i++) {
			for(int j = 0; j < len2; j++) {
				if(word1.charAt(i) == word2.charAt(j)) {
					result[i + 1][j + 1] = result[i][j];
				} else {
					result[i + 1][j + 1] = 1 + Math.min(result[i][j], Math.min(result[i + 1][j], result[i][j + 1]));
				}
			}
		}
		return result[len1][len2];
	}

}
