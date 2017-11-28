package oj069Sqrtx;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * @author Xueying Bai
 *
 */

public class Sqrtx {
	public int mySqrt(int x) {
		/* 127ms
		if(x == 0) return 0;
		int i = 1;
		while(i <= x / i) {
			i++;
		}
		return i - 1;
		*/
		// binary search (Integer Newton) 5ms
		if(x == 0) return 0;
		int left = 1, right = Integer.MAX_VALUE;
		while(true) {
			int mid = left + (right - left) / 2; // 不能写作(left + right) / 2, 越界！！！
			if(mid > x / mid) {
				right = mid - 1;
			} else {
				if(mid + 1 > x / (mid + 1)) {
					return mid;
				} else {
					left = mid + 1;
				}
			}
		}
	}

}
