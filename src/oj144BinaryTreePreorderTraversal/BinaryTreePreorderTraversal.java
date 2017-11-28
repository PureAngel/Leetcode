package oj144BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

 * @author Xueying Bai
 *
 */

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		Stack<TreeNode > stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			result.add(cur.val);
			if(cur.right != null) {    // 注意要先压入右节点，后压入左节点
				stack.push(cur.right);
			}
			if(cur.left != null) {
				stack.push(cur.left);
			}
		}
		return result;
	}

}
