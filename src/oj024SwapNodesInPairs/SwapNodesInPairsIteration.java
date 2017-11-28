package oj024SwapNodesInPairs;

public class SwapNodesInPairsIteration {
	public ListNode swapPairs(ListNode head) {
		ListNode newhead = new ListNode(0);
		newhead.next = head;
		ListNode cur = newhead;
		while(cur.next != null && cur.next.next != null) {
			ListNode first = cur.next;
			ListNode second = cur.next.next;
			first.next = second.next;
			cur.next = second;
			cur.next.next = first;
			cur = cur.next.next;		
		}
		return newhead.next;
	}

}
