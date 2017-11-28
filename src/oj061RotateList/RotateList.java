package oj061RotateList;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * @author Xueying Bai
 *
 */

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null) return head;
		ListNode listNode = new ListNode(0);
		listNode.next = head;
		ListNode fast = listNode;
		ListNode slow = listNode;
		int len = 0;
		// find the length of the list
		while(fast.next != null) {
			len++;
			fast = fast.next;
		} // fast arrives at 5
		
		k = k % len;
		for(int i = len - k; i > 0; i--) {
			slow = slow.next;
		} // slow arrives at 3
		
		fast.next = listNode.next; // 5->1
		listNode.next = slow.next; // 4 becomes head
		slow.next = null; // 3->null
		return listNode.next;
	}

}
