package oj078Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,3], a solution is:
 * [
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author Xueying Bai
 *
 */

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> resultLists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(resultLists, list, nums, 0);
		return resultLists;
	}
	
	private void backtrack(List<List<Integer>> lists, List<Integer> tempList, int[] nums, int start) {
		lists.add(new ArrayList<>(tempList));
		for(int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(lists, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

}
