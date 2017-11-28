package oj402RemoveKDigits;

import java.util.Stack;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Given a non-negative integer num represented as a string, 
 * remove k digits from the number so that the new number is the smallest possible.
 * 
 * Note:
 * The length of num is less than 10002 and will be ¡Ý k.
 * The given num does not contain any leading zero.
 * 
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 
 * which is the smallest.
 * 
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. 
 * Note that the output must not contain leading zeroes.
 * 
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * 
 * @author Xueying Bai
 *
 */

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		Stack<Integer> stack = new Stack<>();
		String result = "";
		for(int i = 0; i < num.length(); i++) {
			int number = num.charAt(i) - '0';
			while(!stack.isEmpty() && k > 0 && stack.peek() > number) {
				stack.pop();
				k--;
			}
			if(!stack.isEmpty() || number != 0) {
				stack.push(number);
			}
		}
		while(!stack.isEmpty() && k > 0) {
			stack.pop();
			k--;
		}
		int size = stack.size();
		for(int i = 0; i < size; i++) {
			result = stack.pop() + result;
		}
		if(result == "") return "0";
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new RemoveKDigits().removeKdigits("1432219", 3));
	}

}
