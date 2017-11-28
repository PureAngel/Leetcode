package oj059SpiralMatrix2;

/**
 * Given an integer n, 
 * generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example,
 * Given n = 3,
 * 
 * You should return the following matrix:
 * [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 * @author Xueying Bai
 *
 */

public class SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int left = 0, top = 0;
		int right = n - 1, down = n -1;
		int count = 1;
		while(left <= right) {
			for(int i = left; i <= right; i++) {
				result[top][i] = count++;
			}
			top++;
			for(int i = top; i <= down; i++) {
				result[i][right] = count++;
			}
			right--;
			for(int i = right; i >= left; i--) {
				result[down][i] = count++;
			}
			down--;
			for(int i = down; i >= top; i--) {
				result[i][left] = count++;
			}
			left++;
		}
		return result;
	}

}
