package oj199BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideViewLevelOrderTraversal {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				if(i == size - 1) {
					result.add(curNode.val);
				}
				if(curNode.left != null) {
					queue.add(curNode.left);
				}
				if(curNode.right != null) {
					queue.add(curNode.right);
				}
			}
		}
		return result;
	}

}
