package oj002AddTwoNumbers;

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author Xueying Bai
 *
 */

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0);
		ListNode tempL = l;
		int jinwei = 0;
		while(l1 != null && l2 != null) {
			int sum = l1.val + l2.val + jinwei;
			if(sum < 10) {
				tempL.next = new ListNode(sum);
				jinwei = sum / 10;
			} else {
				tempL.next = new ListNode(sum % 10);
				jinwei = sum / 10;
			}
			tempL = tempL.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if(l1 == null && l2 == null) {
			if(jinwei != 0) {
				tempL.next = new ListNode(jinwei);
			} 
			return l.next;
		}
		while(l1 != null) {
			if(jinwei == 0) {
				tempL.next = l1;
				break;
			} else {
				int sum = jinwei + l1.val;
				if(sum < 10) {
					tempL.next = new ListNode(sum);
					tempL = tempL.next;
					tempL.next = l1.next;
					break;
				} else {
					tempL.next = new ListNode(sum % 10);
					tempL = tempL.next;
					jinwei = sum / 10;
					l1 = l1.next;
					if(l1 == null) {
						tempL.next = new ListNode(jinwei);
					}
				}
			}
		}
		while(l2 != null) {
			if(jinwei == 0) {
				tempL.next = l2;
				break;
			} else {
				int sum = jinwei + l2.val;
				if(sum < 10) {
					tempL.next = new ListNode(sum);
					tempL = tempL.next;
					tempL.next = l2.next;
					break;
				} else {
					tempL.next = new ListNode(sum % 10);
					tempL = tempL.next;
					jinwei = sum / 10;
					l2 = l2.next;
					if(l2 == null) {
						tempL.next = new ListNode(jinwei);
					}
				}
			}
		}
		return l.next;
	}

}
