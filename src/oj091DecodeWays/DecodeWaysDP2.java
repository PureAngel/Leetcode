package oj091DecodeWays;

public class DecodeWaysDP2 {
	public int numDecodings(String s) {
		int len = s.length();
		if(len == 0) return 0;
		int[] num = new int[len + 1];
		num[0] = 1;
		num[1] = s.charAt(0) != '0' ? 1 : 0;
		for(int i = 2; i <= len; i++) {
			int first = Integer.parseInt(s.substring(i - 1, i));
			int second = Integer.parseInt(s.substring(i - 2, i));
			if(first >= 1 && first <= 9) {
				num[i] += num[i - 1];
			}
			if(second >= 10 && second <= 26) {
				num[i] += num[i - 2];
			}
		}
		return num[len];
	}

}
