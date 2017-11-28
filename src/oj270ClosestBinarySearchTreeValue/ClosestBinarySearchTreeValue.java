package oj270ClosestBinarySearchTreeValue;

/**
 * Given a non-empty binary search tree and a target value, 
 * find the value in the BST that is closest to the target.
 * 
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * 
 * @author Xueying Bai
 *
 */

public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		double distance = Math.abs(target - root.val);
		if(target > root.val) {
			if(root.right != null && distance > Math.abs(target - closestValue(root.right, target))) {
				return closestValue(root.right, target);
			} else {
				return root.val;
			}
		} else {
			if(root.left != null && distance > Math.abs(target - closestValue(root.left, target))) {
				return closestValue(root.left, target);
			} else {
				return root.val;
			}
		}
	}

}
