package oj160IntersectionOf2LinkedList;

public class IntersectionOf2LinkedListAnother {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = 0;
		int lenB = 0;
		ListNode nodeA = headA;
		ListNode nodeB = headB;
		while(nodeA != null) {
			lenA++;
			nodeA = nodeA.next;
		}
		while(nodeB != null) {
			lenB++;
			nodeB = nodeB.next;
		}
		if(lenA > lenB) {
			int moreLen = lenA - lenB;
			while(moreLen-- > 0) {
				headA = headA.next;
			}
			while(headA != null && headB != null) {
				if(headA == headB) {
					return headA;
				}
				headA = headA.next;
				headB = headB.next;
			}
		} else {
			int moreLen = lenB - lenA;
			while(moreLen-- > 0) {
				headB = headB.next;
			}
			while(headA != null && headB != null) {
				if(headA == headB) {
					return headA;
				}
				headA = headA.next;
				headB = headB.next;
			}
		}
		return null;
	}

}
