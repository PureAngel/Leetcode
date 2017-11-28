package oj047Permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 * @author Xueying Bai
 *
 */

public class Permutations2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> resultLists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		backtrack(resultLists, list, nums, used);
		return resultLists;
	}
	
	private void backtrack(List<List<Integer>> lists, List<Integer> tempList, int[] nums, boolean[] used) {
		if(tempList.size() == nums.length) {
			lists.add(new ArrayList<>(tempList));
		} else {
			for(int i = 0; i < nums.length; i++) {
				if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
					continue;
				} else {
					used[i] = true;
					tempList.add(nums[i]);
					backtrack(lists, tempList, nums, used);
					used[i] = false;
					tempList.remove(tempList.size() - 1);
				}
			}
			
		}
	}

}
