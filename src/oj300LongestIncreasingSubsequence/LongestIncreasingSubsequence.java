package oj300LongestIncreasingSubsequence;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
 * Note that there may be more than one LIS combination, 
 * it is only necessary for you to return the length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * @author Xueying Bai
 *
 */

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int numsLen = nums.length;
		if(numsLen == 0 || numsLen == 1) return numsLen;
		int result = 1;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for(int i = 1; i < nums.length; i++) {
			int maxLen = 0;
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					maxLen = Math.max(maxLen, dp[j]);
				}
			}
			dp[i] = maxLen + 1;
			result = Math.max(result, dp[i]);
		}
		return result;
	}

}
