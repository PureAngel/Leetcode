package oj007ReverseInteger;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * Note:
 * The input is assumed to be a 32-bit signed integer. 
 * Your function should return 0 when the reversed integer overflows.
 * 
 * @author Xueying Bai
 *
 */

public class ReverseInteger {
	public int reverse(int x) {
		boolean positive = true;
		if(x < 0) {
			positive = false;
			x = -x;
		}
		long result = 0;
		while(x > 0) {
			result *= 10;
			result += x % 10;
			x /= 10;
		}
		if(result > Integer.MAX_VALUE) return 0;
		if(!positive) {
			result *= -1;
		}
		return (int)result;
	}

}
