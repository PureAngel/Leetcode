package oj204CountPrimes;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * @author Xueying Bai
 *
 */
// Runtime Error
public class CountPrimes {
	public int countPrimes(int n) {
		if(n < 2) return 0;
		return isPrime(n) ? countPrimes(n - 1) + 1 : countPrimes(n - 1);
	}
	
	private boolean isPrime(int n) {
		if(n == 2) return true;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
