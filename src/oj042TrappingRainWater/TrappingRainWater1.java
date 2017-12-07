package oj042TrappingRainWater;

/**
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author Xueying Bai
 *
 */

public class TrappingRainWater1 {
	public int trap(int[] height) {
		int water = 0;
		for(int i = 1; i < height.length - 1; i++) {
			int max_left = 0, max_right = 0;
			
			// search for the left bar
			for(int j = i; j >= 0; j--) {
				max_left = Math.max(max_left, height[j]);
			}
			// search for the right bar
			for(int j = i; j < height.length; j++) {
				max_right = Math.max(max_right, height[j]);
			}
			
			water += Math.min(max_left, max_right) - height[i];
		}
		return water;
	}

}
