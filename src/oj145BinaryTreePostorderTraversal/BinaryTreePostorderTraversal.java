package oj145BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

 * @author Xueying Bai
 *
 */

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		if(root == null) return result;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			result.add(0, cur.val);
			if(cur.left != null) {
				stack.push(cur.left);
			}
			if(cur.right != null) {
				stack.push(cur.right);
			}
		}
		return result;
	}

}
