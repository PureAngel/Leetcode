package oj075SortColors;

/**
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * @author Xueying Bai
 *
 */

public class SortColors {
	public void sortColors(int[] nums) {
		int i = 0, j = nums.length - 1, k = 0;
		while(k <= j) {
			if(nums[k] == 0) {
				nums[k] = nums[i];
				nums[i] = 0;
				i++;
			}
			if(nums[k] == 2) {
				nums[k] = nums[j];
				nums[j] = 2;
				j--;
                k--; // important!!!
			}
            k++;
		}
		
	}

}
