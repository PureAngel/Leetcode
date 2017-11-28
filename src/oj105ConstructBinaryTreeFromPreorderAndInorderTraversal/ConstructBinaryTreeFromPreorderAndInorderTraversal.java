package oj105ConstructBinaryTreeFromPreorderAndInorderTraversal;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * @author Xueying Bai
 *
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        return helper(preorder, 0, inorder, 0, inorder.length);
    }
    
    private TreeNode helper(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if(preStart >= preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = inStart;
        for(; i <= inEnd; i++) {
            if(inorder[i] == preorder[preStart]) {
                break;
            }
        }
        root.left = helper(preorder, preStart + 1, inorder, inStart, i - 1);
        root.right = helper(preorder, preStart + i - inStart + 1, inorder, i + 1, inEnd);
        return root;
    }

}
