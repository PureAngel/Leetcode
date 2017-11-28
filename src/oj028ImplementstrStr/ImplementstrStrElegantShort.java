package oj028ImplementstrStr;

public class ImplementstrStrElegantShort {
	public int strStr(String haystack, String needle) {
		for(int i = 0; ; i++) {
			for(int j = 0; ; j++) {
				if(j == needle.length()) {
					return i;
				} else if (i + j == haystack.length()) {
					return -1;
				} else if (needle.charAt(j) != haystack.charAt(i + j)) {
					break;
				}
			}
		}
	}

}
