package oj102BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *  3
   / \
  9  20
    /  \
   15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * @author Xueying Bai
 *
 */

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if(root == null) {
			return lists;
		}
		list.add(root.val);
		lists.add(list);
		
		List<List<Integer>> left = levelOrder(root.left);
		List<List<Integer>> right = levelOrder(root.right);
		
		for(int i = 0; i < left.size() || i < right.size(); i++) {
			List<Integer> item = new ArrayList<>();
			if(i < left.size()) {
				for(Integer k: left.get(i)) {
					item.add(k);
				}
			}
			if(i < right.size()) {
				for(Integer k: right.get(i)) {
					item.add(k);
				}
			}
			lists.add(item);
		}
		return lists;
	}

}
