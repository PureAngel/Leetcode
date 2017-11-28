package oj315CountofSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array. 
 * The counts array has the property 
 * where counts[i] is the number of smaller elements to the right of nums[i].
 * 
 * Example:
 * Given nums = [5, 2, 6, 1]
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 * 
 * @author Xueying Bai
 *
 */

public class CountofSmallerNumbersAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
		int len = nums.length;
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<TreeNode> nodeList = new ArrayList<>();
		ArrayList<Integer> countList = new ArrayList<>();
		countList.add(0);
		for(int i = len - 1; i >= 0; i--) {
			nodeList.add(new TreeNode(nums[i]));
		}
		for(int i = 1; i < len; i++) {
			int count_small = 0;
			insertNode(nodeList.get(0), nodeList.get(i), count_small);
			countList.add(count_small);
		}
		for(int i = len - 1; i >= 0; i--) {
			result.add(countList.get(i));
		}
		return result;
	}
	
	private void insertNode(TreeNode root, TreeNode node, int count) {
		if(node.val < root.val) {
			root.count++;
			if(root.left == null) {
				root.left = node;
			} else {
				insertNode(root.left, node, count);
			}
		} else {
			count += root.count + 1;
			if(root.right == null) {
				root.right = node;
			} else {
				insertNode(root.right, node, count);
			}
		}
	}

}
