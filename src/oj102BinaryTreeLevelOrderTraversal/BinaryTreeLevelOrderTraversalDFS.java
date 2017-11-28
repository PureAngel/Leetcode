package oj102BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalDFS {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		levelOrderHelper(res, root, 0);
		return res;
	}
	
	public void levelOrderHelper(List<List<Integer>> res, TreeNode root, int height) {
		if(root == null) {
			return;
		}
		if(height >= res.size()) {
			res.add(new ArrayList<Integer>());
		}
		res.get(height).add(root.val);
		levelOrderHelper(res, root.left, height + 1);
		levelOrderHelper(res, root.right, height + 1);
	}

}
