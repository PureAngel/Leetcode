package oj241PowerOfTwo;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * @author Xueying Bai
 *
 */

public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		if(n <= 0) return false;
		if((n & (n - 1)) == 0) return true;
		return false;
	}

}
