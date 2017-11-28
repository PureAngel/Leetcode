package oj082RemoveDuplicatesFromSortedList2;

/**
 * Given a sorted linked list, 
 * delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * @author Administrator
 *
 */

public class RemoveDuplicatesFromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		ListNode newHead = new ListNode(0); 
		ListNode pre = newHead;
		pre.next = head;
		ListNode cur = head;
		while(cur != null) {
			// 删掉除第一个之外的所有相同node
			while(cur.next != null && cur.next.val == cur.val) {
				cur = cur.next;
			}
			
			if(pre.next == cur) {
				pre = pre.next;
			} else { // 删掉第一个相同的node
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return newHead.next;
	}

}
