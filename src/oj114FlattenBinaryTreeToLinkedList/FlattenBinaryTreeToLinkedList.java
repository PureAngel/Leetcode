package oj114FlattenBinaryTreeToLinkedList;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 *       1
        / \
       2   5
      / \   \
     3   4   6
Hints:
If you notice carefully in the flattened tree, 
each node's right child points to the next node of a pre-order traversal.

 * @author Xueying Bai
 *
 */

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		if(root == null) return;
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		root.left = null;
		
		flatten(left);
		flatten(right);
		
		root.right = left;
		TreeNode curNode = root;
		while(curNode.right != null) {
			curNode = curNode.right;
		}
		curNode.right = right;
	}

}
