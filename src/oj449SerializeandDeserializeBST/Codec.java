package oj449SerializeandDeserializeBST;

import java.util.ArrayList;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits 
 * so that it can be stored in a file or memory buffer, 
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary search tree can be serialized to a string 
 * and this string can be deserialized to the original tree structure.
 * 
 * The encoded string should be as compact as possible.
 * 
 * Note: Do not use class member/global/static variables to store states. 
 * Your serialize and deserialize algorithms should be stateless.
 * 
 * @author Xueying Bai
 *
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder encode = new StringBuilder();
        preorder(root, encode);
        System.out.println(encode);
        return encode.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        int val = 0;
        for(int i = 0; i < data.length(); i++) {
        	if(data.charAt(i) == '#') {
        		nodeList.add(new TreeNode(val));
        		val = 0;
        	} else {
				val = data.charAt(i) - '0' + 10 * val;
			}
        }
        for(int i = 1; i < nodeList.size(); i++) {
        	insert_node(nodeList.get(0), nodeList.get(i));
        }
        return nodeList.get(0);
    }
    
    private void preorder(TreeNode root, StringBuilder encode) { // String类型不能直接通过函数传参数，效果相当于值传递
    	if(root == null) return;
    	encode.append(root.val + "#");
    	preorder(root.left, encode);
    	preorder(root.right, encode);
    }
    
    private void insert_node(TreeNode root, TreeNode node) {
    	if(node.val < root.val) {
    		if(root.left == null) {
    			root.left = node;
    		} else {
				insert_node(root.left, node);
			}
    	} else {
			if(root.right == null) {
				root.right = node;
			} else {
				insert_node(root.right, node);
			}
		}
    }
    
    public static void main(String[] args) {
    	Codec codec = new Codec();
    	TreeNode a = new TreeNode(2);
    	TreeNode b = new TreeNode(1);
    	TreeNode c = new TreeNode(3);
    	a.left = b;
    	a.right = c;
    	System.out.println(codec.serialize(a));
    	TreeNode root = codec.deserialize("2#1#3#");
    	System.out.println(root.val);
    	System.out.println(root.left.val);
    	System.out.println(root.right.val);
	}
}

//Your Codec object will be instantiated and called as such:
//Codec codec = new Codec();
//codec.deserialize(codec.serialize(root));