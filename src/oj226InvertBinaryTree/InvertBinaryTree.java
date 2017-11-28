package oj226InvertBinaryTree;

/**
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

 * @author Xueying Bai
 *
 */

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		TreeNode left = root.left;
		TreeNode right = root.right;
		if(left != null || right != null) {
			left = invertTree(left);
			right = invertTree(right);
			root.left = right;
			root.right = left;
		}
		return root;
	}

}
