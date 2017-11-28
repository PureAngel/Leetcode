package oj070ClimbingStairs;

// Iteration Version
// ÀûÓÃÁËFibonacci

public class ClimbingStairsIteration {
	public int climbStairs(int n) {
		if(n == 1 || n == 2) {
			return n;
		}
		int n1 = 1, n2 = 2;
		for(int i = 3; i <= n; i++) {
			int temp = n1 + n2;
			n1 = n2;
			n2 = temp;
		}
		return n2;
	}

}
