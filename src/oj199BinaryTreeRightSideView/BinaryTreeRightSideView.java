package oj199BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example:
 * Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

 * @author Xueying Bai
 *
 */

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		List<Integer> left = rightSideView(root.left);
		List<Integer> right = rightSideView(root.right);
		result.add(root.val);
		for(int i = 0; i < Math.max(left.size(), right.size()); i++) {
			if(i < right.size()) {
				result.add(right.get(i));
			} else {
				result.add(left.get(i));
			}
		}
		return result;
	}

}
