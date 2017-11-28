package oj029DivideTwoIntegers;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 * @author Xueying Bai
 *
 */

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int result = 0;
		if(dividend == 0) return result;
		if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
		boolean isPositive = false;
		if(dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0) {
			isPositive = true;
		}
		long ldividend = Math.abs((long)dividend);
		long ldivisor = Math.abs((long)divisor);
		while(ldividend >= ldivisor) {
			long temp = ldivisor, multiple = 1;
			while(ldividend >= (temp << 1)) {
				temp <<= 1;
				multiple <<= 1;
			}
			ldividend -= temp;
			result += multiple;
		}
		if(!isPositive) {
			result = -result;
		}
		return Math.min(Integer.MAX_VALUE, Math.max(Integer.MIN_VALUE, result));
	}

}
