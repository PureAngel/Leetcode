package oj203RemoveLinkedListElements;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * @author Xueying Bai
 *
 */

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode pre = new ListNode(0);
		ListNode node = pre;
		pre.next = head;
		while(pre.next != null) {
			if(pre.next.val == val) {
				if(pre.next.next != null) {
					pre.next = pre.next.next;
				} else {
					pre.next = null;
				}	
			} else {
				pre = pre.next;
			}
		}
		return node.next;
	}

}
