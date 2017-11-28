package oj367ValidPerfectSquare;

/**
 * Given a positive integer num, 
 * write a function which returns True if num is a perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * Input: 16
 * Returns: True
 * 
 * Example 2:
 * Input: 14
 * Returns: False
 * 
 * @author Xueying Bai
 *
 */
// a square num = 1+3+5+...
public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		int i = 1;
		while(num > 0) {
			num -= i;
			i += 2;
		}
		if(num == 0) {
			return true;
		} else {
			return false;
		}
	}

}
