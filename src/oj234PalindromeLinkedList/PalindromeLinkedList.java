package oj234PalindromeLinkedList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 * @author Xueying Bai
 *
 */

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// let right part smaller
		if(fast != null) {
			slow = slow.next;
		}
		slow = reverse(slow);
		fast = head;
		while(slow != null) {
			if(slow.val != fast.val) {
				return false;
			}
			slow = slow.next;
			head = head.next;
		}
		return true;
	}
	
	private ListNode reverse(ListNode head) {
		ListNode pre = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

}
