package oj117PopulatingNextRightPointersInEachNode2;


/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Note:
 * You may only use constant extra space.
 * 
 * For example,
 * Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

 * @author Xueying Bai
 *
 */

public class PopulatingNextRightPointersInEachNode2 {
	public void connect(TreeLinkNode root) {
		while(root != null) {
			TreeLinkNode tempNode = new TreeLinkNode(0);
			TreeLinkNode curNode = tempNode;
			while(root != null) {
				if(root.left != null) {
					curNode.next = root.left;
					curNode = curNode.next;
				}
				if(root.right != null) {
					curNode.next = root.right;
					curNode = curNode.next;
				}
				root = root.next;
			}
			root = tempNode.next;
		}
	}

}
