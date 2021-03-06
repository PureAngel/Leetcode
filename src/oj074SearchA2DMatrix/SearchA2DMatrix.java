package oj074SearchA2DMatrix;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * For example,
 * Consider the following matrix:
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

 * @author Xueying Bai
 *
 */

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		int low = 0, high = rowLen * colLen - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			if(matrix[mid / colLen][mid % colLen] == target) {
				return true;
			} else if (matrix[mid / colLen][mid % colLen] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}

}
