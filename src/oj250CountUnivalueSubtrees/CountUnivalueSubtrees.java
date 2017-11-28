package oj250CountUnivalueSubtrees;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * 
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * 
 * For example:
 * Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.

 * @author Xueying Bai
 *
 */

public class CountUnivalueSubtrees {
	public int countUnivalSubtrees(TreeNode root) {
		int[] count = new int[1];
		isUnival(root, count);
		return count[0];
	}
	
	
	private boolean isUnival(TreeNode root, int[] count) {
		if(root == null) return true;
		boolean left = isUnival(root.left, count);
		boolean right = isUnival(root.right, count);
		if(left && right) {
			if(root.left != null && root.val != root.left.val 
					|| root.right != null && root.val != root.right.val) {
				return false;
			}
			count[0]++;
			return true;
		}
		return false;
	}

}
