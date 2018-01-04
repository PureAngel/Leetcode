package oj209MinimumSizeSubarraySum;

/**
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which the sum ¡Ý s. 
 * If there isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * More practice:
 * If you have figured out the O(n) solution, 
 * try coding another solution of which the time complexity is O(n log n).
 * 
 * @author Xueying Bai
 *
 */

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int len = nums.length;
		if(len == 0) return 0;
		int[] sums = new int[len + 1];
		int result = Integer.MAX_VALUE;
		for(int i = 1; i <= len; i++) {
			sums[i] = sums[i - 1] + nums[i - 1];
		}
		for(int i = 0; i < len; i++) {
			for(int j = i + 1; j <= len; j++) {
				int sum = sums[j] - sums[i];
				if(sum >= s) {
					result = Math.min(result, j - i);
					break;
				}
			}
		}
		
		if(result != Integer.MAX_VALUE) return result;
		return 0;
	}

}
