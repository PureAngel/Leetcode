package oj113PathSum2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, 
 * find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *            5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

 * @author Xueying Bai
 *
 */

public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		pathSum(root, sum, lists, list);
		return lists;
	}
	
	private void pathSum(TreeNode root, int sum, List<List<Integer>> lists, List<Integer> list) {
		if(root == null) return;
		list.add(new Integer(root.val));
		if(root.val == sum && root.left == null && root.right == null) {
			lists.add(new ArrayList<>(list)); // new!!!
			list.remove(list.size() - 1);
			return;
		} else {
			pathSum(root.left, sum - root.val, lists, list);
			pathSum(root.right, sum - root.val, lists, list);
		}
		list.remove(list.size() - 1);
	}

}
