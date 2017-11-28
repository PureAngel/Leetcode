package oj039CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is: 
 * [
  [7],
  [2, 2, 3]
]
 * @author Xueying Bai
 *
 */

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> resultLists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(resultLists, list, candidates, target, 0);
		return resultLists;
	}
	
	private void backtrack(List<List<Integer>> lists, List<Integer> tempList, int[] candidates, int remains, int start) {
		if(remains < 0) return;
		if(remains == 0) {
			lists.add(new ArrayList<>(tempList));
		} else {
			for(int i = start; i < candidates.length; i++) {
				tempList.add(candidates[i]);
				backtrack(lists, tempList, candidates, remains - candidates[i], i);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
