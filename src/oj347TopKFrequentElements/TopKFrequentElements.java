package oj347TopKFrequentElements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), 
 * where n is the array's size.
 * 
 * @author Xueying Bai
 *
 */

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		
		List<Integer>[] bucket = new List[nums.length + 1];
		for(int num: map.keySet()) {
			int freq = map.get(num);
			if(bucket[freq] == null) {
				bucket[freq] = new LinkedList<>();
			} 
			bucket[freq].add(num); //!!!注意无论空不空都要把num加进去！！！
		}
		for(int i = bucket.length - 1; i > 0 && k > 0; i--) {
			if(bucket[i] != null){
				List<Integer> list = bucket[i];
				result.addAll(list);
				k -= list.size();
			}
		}
		return result;
	}

}
