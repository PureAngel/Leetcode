package oj001TwoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumOptional2pass {
	public int[] twoSum(int[] nums, int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			map.put(nums[i], i);
		}
		
		for(int i = 0; i < nums.length; i++){
			int complement = target - nums[i];
			if(i != map.get(complement)){
				if(map.containsKey(complement)){
				return new int[]{i, map.get(complement)};
			}
			} 
		}
		throw new IllegalArgumentException("No two sum solution.");
	}

}
