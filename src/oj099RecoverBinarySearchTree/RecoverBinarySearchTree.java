package oj099RecoverBinarySearchTree;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note:
 * A solution using O(n) space is pretty straight forward. 
 * Could you devise a constant space solution?
 * 
 * @author Xueying Bai
 *
 */

public class RecoverBinarySearchTree {
	TreeNode firstNode = null;
	TreeNode secondNode = null;
	TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root) {
		// in-order traverse the tree to find out the two nodes
		inorderTraverse(root);
		
		// swap the two nodes
		int temp = firstNode.val;
		firstNode.val = secondNode.val;
		secondNode.val = temp;
	}
	
	private void inorderTraverse(TreeNode root) {
		if(root == null) return;
		
		// left side
		inorderTraverse(root.left);
		
		// root
		if(firstNode == null && preNode.val >= root.val) {
			firstNode = preNode;
		}
		
		if(firstNode != null && preNode.val >= root.val) {
			secondNode = root;
		}
		
		preNode = root;
		
		// right side
		inorderTraverse(root.right);
	}

}
