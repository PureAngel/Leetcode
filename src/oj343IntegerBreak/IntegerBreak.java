package oj343IntegerBreak;

/**
 * Given a positive integer n, 
 * break it into the sum of at least two positive integers 
 * and maximize the product of those integers. 
 * Return the maximum product you can get.
 * 
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * 
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * 
 * @author Xueying Bai
 *
 */

public class IntegerBreak {
	public int integerBreak(int n) {
		int pro = 1;
		while(n > 10) {
			pro *= 3;
			n -= 3;
		}
		switch(n) {
		case 10: pro *= 36; // 3+3+4
		         break;
		case 9: pro *= 27;
		        break;
		case 8: pro *= 18; // 2+3+3
		        break;
		case 7: pro *= 12; // 2+2+3
		        break;
		case 6: pro *= 9; // 3+3
		        break;
		case 5: pro *= 6; // 3+2
		        break;
		case 4: pro *= 4; // 2+2
		        break;
		case 3: pro *= 2; // 1+2
		        break;
		case 2: pro *= 1; // 1+1
		}
		return pro;
	}

}
