package oj098ValidBST;

import java.util.Stack;

public class ValidBSTInorderIterative {
	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curNode = root;
		TreeNode preNode = null;
		while(curNode != null || !stack.empty()) {
			if(curNode != null) {
				stack.push(curNode);
				curNode = curNode.left;
			} else {
				TreeNode p = stack.pop();
				if(preNode != null && p.val <= preNode.val) {
					return false;
				}
				preNode = p;
				curNode = p.right;
			}
		}
		return true;
	}

}
