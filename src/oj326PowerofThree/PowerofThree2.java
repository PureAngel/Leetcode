package oj326PowerofThree;

/**
 * We can use mathematics as follows
 * 
 * n=3ii=log3(n)i=logb(n)logb(3)
 * n=3ii=log3(n)i=logb(n)logb(3)
 * n is a power of three if and only if i is an integer. 
 * In Java, we check if a number is an integer by taking the decimal part (using % 1) 
 * and checking if it is 0.
 * 
 * @author Xueying Bai
 *
 */
public class PowerofThree2 {
	public boolean isPowerOfThree(int n) {
		return (Math.log10(n) / Math.log10(3)) % 1 == 0;
	}

}
