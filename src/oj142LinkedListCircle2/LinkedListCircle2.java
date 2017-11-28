package oj142LinkedListCircle2;

/**
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * @author Xueying Bai
 *
 */

public class LinkedListCircle2 {
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null) return null;
		ListNode p = head;
		ListNode q = head;
		while(q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
			if(p == q) {
				// hasCircle
				ListNode p2 = head;
				while(p2 != p) {
					p2 = p2.next;
					p = p.next;
				}
				return p2;
			}
		}
		// noCircle
		return null;
	}

}
