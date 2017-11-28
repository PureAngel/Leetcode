package oj241DifferentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, 
 * return all possible results 
 * from computing all the different possible ways to group numbers and operators. 
 * The valid operators are +, - and *.
 * 
 * Example 1
 * Input: "2-1-1".
 * 
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * 
 * Example 2
 * Input: "2*3-4*5"
 * 
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 * 
 * @author Xueying Bai
 *
 */

public class DifferentWaystoAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(c == '+' || c == '-' || c == '*') {
				String inputA = input.substring(0, i);
				String inputB = input.substring(i + 1);
				List<Integer> resultA = diffWaysToCompute(inputA);
				List<Integer> resultB = diffWaysToCompute(inputB);
				for(int a: resultA) {
					for(int b: resultB) {
						if(c == '+') {
							result.add(a + b);
						} else if (c == '-') {
							result.add(a - b);
						} else {
							result.add(a * b);
						}
					}
				}
			}
		}
		if(result.size() == 0) result.add(Integer.valueOf(input));
		return result;
	}

}
