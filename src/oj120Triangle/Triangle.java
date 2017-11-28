package oj120Triangle;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, 
where n is the total number of rows in the triangle.

 * @author Xueying Bai
 *
 */

// Bottom up DP
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int len = triangle.size(); // rows
		int[] sum = new int[triangle.get(len - 1).size()];
		for(int i = 0; i < sum.length; i++) {
			sum[i] = triangle.get(len - 1).get(i);
		}
		for(int i = 1; i < len; i++) {
			for(int j = 0; j < sum.length - i; j++) {
				sum[j] = triangle.get(len - i - 1).get(j) + Math.min(sum[j], sum[j + 1]);
			}
		}
		return sum[0];
	}

}
