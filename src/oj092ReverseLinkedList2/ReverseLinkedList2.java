package oj092ReverseLinkedList2;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ¡Ü m ¡Ü n ¡Ü length of list.
 * 
 * @author Xueying Bai
 *
 */

public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		int len = n - m + 1;
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode result = head;
		for(int i = 0; i < m - 1; i++) {
			pre = pre.next;
		}
		ListNode cur = pre.next;
		ListNode newcur = null;
		ListNode tail = cur;
		for(int i = 0; i < len; i++) {
			ListNode next = newcur;
			newcur = cur;
			cur = cur.next;
			newcur.next = next;		
		}
		tail.next = cur;
		if(m > 1) {
			pre.next = newcur;
		} else {
			result = newcur;
		}
		return result;
	}

}
