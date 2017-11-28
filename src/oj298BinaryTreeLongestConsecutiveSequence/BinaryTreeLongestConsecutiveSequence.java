package oj298BinaryTreeLongestConsecutiveSequence;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * 
 * The path refers to any sequence of nodes from some starting node to any node in the tree 
 * along the parent-child connections. 
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 * 
 * For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

 * @author Xueying Bai
 *
 */

public class BinaryTreeLongestConsecutiveSequence {
	int max = 0;
	public int longestConsecutive(TreeNode root) {
		if(root == null) return 0;	
		longestConsecutive(root, 0, root.val);
		return max;
	}
	
	private void longestConsecutive(TreeNode root, int cur, int start) {
		if(root == null) return;
		if(root.val == start) {
			cur++;
		} else {
			cur = 1;
		}
		max = Math.max(cur, max);
		longestConsecutive(root.left, cur, root.val + 1);
		longestConsecutive(root.right, cur, root.val + 1);
	}

}
