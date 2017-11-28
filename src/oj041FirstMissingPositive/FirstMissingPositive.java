package oj041FirstMissingPositive;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author Xueying Bai
 *
 */

public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		if(len == 0) return 1;
		int i = 0;
		while(i < nums.length) {
			if(nums[i] == i + 1 || nums[i] <= 0 || nums[i] >= nums.length) i++;
			else if (nums[i] != nums[nums[i] - 1]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			} else {
				i++;
			}
		}
		i = 0;
		for(; i < nums.length; i++) {
			if(nums[i] != i + 1) {
				return i + 1;
			}
		}
		return i + 1;
	}

}
