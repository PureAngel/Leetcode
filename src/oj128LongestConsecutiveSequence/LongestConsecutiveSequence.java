package oj128LongestConsecutiveSequence;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, 
 * find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author Xueying Bai
 *
 */

// Sort
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if(nums == null || nums.length < 1) return 0;
		
		Arrays.sort(nums);
		
		int result = 1;
		int current_long = 1;
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] != nums[i - 1]) {
				if(nums[i] == nums[i - 1] + 1) {
					current_long++;
				} else {
					result = Math.max(result, current_long);
					current_long = 1;
				}
			}		
		}
		
		result = Math.max(result, current_long);
		return result;
	}

}
