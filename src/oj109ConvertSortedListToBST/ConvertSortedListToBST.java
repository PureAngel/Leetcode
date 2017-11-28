package oj109ConvertSortedListToBST;

/**
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * @author Xueying Bai
 *
 */

public class ConvertSortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) return null;
		TreeNode root = helper(head, null);
		return root;
	}
	
	private TreeNode helper(ListNode head, ListNode tail) {
		ListNode slow = head;
		ListNode fast = head;
		if(head == tail) return null;
		while(fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		} 
		TreeNode root = new TreeNode(slow.val);
		root.left = helper(head, slow);
		root.right = helper(slow.next, tail);
		return root;
	}

}
