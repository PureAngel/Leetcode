package oj131PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return
 * [
  ["aa","b"],
  ["a","a","b"]
]
 * @author Xueying Bai
 *
 */

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> resultLists = new ArrayList<>();
		List<String> list = new ArrayList<>();
		backtrack(resultLists, list, s, 0);
		return resultLists;
	}
	
	private void backtrack(List<List<String>> lists, List<String> tempList, String s, int start) {
		if(start == s.length()) {
			lists.add(new ArrayList<>(tempList));
		} else {
			for(int i = start; i < s.length(); i++) {
				if(isPalindrome(s, start, i)) {
					tempList.add(s.substring(start, i + 1));
					backtrack(lists, tempList, s, i + 1);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}
	
	private boolean isPalindrome(String s, int low, int high) {
		while(low < high) {
			if(s.charAt(low) != s.charAt(high)) {
				return false;
			}
			low++;
			high--;
		}
		return true;
	}

}
