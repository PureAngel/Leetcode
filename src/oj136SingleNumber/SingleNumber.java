package oj136SingleNumber;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 * 
 * @author Xueying Bai
 *
 */

public class SingleNumber {
	public int singleNumber(int[] nums) {
        int a = nums[0];
		for(int i = 1; i < nums.length; i++) {
			a = a ^ nums[i];
		}
		return a;
    }

}
