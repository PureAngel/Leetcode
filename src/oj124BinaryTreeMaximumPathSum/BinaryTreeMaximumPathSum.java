package oj124BinaryTreeMaximumPathSum;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem,
 * a path is defined as any sequence of nodes 
 * from some starting node to any node in the tree along the parent-child connections. 
 * The path must contain at least one node and does not need to go through the root.
 * 
 * For example:
 * Given the below binary tree,
 *        1
 *       / \
 *      2   3
 * Return 6.
 *      
 * @author Xueying Bai
 *
 */

public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
		maxDownSum(root);
		return max;
	}
	
	private int maxDownSum(TreeNode root) {
		if(root == null) return 0;
		int left_sum = Math.max(0, maxDownSum(root.left));
		int right_sum = Math.max(0, maxDownSum(root.right));
		max = Math.max(max, left_sum + right_sum + root.val);
		return Math.max(left_sum, right_sum) + root.val;
	}

}
