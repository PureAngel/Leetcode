package oj043MutiplyStrings;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Given two non-negative integers num1 and num2 represented as strings, 
 * return the product of num1 and num2.
 * 
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * @author Xueying Bai
 *
 */

public class MutiplyStrings {
	public String multiply(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();
		int[] product = new int[len1 + len2];
		for(int i = len1 - 1; i >= 0; i--) {
			for(int j = len2 - 1; j >= 0; j--) {
				int pro = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p = i + j, q = i + j + 1;
				int sum = product[q] + pro;
				product[q] = sum % 10;
				product[p] += sum / 10;
			}
		}

		String result = "";
		for(int i = 0; i < product.length; i++) {
			if(!(result.length() ==0 && product[i] == 0)) {
				result += product[i];
			}
		}
		if(result.length() == 0) return "0";
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new MutiplyStrings().multiply("1", "1"));
	}

}
