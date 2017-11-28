package oj081SearchinRotatedSortedArray2;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Write a function to determine if a given target is in the array.
 * 
 * The array may contain duplicates.
 * 
 * @author Xueying Bai
 *
 */

public class SearchinRotatedSortedArray2 {
	public boolean search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		int mid;
		while(start <= end) {
			mid = (start + end) / 2;
			if(nums[mid] == target) {
				return true;
			} else if (nums[mid] > nums[start] || nums[mid] > nums[end]) { // left is sorted or right is unsorted
				if(target < nums[mid] && target >= nums[start]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (nums[mid] < nums[end] || nums[mid] < nums[start]) { // right is sorted or left is unsorted
				if(target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else { // nums[mid] = nums[start] = nums[end]
				start++; // or end--; (they're the same)
			}
		}
		return false;
	}

}
