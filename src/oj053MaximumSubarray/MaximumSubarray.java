package oj053MaximumSubarray;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * @author Xueying Bai
 *
 */

// DP sulution
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if(nums.length == 0) return 0;
		int[] maxSum = new int[nums.length];
		maxSum[0] = nums[0];
		int max = maxSum[0];
		for(int i = 1; i < nums.length; i++) {
			if(maxSum[i - 1] < 0) {
				maxSum[i] = nums[i];
			} else {
				maxSum[i] = maxSum[i - 1] + nums[i];
			}
			if(max < maxSum[i]) max = maxSum[i];
		}
		return max;
	}

}
