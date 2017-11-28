package oj226InvertBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTreeIter {
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode curNode = queue.poll();
			TreeNode temp = curNode.left;
			curNode.left = curNode.right;
			curNode.right = temp;
			if(curNode.left != null) {
				queue.offer(curNode.left);
			}
			if(curNode.right != null) {
				queue.offer(curNode.right);
			}
		}
		return root;
	}

}
