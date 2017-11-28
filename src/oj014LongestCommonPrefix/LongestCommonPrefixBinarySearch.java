package oj014LongestCommonPrefix;

public class LongestCommonPrefixBinarySearch {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		int minLen = Integer.MAX_VALUE;
		for(String s: strs) {
			minLen = Math.min(s.length(), minLen);
		}
		int low = 1;
		int high = minLen;
		while(low <= high) {
			int mid = (low + high) / 2;
			if(isCommonPrefix(strs, mid)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return strs[0].substring(0, (low + high) / 2);
	}
	
	private boolean isCommonPrefix(String[] strs, int len) {
		String s = strs[0].substring(0, len);
		for(int i = 1; i < strs.length; i++) {
			if(!strs[i].startsWith(s)) {
				return false;
			}
		}
		return true;
	}

}
