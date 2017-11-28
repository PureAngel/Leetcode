package oj404SumOfLeftLeaves;

import java.util.Stack;

public class SumOfLeftLeavesIter {
	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null) return 0;
		int sum = 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node.left != null) {
				if(node.left.left == null && node.left.right == null) {
					sum += node.left.val;
				} else {
					stack.push(node.left);
				}
			}
			if(node.right != null) {
				if(node.right.left != null || node.right.right != null) {
					stack.push(node.right);
				}
			}
		}
		return sum;
	}

}
