package oj167TwoSum2;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>(); // num, index
		int i = 0;
		while(i < numbers.length) {
			Integer index = map.get(target - numbers[i]);
			if(index == null) {
				map.put(numbers[i], i);
			} else {
				if(i < index) {
					return new int[]{i + 1, index + 1};
				} else {
					return new int[]{index + 1, i + 1};
				}
			}
			i++;
		}
		return new int[]{0, 0};
	}

}
