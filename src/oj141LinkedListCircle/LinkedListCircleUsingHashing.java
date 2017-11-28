package oj141LinkedListCircle;

import java.util.HashSet;
import java.util.Set;

// 10ms
public class LinkedListCircleUsingHashing {
	public boolean hasCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while(head != null) {
			if(set.contains(head)) {
				return true;
			} else {
				set.add(head);
				head = head.next;
			}
		}
		return false;
	}

}
