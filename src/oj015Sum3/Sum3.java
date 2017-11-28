package oj015Sum3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
	public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++){
			for(int j = i + 1; j < nums.length - 1; j++){
				for(int k = j + 1; k < nums.length; k++){
					if(nums[i] + nums[j] + nums[k] == 0){
						List<Integer> tempList = new ArrayList<>();
						tempList.add(nums[i]);
						tempList.add(nums[j]);
						tempList.add(nums[k]);
						if(!list.contains(tempList)){
							list.add(tempList);
						}
						
					}
				}
			}
		}
		return list;
	}

}
