package oj009PalindromeNumber;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

 * @author Xueying Bai
 *
 */

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x < 0 || x % 10 == 0 && x != 0) return false;
		
		int reversedNum = 0;
		while(x > reversedNum) {
			reversedNum = reversedNum * 10 + x % 10;
			x /= 10;
		}
		
		return reversedNum == x || x == reversedNum / 10;
	}

}
