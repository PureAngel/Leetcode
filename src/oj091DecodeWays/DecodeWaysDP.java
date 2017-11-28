package oj091DecodeWays;

// DP动态规划算法
public class DecodeWaysDP {
	public int numDecodings(String s) {
		int len = s.length();
		if(len == 0) return 0;
		int[] num = new int[len + 1];
		num[len] = 1; // 这个是指""
		num[len - 1] = s.charAt(len - 1) != '0' ? 1 : 0;
		for(int i = len - 2; i >= 0; i--) {
			if(s.charAt(i) == '0') continue;
			if(Integer.parseInt(s.substring(i, i + 2)) <= 26) {
				num[i] = num[i + 1] + num[i + 2];
			} else {
				num[i] = num[i + 1];
			}
		}
		return num[0];
	}

}
