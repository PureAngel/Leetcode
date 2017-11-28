package oj268MissingNumber;

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. 
 * Could you implement it using only constant extra space complexity?
 * 
 * @author Xueying Bai
 *
 */

public class MissingNumber {
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		int low = 0, high = nums.length;
		while(low < high) {
			int mid = (low + high) / 2;
			if(nums[mid] > mid) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

}
