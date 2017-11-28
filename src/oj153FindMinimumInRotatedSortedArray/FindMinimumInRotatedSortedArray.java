package oj153FindMinimumInRotatedSortedArray;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author Xueying Bai
 *
 */

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		return findMin(nums, 0, nums.length - 1);
	}
	
	private int findMin(int[] nums, int start, int end) {
		if(start >= end) return nums[start];
		if(nums[start] < nums[end]) return nums[start];
		int mid = (start + end) / 2;
		if(nums[mid] > nums[mid + 1]) {
			return nums[mid + 1];
		} else {
			return Math.min(findMin(nums, start, mid), findMin(nums, mid + 1, end));
		}
	}

}
