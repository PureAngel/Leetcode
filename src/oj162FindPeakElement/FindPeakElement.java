package oj162FindPeakElement;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] �� num[i+1], find a peak element and return its index.
 * 
 * The array may contain multiple peaks,
 * in that case return the index to any one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -��.
 * 
 * For example,
 * in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * 
 * Note:
 * Your solution should be in logarithmic complexity.
 * 
 * @author Xueying Bai
 *
 */

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		return findPeakElement(nums, 0, nums.length - 1);
	}
	
	private int findPeakElement(int[] nums, int start, int end) {
		if(start == end) return start;
		int mid = (start + end) / 2;
		if(nums[mid] > nums[mid + 1]) {
			return findPeakElement(nums, start, mid);
		} else {
			return findPeakElement(nums, mid + 1, end);
		}
	}

}
