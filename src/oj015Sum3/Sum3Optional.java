package oj015Sum3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum3Optional {
	public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		
		Arrays.sort(nums); // sort the array
		
		// 对nums中的每一个数，value为这个数的所有index的list
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i < nums.length; i++){
			int num = nums[i];
			if(map.get(num) == null){
				List<Integer> tempList = new ArrayList<>();
				tempList.add(i);
				map.put(num, tempList);
			} else {
				map.get(num).add(i);
			}
		}
		
		for(int i = 0; i < nums.length - 2; i++){
			if(nums[i] > 0){
				break;
			}
			
			if(i > 0 && nums[i - 1] == nums[i]){
				continue;
			}
			
			for(int j = i + 1; j < nums.length - 1; j++){
				if(j > i + 1 && nums[j - 1] == nums[j]){
					continue;
				}
				
				int finalNum = -nums[i] - nums[j];
				if(finalNum < nums[j]){
					break;
				}
				List<Integer>tempList = map.get(finalNum);
				if(tempList == null){
					continue;
				}
				for(Integer integer: tempList){
					if(integer != i && integer != j){
						List<Integer> myList = new ArrayList<>();
						myList.add(nums[i]);
						myList.add(nums[j]);
						myList.add(nums[integer]);
						list.add(myList);
						break;
					}
				}
			}
		}
		return list;
	}

}
