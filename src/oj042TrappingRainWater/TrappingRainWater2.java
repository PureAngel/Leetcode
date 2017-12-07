package oj042TrappingRainWater;

// DP
public class TrappingRainWater2 {
	public int trap(int[] height) {
		int water = 0;
		if(height == null || height.length == 0) return water;
		int len = height.length;
		int[] left = new int[len];
		int[] right = new int[len];
		
		// record left bar
		left[0] = height[0];
		for(int i = 1; i < len; i++) {
			left[i] = Math.max(left[i - 1], height[i]);
		}
		
		// record right bar
		right[len - 1] = height[len - 1];
		for(int i = len - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i]);
		}
		
		for(int i = 1; i < len - 1; i++) {
			water += Math.min(left[i], right[i]) - height[i];
		}
		return water;
	}

}
