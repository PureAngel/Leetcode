package oj239SlidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array nums, 
 * there is a sliding window of size k 
 * which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. 
 * Each time the sliding window moves right by one position.
 * 
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 �� k �� input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

 * @author Xueying Bai
 *
 */

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k <= 0) return new int[0];
		int len = nums.length;
		int[] maxWindow = new int[len - k + 1];
		int index = 0;
		Deque<Integer> deque = new LinkedList<>(); // record the index of nums
		for(int i = 0; i < len; i++) {
			// remove number out of window
			while(!deque.isEmpty() && deque.peek() < i - k + 1) {
				deque.poll();
			}
			
			// remove smaller numbers in k range 
			while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			
			deque.offer(i);
			
			if(i >= k - 1) {
				maxWindow[index] = nums[deque.peek()];
				index++;
			}
		}
		return maxWindow;
	}

}
