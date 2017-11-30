package oj211AddandSearcWord_DataStructureDesign;

/**
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string 
 * containing only letters a-z or . 
 * A . means it can represent any one letter
 * 
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * 
 * @author Xueying Bai
 *
 */

public class WordDictionary {
	static int max_trie_num = 26;
	TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search_trie(root, word);
    }
    
    private boolean search_trie(TrieNode node, String word) {
    	if(word == null || word.length() == 0) {
    		return node.is_end;
    	}
    	int i = 0;
    	if(word.charAt(i) == '.') {
    		for(int j = 0; j < max_trie_num; j++) {
    			if(node.children[j] != null && search_trie(node.children[j], word.substring(i + 1))) {
    				return true;
    			}
    		}
    	} else {
			int pos = word.charAt(i) - 'a';
			if(node.children[pos] != null && search_trie(node.children[pos], word.substring(i + 1))) {
				return true;
			}
		}
    	return false;
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
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */