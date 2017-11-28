package oj073SetMatrixZeroes;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * 
 * @author Xueying Bai
 *
 */

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		boolean rowB = false;
		boolean colB = false;
		for(int i = 0; i < rowLen; i++) {
			for(int j = 0; j < colLen; j++) {
				if(matrix[i][j] == 0) {
					if(i == 0) rowB = true;
					if(j == 0) colB = true;
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i = 1; i < rowLen; i++) {
			for(int j = 1; j < colLen; j++) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
		if(rowB) {
			for(int j = 0; j < colLen; j++) {
				matrix[0][j] = 0;
			}
		}
		
		if(colB) {
			for(int i = 0; i < rowLen; i++) {
				matrix[i][0] = 0;
			}
		}
	}

}
