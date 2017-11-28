package oj020ValidParentheses;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
	public boolean isValid(String s) {
		char[] charArray = s.toCharArray();
		List<Character> list = new ArrayList<>();
		for(Character character: charArray){
			if(character == '(' || character == '[' || character =='{'){
				list.add(character);
			} else {
				if(list.size() == 0){
					return false;
				}
				if(character == ')' && list.get(list.size() - 1) != '('){
					return false;
				} else if (character == ']' && list.get(list.size() - 1) != '[') {
					return false;
				} else if (character == '}' && list.get(list.size() - 1) != '{') {
					return false;
				}
				list.remove(list.size() - 1);
			}
		}
		if(list.size() != 0) {
			return false;
		}
		return true;
	}

}
