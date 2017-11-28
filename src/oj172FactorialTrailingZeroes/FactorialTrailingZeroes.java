package oj172FactorialTrailingZeroes;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * @author Xueying Bai
 *
 */

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int result = 0;
		while(n > 0) {
			result += n / 5;
			n /= 5;
		}
		return result;
	}

}
