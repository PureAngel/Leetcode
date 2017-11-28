package oj018Sum4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S 
 * such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

 * @author Xueying Bai
 *
 */

public class Sum4 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int len = nums.length;
		if(nums == null || len < 4) return result;
		
		Arrays.sort(nums);
		
		if(nums[0] * 4 > target || nums[len - 1] * 4 < target) return result;
		
		int a;
		int max = nums[len - 1];
		for(int i = 0; i < len; i++) {
			a = nums[i];
			if(i > 0 && nums[i - 1] == a) {
				continue;
			}
			if(a + 3 * max < target) { // nums[i] is too small
				continue;
			}
			if(4 * a > target) { // nums[i] is too big
				break;
			}
			if(4 * a == target) {
				if(i < len - 3 && nums[i + 3] == a) {
					result.add(Arrays.asList(a, a, a, a));
				}
				break;
			}
			
			threeSum(nums, target - a, i + 1, len - 1, a, result);
		}
		return result;
	}
	
	private void threeSum(int[] nums, int target, int low, int high, int a, List<List<Integer>> list) {
		if(low + 1 >= high) return; // less than 3 elements
		
		int max = nums[high];
		if(3 * max < target || 3 * nums[low] > target) return;
		
		int b;
		for(int i = low; i < high - 1; i++) {
			b = nums[i];
			if(i > low && nums[i - 1] == b) {
				continue;
			}
			if(b + 2 * max < target) { // nums[i] is too small
				continue;
			}
			if(3 * b > target) {
				break;
			}
			if(3 * b == target) {
				if(i < high - 1 && nums[i + 2] == b) {
					list.add(Arrays.asList(a, b, b, b));
				}
				break;
			}
			
			twoSum(nums, target - b, i + 1, high, a, b, list);
		}
	}
	
	private void twoSum(int[] nums, int target, int low, int high, int a, int b, List<List<Integer>> list) {
		if(low >= high) return;
		
		int max = nums[high];
		if(2 * max < target || 2 * nums[low] > target) return;
		
		int i = low, j = high, sum, x;
		while (i < j) {
			sum = nums[i] + nums[j];
			if (sum == target) {
				list.add(Arrays.asList(a, b, nums[i], nums[j]));

				x = nums[i];
				while (++i < j && x == nums[i]) // avoid duplicate
					;
				x = nums[j];
				while (i < --j && x == nums[j]) // avoid duplicate
					;
			}
			if (sum < target)
				i++;
			if (sum > target)
				j--;
		}
	}

}
