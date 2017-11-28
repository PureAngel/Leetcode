package oj257BinaryTreePath;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

 * @author Xueying Bai
 *
 */

public class BinaryTreePath {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new LinkedList<>();
		if(root == null) return result;
		if(root.left == null && root.right == null) {
			result.add("" + root.val);
			return result;
		}
		for(String path: binaryTreePaths(root.left)) {
			result.add(root.val + "->" + path);
		}
		for(String path: binaryTreePaths(root.right)) {
			result.add(root.val + "->" + path);
		}
		return result;
		
	}

}
