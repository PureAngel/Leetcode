package oj035SearchInsertPosition;

/**
 * Given a sorted array and a target value, 
 * return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 �� 2
 * [1,3,5,6], 2 �� 1
 * [1,3,5,6], 7 �� 4
 * [1,3,5,6], 0 �� 0
 * 
 * @author Xueying Bai
 *
 */

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		if(nums.length == 0 || nums[0] >= target) return 0;
		int i = 1;
		for(; i < nums.length; i++) {
			if(target <= nums[i]) {
				return i;
			}
		}
		return i;
	}

}
