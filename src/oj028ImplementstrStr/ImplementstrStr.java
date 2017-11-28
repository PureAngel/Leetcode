package oj028ImplementstrStr;

public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		int len = needle.length();
		if(needle.equals(haystack)) {
			return 0;
		}
		for(int i = 0; i <= haystack.length() - len; i++) {
			if(haystack.substring(i, i + len).equals(needle)) {
				return i;
			}
		}
		return -1;
	}

}
