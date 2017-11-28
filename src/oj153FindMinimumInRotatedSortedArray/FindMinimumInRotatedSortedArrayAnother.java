package oj153FindMinimumInRotatedSortedArray;

public class FindMinimumInRotatedSortedArrayAnother {
	public int findMin(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		int len = nums.length;
		int start = 0, end = len - 1;
		while(start < end) {
			int mid = (start + end) / 2;
			if(nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			} 
			if(nums[mid] > nums[start] && nums[mid] > nums[end]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return nums[start];
	}

}
