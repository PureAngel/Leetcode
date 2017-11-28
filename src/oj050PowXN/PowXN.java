package oj050PowXN;

/**
 * Implement pow(x, n).
 * 
 * @author Xueying Bai
 *
 */
// ×¢Òâ-2147483648, -n³¬ÏÞ
public class PowXN {
	public double myPow(double x, int n) {
		if(n == 0) return 1;
		if(n < 0) {
			return 1 / x * myPow(1 / x, -(n + 1));
		}
		if(n % 2 == 0) {
			return myPow(x * x, n / 2);
		} else {
			return myPow(x * x, n / 2) * x;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new PowXN().myPow(2.00000, -2147483648));
	}

}
