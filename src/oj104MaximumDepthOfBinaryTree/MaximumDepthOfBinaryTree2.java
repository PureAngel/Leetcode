package oj104MaximumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// Iteration BFS
public class MaximumDepthOfBinaryTree2 {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				TreeNode curNode = queue.poll();
				size--;
				if(curNode.left != null) {
					queue.add(curNode.left);
				}
				if(curNode.right != null) {
					queue.add(curNode.right);
				}
			}
			count++;
		}
		return count;
	}

}
