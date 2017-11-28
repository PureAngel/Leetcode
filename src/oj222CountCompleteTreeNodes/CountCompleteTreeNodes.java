package oj222CountCompleteTreeNodes;

/**
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, 
 * is completely filled, and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * 
 * @author Xueying Bai
 *
 */

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if(leftHeight == rightHeight) {
			return (1 << leftHeight) + countNodes(root.right); // 1 + 2(leftHeight) - 1 + countNodes(root.right)
		} else {
			return (1 << rightHeight) + countNodes(root.left);
		}
	}
	
	private int height(TreeNode root) {
		if(root == null) return 0;
		return 1 + height(root.left);
	}

}
