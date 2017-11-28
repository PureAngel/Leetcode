package oj167TwoSum2;

public class TwoSum2Another {
	public int[] twoSum(int[] numbers, int target) {
		int low = 0, high = numbers.length - 1;
		while(numbers[low] + numbers[high] != target) {
			if(numbers[low] + numbers[high] < target) {
				low++;
			} else {
				high--;
			}
		}
		return new int[]{low + 1, high + 1};
	}

}
