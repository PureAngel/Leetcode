package oj013RomanToInteger;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author Xueying Bai
 *
 */

public class RomanToInteger {
	int carry(char c) {
		switch(c) {
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		}
		return 0;
	}
	public int romanToInt(String s) {
		int result = 0;
		int len = s.length();
		char temp = 'I';
		for(int i = len - 1; i >= 0; i--) {
			if(carry(s.charAt(i)) >= carry(temp)) {
				result += carry(s.charAt(i));
				temp = s.charAt(i);
			} else {
				result -= carry(s.charAt(i));
			}
		}
		return result;
	}

}
