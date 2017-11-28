package oj344ReverseString;

public class ReverseStringRecursive {
	public String reverseString(String s) {
		int len = s.length();
		if(len <= 1) return s;
		String leftString = s.substring(0, len / 2);
		String rightString = s.substring(len / 2);
		return reverseString(rightString) + reverseString(leftString);
		
	}

}
