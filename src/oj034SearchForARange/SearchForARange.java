package oj034SearchForARange;

/**
 * Given an array of integers sorted in ascending order, 
 * find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * @author Xueying Bai
 *
 */

public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while(low < high) {
			int mid = (low + high) / 2;
			if(nums[mid] < target) {
				low = mid + 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				int start = mid, end = mid;
				while(start > low) {
					if(nums[start - 1] == target) {
						start--;
					} else {
						break;
					}
				}
				while(end < high) {
					if(nums[end + 1] == target) {
						end++;
					} else {
						break;
					}
				}
				return new int[]{start, end};
			}
		}
		return new int[]{-1, -1};
	}

}
