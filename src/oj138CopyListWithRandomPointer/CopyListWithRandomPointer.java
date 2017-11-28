package oj138CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @author Xueying Bai
 *
 */

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		Map<RandomListNode, RandomListNode> node2Random = new HashMap<>();
		//Map<RandomListNode, RandomListNode> random2Node = new HashMap<>();
		RandomListNode node = head;
		while(node != null) {
			node2Random.put(node, node.random);
			node = node.next;
		}
		RandomListNode newhead = new RandomListNode(0);
		RandomListNode newheadPointer = newhead;
		RandomListNode curNode = head;
		while(curNode != null) {
			newheadPointer.next = curNode;
			newheadPointer.next.random = node2Random.get(curNode);
			curNode = curNode.next;
		}
		return newhead.next;
	}

}
