package Contest58;

public class SplitLinkedListinParts {
	public ListNode[] splitListToParts(ListNode root, int k) {
		int node_num = 0;
		ListNode node = root;
		while(node != null) {
			node_num++;
			node = node.next;
		}
		
		ListNode[] result = new ListNode[k];
		int each_num = node_num / k, remain = node_num % k;
		node = root;
		for(int i = 0; i < k; i++) {
			ListNode head = new ListNode(0);
			ListNode temp = head;
			for(int j = 0; j < each_num + (i < remain ? 1 : 0); j++) {
				temp.next = new ListNode(node.val);
				temp = temp.next;
				if(node != null) {
					node = node.next;
				}
				result[i] = head.next;
			}
		}
		return result;
	}

}
