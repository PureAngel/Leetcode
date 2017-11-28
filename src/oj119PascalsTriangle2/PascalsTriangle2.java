package oj119PascalsTriangle2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author Xueying Bai
 *
 */

public class PascalsTriangle2 {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> row = new ArrayList<>();
		for(int i = 0; i < rowIndex + 1; i++) {
			row.add(1);
			for(int j = i - 1; j > 0; j--) {
				row.set(j, row.get(j - 1) + row.get(j));
			}
		}
		return row;
	}

}
