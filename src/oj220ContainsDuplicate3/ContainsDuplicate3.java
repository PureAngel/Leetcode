package oj220ContainsDuplicate3;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, 
 * find out whether there are two distinct indices i and j in the array 
 * such that the absolute difference between nums[i] and nums[j] is at most t 
 * and the absolute difference between i and j is at most k.
 * 
 * @author Xueying Bai
 *
 */

public class ContainsDuplicate3 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums.length < 2) return false;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			} else {
				if(i - map.get(nums[i]) > k) {
					continue;
				} else {
					if()
				}
			}
		}
	}

}
