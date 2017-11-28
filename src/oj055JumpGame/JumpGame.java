package oj055JumpGame;

/**
 * Given an array of non-negative integers, 
 * you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * @author Xueying Bai
 *
 */

public class JumpGame {
	public boolean canJump(int[] nums) {
		int lastPosition = nums.length - 1;
		for(int i = nums.length - 1; i >= 0; i--) {
			if(i + nums[i] >= lastPosition) {
				lastPosition = i;
			}
		}
		return lastPosition == 0;
	}

}
