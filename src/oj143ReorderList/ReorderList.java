package oj143ReorderList;

/**
 * Given a singly linked list L: L0?L1?бн?Ln-1?Ln,
 * reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?бн
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author Xueying Bai
 *
 */

public class ReorderList {
	public void reorderList(ListNode head) {
		if(head == null && head.next == null) return;
		// find the middle
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// reverse the half after middle
		ListNode preMiddle = slow;
		ListNode preCur = slow.next;
		while(preCur.next != null) {
			ListNode cur = preCur.next;
			preCur.next = cur.next;
			cur.next = preMiddle.next;
			preMiddle.next = cur;
		}
		
		// reorder one by one
		ListNode p1 = head, p2 = preMiddle.next;
		while(p1 != preMiddle) {
			preMiddle.next = p2.next;
			p2.next = p1.next;
			p1.next = p2;
			p1 = p2.next;
			p2 = preMiddle.next;
		}
	}

}
