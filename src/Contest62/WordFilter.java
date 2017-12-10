package Contest62;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:
Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1
Note:
words has length in range [1, 15000].
For each test case, up to words.length queries WordFilter.f may be made.
words[i] has length in range [1, 10].
prefix, suffix have lengths in range [0, 10].
words[i] and prefix, suffix queries consist of lowercase letters only.

 * @author Xueying Bai
 *
 */

public class WordFilter {
	Map<String, Integer> map = new HashMap<>();
	Map<String, Integer> map_res = new HashMap<>();

    public WordFilter(String[] words) {
        for(int i = 0; i < words.length; i++) {
        	map.put(words[i], i);
        }
    }
    
    public int f(String prefix, String suffix) {
    	String keyString = prefix + "+" + suffix;
    	if(map_res.containsKey(keyString)) {
    		return map_res.get(keyString);
    	}
    	int result = -1;
    	int pre_len = prefix.length(), suf_len = suffix.length();
        for(String word: map.keySet()) {
        	if(word == null || word.length() < pre_len || word.length() < suf_len) continue;
        	if(pre_len == 0 && word.substring(word.length() - suf_len).equals(suffix)) {
        		result = Math.max(result, map.get(word));
        	}
        	if(suf_len == 0 && word.substring(0, pre_len).equals(prefix)) {
        		result = Math.max(result, map.get(word));
        	}
        	if(word.substring(0, pre_len).equals(prefix) && 
        			word.substring(word.length() - suf_len).equals(suffix)) {
        		result = Math.max(result, map.get(word));
        	}
        }
        map_res.put(keyString, result);
        return result;
    }
    
    public static void main(String[] args) {
    	String[] words = {"a", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b"};
    	WordFilter obj = new WordFilter(words);
    	int param_1 = obj.f("a", "a");
    	int param_2 = obj.f("a", "a");
    	String[] words2 = {"a", "a"};
    	WordFilter obj2 = new WordFilter(words2);
    	int param_3 = obj2.f("a", "a");
    	int param_4 = obj2.f("a", "a");
    	//System.out.println(param_1);
    	//System.out.println(param_2);
    	//System.out.println(param_3);
    	//System.out.println(param_4);
	}
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */