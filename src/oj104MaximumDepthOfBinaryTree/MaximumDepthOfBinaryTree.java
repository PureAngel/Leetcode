package oj104MaximumDepthOfBinaryTree;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * @author Xueying Bai
 *
 */

// recursion
public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

}
