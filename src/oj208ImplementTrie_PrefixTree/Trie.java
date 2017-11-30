package oj208ImplementTrie_PrefixTree;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author Xueying Bai
 *
 */

public class Trie {
	static int max_trie_num = 64;
	TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode curNode = root;
        for(int i = 0; i < word.length(); i++) {
        	int pos = word.charAt(i) - 'a';
        	if(curNode.children[pos] == null) {
        		curNode.children[pos] = new TrieNode();
        	}
        	curNode = curNode.children[pos];
        }
        curNode.is_end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = root;
        for(int i = 0; i < word.length(); i++) {
        	int pos = word.charAt(i) - 'a';
        	if(curNode.children[pos] == null) {
        		return false;
        	}
        	curNode = curNode.children[pos];
        }
        return curNode.is_end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for(int i = 0; i < prefix.length(); i++) {
        	int pos = prefix.charAt(i) - 'a';
        	if(curNode.children[pos] == null) {
        		return false;
        	}
        	curNode = curNode.children[pos];
        }
        return true;
    }
    
    class TrieNode {
    	TrieNode[] children = new TrieNode[max_trie_num];
    	boolean is_end;
    	TrieNode() {
			// TODO Auto-generated constructor stub
    		is_end = false;
    		for(int i = 0; i < max_trie_num; i++) {
    			children[i] = null;
    		}
		}
    }
    
    public static void main(String[] args) {
    	Trie trie = new Trie();
    	trie.insert("trie");
    	trie.insert("search");
    	System.out.println(trie.search(""));
    	System.out.println(trie.search("a"));
    	System.out.println(trie.startsWith("a"));
    	
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */