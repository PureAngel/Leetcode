package oj107BinaryTreeLevelOrderTraversal2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2Iteration {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<>();
		if(root == null) return lists;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(queue.size() > 0) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			lists.add(0, list);
		}
		return lists;
	}

}
