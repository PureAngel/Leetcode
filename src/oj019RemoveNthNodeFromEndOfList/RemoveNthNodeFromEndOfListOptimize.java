package oj019RemoveNthNodeFromEndOfList;

public class RemoveNthNodeFromEndOfListOptimize {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node = new ListNode(0);
		node.next = head;
		ListNode first = node;
		ListNode second = node;
		for(int i = 1; i <= n + 1; i++) {
			first = first.next;
		}
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return node.next;
	}

}
