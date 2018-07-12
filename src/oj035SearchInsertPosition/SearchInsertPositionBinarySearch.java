package oj035SearchInsertPosition;

public class SearchInsertPositionBinarySearch {
	public int searchInsert(int[] nums, int target) {
	    if(nums.length == 0 || nums[0] > target) {
                return 0;
            }
            if(nums[nums.length - 1] < target) {
                return nums.length;
            }
		int low = 0;
		int high = nums.length - 1;
		while(low < high) {
			int mid = (low + high) / 2;
			if(nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

}
