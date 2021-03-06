package oj280WiggleSort;

import java.util.Arrays;

/**
 * Given an unsorted array nums, 
 * reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * 
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 * 
 * @author Xueying Bai
 *
 */
// O(nlogn)
public class WiggleSort {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		for(int i = 1; i < nums.length - 1; i += 2) {
			int temp = nums[i];
			nums[i] = nums[i + 1];
			nums[i + 1] = temp;
		}
	}

}
