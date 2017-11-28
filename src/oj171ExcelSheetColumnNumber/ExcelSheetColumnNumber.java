package oj171ExcelSheetColumnNumber;

/**
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 *  A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 

 * @author Xueying Bai
 *
 */

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		int len = s.length();
		int i = 0;
		int columnNum = 0;
		while(i < len) {
			columnNum *= 26;
			columnNum += s.charAt(i) - 'A' + 1;
			i++;
		}
		return columnNum;
	}

}
