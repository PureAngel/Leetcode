package oj094BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversalRecursion {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		helper(root, result);
		return result;
	}
	
	private void helper(TreeNode root, List<Integer> res) {
		if(root != null) {
			if(root.left != null) {
				helper(root.left, res);
			}
			res.add(root.val);
			if(root.right != null) {
				helper(root.right, res);
			}
		}
	}

}
