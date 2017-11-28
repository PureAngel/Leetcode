package oj268MissingNumber;

public class MissingNumberUsingSum {
	public int missingNumber(int[] nums) {
		int len = nums.length;
		int sum = (0 + len) * (len + 1) / 2; // �ǵ�Ҫ����len+1������len
		for(int i = 0; i < len; i++) {
			sum -= nums[i];
		}
		return sum;
	}

}
