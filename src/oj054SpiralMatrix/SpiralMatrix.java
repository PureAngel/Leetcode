package oj054SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral order.
 * 
 * For example,
 * Given the following matrix:
 * [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

 * @author Xueying Bai
 *
 */

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
		int m = matrix.length;
		int n = matrix[0].length;
		int top = 0, left = 0;
		int down = m - 1, right = n - 1;
		while(left <= right && top <= down) {
			for(int i = left; i <= right; i++) {
				result.add(matrix[top][i]);
			}
			
			for(int i = top + 1; i <= down; i++) {
				result.add(matrix[i][right]);
			}
			if(left < right && top < down) {
				for(int i = right - 1; i >= left; i--) {
					result.add(matrix[down][i]);
				}
				for(int i = down; i > top; i--) {
					result.add(matrix[i][left]);
				}
			}
			top++;
			right--;
			down--;
			left++;
		}
		
		return result;
	}

}
