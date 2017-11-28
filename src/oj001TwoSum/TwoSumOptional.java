package oj001TwoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumOptional {
	public int[] twoSum(int[] nums, int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // num, index
		for(int i = 0; i < nums.length; i++){
			Integer index = map.get(target - nums[i]);
			if(index == null){
				map.put(nums[i], i);
			} else {
				if(i < index){
					return new int[]{i, index};
				} else {
					return new int[]{index, i};
				}
				
			}
		}
		return new int[]{0, 0};
	}
	
	public static void main(String[] args) {
		TwoSumSolution twoSumSolution = new TwoSumSolution();
		int[] nums = {3, 2, 4};
		int target = 6;
		int[] result = twoSumSolution.twoSum(nums, target);
		System.out.println(result[0]+","+result[1]);
	}

}
