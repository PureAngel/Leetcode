package oj046Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * @author Xueying Bai
 *
 */

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> resultLists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		backtrack(resultLists, list, nums);
		return resultLists;
	}
	
	private void backtrack(List<List<Integer>> lists, List<Integer> tempList, int[] nums) {
		if(tempList.size() == nums.length) {
			lists.add(new ArrayList<>(tempList));
		} else {
			for(int i = 0; i < nums.length; i++) {
				if(tempList.contains(nums[i])) {
					continue;
				} // skip already contains
				tempList.add(nums[i]);
				backtrack(lists, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
		
	}

}
