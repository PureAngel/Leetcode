package oj086PartitionList;

/**
 * Given a linked list and a value x, 
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * @author Xueying Bai
 *
 */

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode less = new ListNode(0);
		ListNode more = new ListNode(0);
		ListNode lessPoint = less;
		ListNode morePoint = more;
		while(head != null) {
			if(head.val < x) {
				lessPoint.next = head;
				lessPoint = lessPoint.next;
			} else {
				morePoint.next = head;
				morePoint = morePoint.next;
			}
			head = head.next;
		}
		lessPoint.next = more.next;
		morePoint.next = null;  // ½«Î²½ÚµãÖÃ¿Õ
		return less.next;
	}

}
