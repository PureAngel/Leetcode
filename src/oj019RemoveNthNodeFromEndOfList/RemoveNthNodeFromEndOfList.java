package oj019RemoveNthNodeFromEndOfList;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * @author Xueying Bai
 *
 */

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int len = 0;
		ListNode node = head;
		while(node != null) {
			len++;
			node = node.next;
		}
		int count = len - n + 1; // the countth
		if(count == 1) return head.next;
		int i = 1;
		node = head;
		while(i < count - 1) {
			node = node.next;
			i++;
		}
		node.next = node.next.next;
		return head;
	}

}
