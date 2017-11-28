package oj098ValidBST;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * @author Xueying Bai
 *
 */

// recursion
public class ValidBST {
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;
		if(root.left != null) {
			TreeNode left = root.left;
			while(left.right != null) {
				left = left.right;
			}
			if(left.val >= root.val) return false;
		}
		if(root.right != null) {
			TreeNode right = root.right;
			while(right.left != null) {
				right = right.left;
			}
			if(right.val <= root.val) return false;
		}
		return isValidBST(root.left) && isValidBST(root.right);
	}

}
