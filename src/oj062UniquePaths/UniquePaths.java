package oj062UniquePaths;

/**
 * A robot is located at the top-left corner of a m x n grid 
 * (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * @author Xueying Bai
 *
 */

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		// C(m+n-2,m-1) = (m+n-2)!/(m-1)!(n-1)!
		int max = Math.max(m, n);
		double path = 1;
		int N = m + n - 2;
		int k = m - 1;
		for(int i = 1; i <= k; i++) {
			path = path * (N - k + i) / i;
		}
		return (int)path;
	}

}
