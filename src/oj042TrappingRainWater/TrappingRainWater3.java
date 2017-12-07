package oj042TrappingRainWater;

import java.util.Stack;


// use stack
public class TrappingRainWater3 {
	public int trap(int[] height) {
		int water = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < height.length; i++) {
			while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
				int top = stack.pop(); // current right bar
				if(stack.isEmpty()) break;
				int distance = i - stack.peek() - 1;
				int h = Math.min(height[i], height[stack.peek()]) - height[top];
				water += distance * h;
			}
			stack.push(i);
		}
		return water;
	}

}
