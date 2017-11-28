package oj083RemoveDuplicatesFromSortedList;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author Xueying Bai
 *
 */

// 对于连续的重复处理，在else中才后移指针

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode p = head;
		while(p != null && p.next != null) {
			if(p.val == p.next.val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}
		return head;
	}

}
