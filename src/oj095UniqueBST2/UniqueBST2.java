package oj095UniqueBST2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, 
 * generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author Xueying Bai
 *
 */

public class UniqueBST2 {
	public List<TreeNode> generateTrees(int n) {
		if(n < 1) return new ArrayList<>();
		return generateTrees(1, n);
	}
	
	private List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> list = new ArrayList<>();
		if(start > end) {
			list.add(null);
			return list;
		}
		if(start == end) {
			list.add(new TreeNode(start));
			return list;
		}
		for(int i = start; i <= end; i++) {
			// i is root
			List<TreeNode> leftNodeList = generateTrees(start, i - 1); // left
			List<TreeNode> rightNodeList = generateTrees(i + 1, end); // right
			
			for(TreeNode leftNode: leftNodeList) {
				for(TreeNode rightNode: rightNodeList) {
					TreeNode root = new TreeNode(i);
					root.left = leftNode;
					root.right = rightNode;
					list.add(root);
				}
			}
		}
		return list;
	}

}
