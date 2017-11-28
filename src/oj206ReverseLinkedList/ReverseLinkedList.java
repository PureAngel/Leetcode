package oj206ReverseLinkedList;

/**
 * Reverse a singly linked list.
 * @author Xueying Bai
 *
 */

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode newhead = null;
		while(head != null) {
			ListNode next = newhead;
			newhead = head;
			head = head.next;
			newhead.next = next;
		}
		return newhead;
	}

}
