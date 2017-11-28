package oj017LetterCombinationsOfAPhoneNumber;

import java.util.LinkedList;
import java.util.List;


/**
 * Given a digit string, 
 * return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * 1       2(abc) 3(def)
 * 4(ghi)  5(jkl) 6(mno)
 * 7(pqrs) 8(tuv) 9(wxyz)
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note:
 * Although the above answer is in lexicographical order, 
 * your answer could be in any order you want.
 * 
 * @author Xueying Bai
 *
 */

public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
		LinkedList<String> result = new LinkedList<>();
		String[] keys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		result.add("");
		for(int i = 0; i < digits.length(); i++) {
			int index = digits.charAt(i) - '0'; // number
			while(result.peek().length() == i) {
				String temp = result.poll();
				for(char c: keys[index].toCharArray()) {
					result.add(temp + c);
				}
			}
		}
		if(result.peek() == "") result.poll();
		return result;
	}

}
