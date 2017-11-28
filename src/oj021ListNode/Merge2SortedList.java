package oj021ListNode;

public class Merge2SortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0);
		ListNode tempListNode = l;
		while(l1 != null && l2 != null) {
			if(l2.val < l1.val) {
				tempListNode.next = l2;
				l2 = l2.next;
			} else {
				tempListNode.next = l1;
				l1 = l1.next;
			}
			tempListNode = tempListNode.next;
		}
		if(l1 != null) {
			tempListNode.next = l1;
		} else if (l2 != null) {
			tempListNode.next = l2;
		}
		return l.next;
	}

}
