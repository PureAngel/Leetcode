package oj077Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 * @author Xueying Bai
 *
 */

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		combine(result, new ArrayList<Integer>(), n, k, 1);
		return result;
	}
	
	private void combine(List<List<Integer>> lists, List<Integer> list, int n, int k, int start) {
		if(k == 0) {
			lists.add(new ArrayList(list));
			return;
		}
		for(int i = start; i <= n; i++) {
			list.add(i);
			combine(lists, list, n, k - 1, i + 1);
			list.remove(list.size() - 1);
		}
	}

}
