package oj110BalancedBinaryTree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, 
 * a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * @author Xueying Bai
 *
 */

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		if(Math.abs(height(root.left) - height(root.right)) > 1) return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	private int height(TreeNode root) {
		if(root == null) return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

}
