package oj125ValidPalindrom;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * @author Xueying Bai
 *
 */

public class ValidPalindrom {
	public boolean isPalindrome(String s) {
		if(s.length() == 0) {
			return true;
		}
		s = s.toLowerCase(); //切记要赋值啊
		String newString = "";
		/*
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				newString = newString.concat(s.substring(i, i + 1)); // 切记要赋值啊
			}
		}
		*/
		
		// 正则大法好哇
		newString = s.replaceAll("[^a-z0-9]", "");
		
		// 以下，这不是傻了么
		/*
		int len = newString.length();
		String s1, s2;
		if(len % 2 == 0) {
			s1 = newString.substring(0, len / 2);
			s2 = newString.substring(len / 2);
		} else {
			s1 = newString.substring(0, len / 2);
			s2 = newString.substring(len / 2 + 1);
		}
		s2 = new StringBuffer(s2).reverse().toString();
		if(s1.equals(s2)) {
			return true;
		} else {
			return false;
		}
		*/
		return newString.equals(new StringBuffer(newString).reverse().toString());
	}
	
	
	public static void main(String[] args) {
		String string = "Live on evasions? No I save no evil.";
		String string2 = "ab";
		ValidPalindrom v = new ValidPalindrom();
		System.out.println(v.isPalindrome(string2));
	}
}
