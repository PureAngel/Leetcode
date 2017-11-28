package oj141LinkedListCircle;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?

 * @author Xueying Bai
 *
 */

// 1ms
public class LinkedListCircle {
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) {
			return false;
		}
		ListNode p = head;
		ListNode q = head.next;
		while(p != q) {
			if(q == null || q.next == null) {
				return false;
			}
			p = p.next;
			q = q.next.next;
		}
		return true;
	}

}
