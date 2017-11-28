package oj107BinaryTreeLevelOrderTraversal2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *  3
   / \
  9  20
    /  \
   15   7
 return its bottom-up level order traversal as:
 [
  [15,7],
  [9,20],
  [3]
]
 * @author Xueying Bai
 *
 */

public class BinaryTreeLevelOrderTraversal2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<>();
		levelMaker(lists, root, 0);
		return lists;
	}
	
	private void levelMaker(List<List<Integer>> lists, TreeNode root, int level) {
		if(root == null) return;
		if(level >= lists.size()) {
			lists.add(0, new ArrayList<Integer>());
		}
		levelMaker(lists, root.left, level + 1);
		levelMaker(lists, root.right, level + 1);
		lists.get(lists.size() - level - 1).add(root.val);
	}

}
