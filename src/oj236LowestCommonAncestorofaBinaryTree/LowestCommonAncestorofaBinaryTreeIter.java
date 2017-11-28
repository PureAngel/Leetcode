package oj236LowestCommonAncestorofaBinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LowestCommonAncestorofaBinaryTreeIter {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> parentMap = new HashMap<>();
		Stack<TreeNode> stack = new Stack<>();
		parentMap.put(root, null);
		stack.push(root);
		while(!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
			TreeNode node = stack.pop();
			if(node.left != null) {
				parentMap.put(node.left, node);
				stack.push(node.left);
			}
			if(node.right != null) {
				parentMap.put(node.right, node);
				stack.push(node.right);
			}
		}
		Set<TreeNode> ancestorSet = new HashSet<>();
		while(p != null) {
			ancestorSet.add(p);
			p = parentMap.get(p);
		}
		while(!ancestorSet.contains(q)) {
			q = parentMap.get(q);
		}
		return q;
	}

}
