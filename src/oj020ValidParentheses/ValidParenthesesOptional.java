package oj020ValidParentheses;

import java.util.Stack;

public class ValidParenthesesOptional {
	public boolean isValid(String s) {
		char[] charArray = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for(Character character: charArray) {
			if(character == '(') {
				stack.push(')');
			} else if (character == '[') {
				stack.push(']');
			} else if (character == '{') {
				stack.push('}');
			} else if (stack.size() == 0 || stack.pop() != character) {
				return false;
			}
		}
		if(stack.size() != 0) {
			return false;
		}
		return true;
	}

}
