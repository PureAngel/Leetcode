package oj014LongestCommonPrefix;

// Divide and Conquer
public class LongestCommonPrefixDevideAndConquer {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		return longestCommonPrefix(strs, 0, strs.length - 1);
	}
	
	private String longestCommonPrefix(String[] strs, int left, int right) {
		if(left == right) return strs[left];
		int mid = (right + left) / 2;
		String leftString = longestCommonPrefix(strs, left, mid);
		String rightString = longestCommonPrefix(strs, mid + 1, right);
		return commonString(leftString, rightString);
	}
	
	private String commonString(String s1, String s2) {
		int len = Math.min(s1.length(), s2.length());
		for(int i = 0; i < len; i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				return s1.substring(0, i);
			}
		}
		return s1.substring(0, len);
	}

}
