package oj002AddTwoNumbers;

public class AddTwoNumbers2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0);
		ListNode tempL = l;
		int carry = 0; // ½øÎ»
		while(l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			int sum = x + y + carry;
			carry = sum / 10;
			tempL.next = new ListNode(sum % 10);
			tempL = tempL.next;
			if(l1 != null) {
				l1 = l1.next;
			}
			if(l2 != null) {
				l2 = l2.next;
			}
		}
		if(carry > 0) {
			tempL.next = new ListNode(carry);
		}
		return l.next;
	}

}
