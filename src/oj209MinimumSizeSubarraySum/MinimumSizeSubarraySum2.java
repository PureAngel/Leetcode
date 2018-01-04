package oj209MinimumSizeSubarraySum;

// O(n)
public class MinimumSizeSubarraySum2 {
	public int minSubArrayLen(int s, int[] nums) {
		int len = nums.length;
		if(len == 0) return 0;
		int result = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;
		for(int i = 0; i < len; i++) {
			sum += nums[i];
			while(sum >= s) {
				result = Math.min(result, i - left + 1);
				sum -= nums[left++];
			}
		}
		
		if(result != Integer.MAX_VALUE) return result;
		return 0;
	}

}
