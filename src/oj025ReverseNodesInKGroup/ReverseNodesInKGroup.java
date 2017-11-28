package oj025ReverseNodesInKGroup;

/**
 * Given a linked list, 
 * reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *  You may not alter the values in the nodes, only nodes itself may be changed.
 *  
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5 
 * 
 * @author Xueying Bai
 *
 */

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		int count = 0;
		ListNode cur = head;
		while(cur != null && count != k) { // search for the (k+1)th node
			cur = cur.next;
			count++;
		}
		if(count == k) { // find the (k+1)th node
			cur = reverseKGroup(cur, k);
			while(count-- > 0) {
				ListNode next = head.next; // record next node
				head.next = cur; // head��һ������һѭ��
				cur = head; // ��Сѭ����Χ����ǰ�ƶ�һ��
				head = next; // ��һ�ε�ͷ�ڵ����һ��
			}
			head = cur;
		}
		return head;
	}

}
