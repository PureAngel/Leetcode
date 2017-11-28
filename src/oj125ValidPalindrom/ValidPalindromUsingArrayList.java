package oj125ValidPalindrom;

import java.util.ArrayList;
import java.util.List;

// 用一个ArrayList存储符合条件的字符，不进行倒序，直接比较

public class ValidPalindromUsingArrayList {
	public boolean isPalindrome(String s) {
		if(s.length() == 0) {
			return true;
		}
		s = s.toLowerCase();
		char[] charArr = s.toCharArray();
		List<Character> list = new ArrayList<>();
		for(char c: charArr) {
			if(c >= '0' && c <= '9' || c >= 'a' && c <= 'z') {
				list.add(c);
			}
		}
		int size = list.size();
		for(int i = 0; i < size; i++) {
			if(list.get(i) != list.get(size - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String string = "Live on evasions? No I save no evil.";
		String string2 = "ab";
		ValidPalindromUsingArrayList v = new ValidPalindromUsingArrayList();
		System.out.println(v.isPalindrome(string2));
	}

}
