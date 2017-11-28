package oj169MajorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than  n/2 times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * @author Xueying Bai
 *
 */

public class MajorityElement {
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>(); // num, count
		int len = nums.length;
		for(int i = 0; i < len; i++) {
			if(map.containsKey(nums[i])) {
				int newCount = map.get(nums[i]) + 1;
				if(newCount > len / 2) {
					return nums[i];
				} else {
					map.put(nums[i], map.get(nums[i])+1);
				}
			} else {
				map.put(nums[i], 1);
			}
		}
		return nums[0];
	}

}
