package oj106ConstructBinaryTreeFromInorderAndPostorderTraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * @author Xueying Bai
 *
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
	        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
	        Map<Integer, Integer> map = new HashMap<>();
	        for(int i = 0; i < inorder.length; i++) {
	            map.put(inorder[i], i);
	        }
			return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
	    }
	    
	    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> map) {
			if(postStart > postEnd || inStart > inEnd) return null;
			TreeNode root = new TreeNode(postorder[postEnd]);
	        int i = map.get(postorder[postEnd]);
			root.left = helper(inorder, postorder, inStart, i - 1, postStart, postStart - inStart + i - 1, map);
			root.right = helper(inorder, postorder, i + 1, inEnd, postStart - inStart + i, postEnd - 1, map);
			return root;
		}

}
