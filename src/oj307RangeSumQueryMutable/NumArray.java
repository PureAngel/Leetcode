package oj307RangeSumQueryMutable;

/**
 * Given an integer array nums, 
 * find the sum of the elements between indices i and j (i ¡Ü j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * 
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 * 
 * @author Xueying Bai
 *
 */

public class NumArray {
	int[] sum;
	int[] nums;
    public NumArray(int[] nums) {
    	this.nums = nums;
        sum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
        	sum[i + 1] = sum[i] + nums[i];
        }
    }
    
    public void update(int i, int val) {
        for(int j = i + 1; j < sum.length + 1; j++) {
        	sum[j] = sum[j] - nums[i] + val;
        }
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
