package Contest58;

public class SplitLinkedListinParts {
	public ListNode[] splitListToParts(ListNode root, int k) {
		int node_num = 0;
		ListNode node = root;
		while(node != null) {
			node_num++;
			node = node.next;
		}
		
		int each_num, first_num, group = 0;
		if(node_num <= k) {
			each_num = 1;
		} else {
			if(node_num % k == 0) {
				each_num = node_num / k;
				first_num = each_num;
			} else {
				each_num = node_num / k;
				first_num = each_num + 1;
				group = each_num % k;
			}
		}
		
		ListNode[] result = new ListNode[k];
		node = root;
		int current_num = 1;
		for(int i = 0; i < k; i++) {
			if(group > 0) {
				
			}
		}
	}

}
