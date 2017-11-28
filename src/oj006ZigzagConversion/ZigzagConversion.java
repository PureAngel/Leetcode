package oj006ZigzagConversion;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 * @author Xueying Bai
 *
 */

public class ZigzagConversion {
	public String convert(String s, int numRows) {
		int len = s.length();
		char[] c = s.toCharArray();
		StringBuffer[] sb = new StringBuffer[numRows];
		for(int i = 0; i < numRows; i++) sb[i] = new StringBuffer();
		
		int i = 0;
		while(i < len) {
			for(int index = 0; index < numRows && i < len; index++) {
				sb[index].append(c[i++]);
			}
			for(int index = numRows - 2; index >= 1 && i < len; index--) {
				sb[index].append(c[i++]);
			}
		}
		for(int index = 1; index < sb.length; index++) {
			sb[0].append(sb[index]);
		}
		return sb[0].toString();
	}

}
