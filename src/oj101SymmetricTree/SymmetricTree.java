package oj101SymmetricTree;

/**
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *  1
   / \
  2   2
 / \ / \
3  4 4  3

 * @author Xueying Bai
 *
 */
// recursive 
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}
	
	private boolean isSymmetric(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) return true;
		if(root1 == null || root2 == null) return false;
		return (root1.val == root2.val) 
				&& isSymmetric(root1.left, root2.right) 
				&& isSymmetric(root1.right, root2.left);
	}

}
