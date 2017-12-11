package oj128LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

// Set
public class LongestConsecutiveSequence2 {
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		
		int result = 0;
		
		for(int num: nums) {
			if(!set.contains(num - 1)) {
				int current_long = 1;
				int current_num = num;
				
				while(set.contains(current_num + 1)) {
					current_long++;
					current_num++;
				}
				
				result = Math.max(result, current_long);
			}
		}
		
		return result;
	}

}
