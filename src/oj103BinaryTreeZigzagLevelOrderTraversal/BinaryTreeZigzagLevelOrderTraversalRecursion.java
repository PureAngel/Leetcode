package oj103BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversalRecursion {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<>();
		levelMaker(lists, root, 0);
		return lists;
	}
	
	private void levelMaker(List<List<Integer>> lists, TreeNode root, int level) {
		if(root == null) return;
		if(level >= lists.size()) {
			lists.add(0, new ArrayList<Integer>());
		}
		if(level % 2 == 0) {
			lists.get(level).add(root.val);
		} else {
			lists.get(level).add(0, root.val);
		}
		levelMaker(lists, root.left, level + 1);
		levelMaker(lists, root.right, level + 1);
	}

}
