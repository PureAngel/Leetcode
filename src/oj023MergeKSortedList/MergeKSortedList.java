package oj023MergeKSortedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 * 
 * @author Xueying Bai
 *
 */

public class MergeKSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) return null;
		if(lists.length == 1) return lists[0];
		if(lists.length == 2) return merge(lists[0], lists[1]);
		int mid = lists.length / 2;
		ListNode[] subList1 = new ListNode[mid], subList2 = new ListNode[lists.length - mid];
		for(int i = 0; i < mid; i++) {
			subList1[i] = lists[i];
		}
		for(int i = 0; i < lists.length - mid; i++) {
			subList2[i] = lists[i + mid];
		}
		ListNode l1 = mergeKLists(subList1);
		ListNode l2 = mergeKLists(subList2);
		return merge(l1, l2);
		
	}
	
	private ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}

}
