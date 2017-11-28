package oj303RangeSumQueryImmutable;

public class NumArray2 {
	int[] sum;
    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
        	sum[i + 1] = sum[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

}
