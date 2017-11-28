package oj283MoveZeroes;

/**
 * Given an array nums, 
 * write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
 * nums should be [1, 3, 12, 0, 0].
 * 
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * @author Xueying Bai
 *
 */

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int lastNonZero = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[lastNonZero];
				nums[lastNonZero] = temp;
				lastNonZero++;
			}
		}
	}

}
