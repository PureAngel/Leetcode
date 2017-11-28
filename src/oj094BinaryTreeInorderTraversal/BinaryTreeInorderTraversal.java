package oj094BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
    \
     2
    /
   3
  return [1,3,2].
  
  Note: Recursive solution is trivial, could you do it iteratively?
 * @author Xueying Bai
 *
 */

// iteration
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curNode = root;
		while(curNode != null || !stack.empty()) {
			while(curNode != null) {
				stack.push(curNode);
				curNode = curNode.left;
			}
			curNode = stack.pop();
			result.add(curNode.val);
			curNode = curNode.right;
		}
		return result;
		
	}

}
