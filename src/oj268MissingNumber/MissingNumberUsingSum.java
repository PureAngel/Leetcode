package oj268MissingNumber;

public class MissingNumberUsingSum {
	public int missingNumber(int[] nums) {
		int len = nums.length;
		int sum = (0 + len) * (len + 1) / 2; // 记得要乘上len+1而不是len
		for(int i = 0; i < len; i++) {
			sum -= nums[i];
		}
		return sum;
	}

}
