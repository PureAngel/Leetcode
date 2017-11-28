package oj064MinimumPathSum;

/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right 
 * which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author Xueying Bai
 *
 */

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(i == 0 && j == 0) {
					continue;
				} else if (i == 0) {
					grid[i][j] += grid[i][j - 1];
				} else if (j == 0) {
					grid[i][j] += grid[i - 1][j];
				} else {
					grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
				}
			}
		}
		return grid[rows - 1][cols - 1];
	}

}
