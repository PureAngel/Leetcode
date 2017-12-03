package Contest61;

import sun.tools.jar.resources.jar;

/**
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9
Example 2:
Input: N = 1234
Output: 1234
Example 3:
Input: N = 332
Output: 299
Note: N is an integer in the range [0, 10^9].

 * @author Xueying Bai
 *
 */

public class MonotoneIncreasingDigits {
	public int monotoneIncreasingDigits(int N) {
		int[] digits = new int[10]; // 0:个位，1:十位，2:百位。。。
		int a = 1;
		for(int i = 0; i < 10; i++) {
			digits[i] = N / a % 10;
			a *= 10;
		}
		int i;
		for(i = 9; i >= 0; i--) {
			if(digits[i] != 0) break;
		}
		int[] result = new int[i + 1];
		int len = i;
		int res = 0;
		while(i > 0) {
			if(digits[i - 1] < digits[i]) {
				result[i] = digits[i] - 1;
				for(int k = 0; k < i; k++) {
					result[k] = 9;
				}
				for(int m = len; m >= 0; m--) {
					res *= 10;
					res += result[m];	
				}
				return res;
			} else if (digits[i - 1] == digits[i]) {
				int j;
				for(j = i - 2; j >= 0; j--) {
					if(digits[j] > digits[j + 1]) {
						result[i] = digits[i];
						i--;
						break;
					} else if (digits[j] < digits[j + 1]) {
						result[i] = digits[i] - 1;
						for(int k = 0; k < i; k++) {
							result[k] = 9;
						}
						for(int m = len; m >= 0; m--) {
							res *= 10;
							res += result[m];	
						}
						return res;
					}
				}
				if(j < 0) {
					result[i] = digits[i];
					i--;
				}
				
			} else {
				result[i] = digits[i];
				i--;
			}
		}
		result[0] = digits[0];
		for(int m = len; m >= 0; m--) {
			res *= 10;
			res += result[m];
		}
		return res;
	}

}
