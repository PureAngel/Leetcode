package Contest60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.

For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.

Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

Note:

The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].

 * @author Xueying Bai
 *
 */

public class SentenceSimilarity {
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		if(words1.length != words2.length) return false;
		if(pairs == null || pairs.length == 0) {
			for(int i = 0; i < words1.length; i++) {
				if(!words1[i].equals(words2[i])) {
					return false;
				}
			}
			return true;
		}
		Map<String, ArrayList<String>> map = new HashMap<>();
		for(int i = 0; i < pairs.length; i++) {
			if(!map.containsKey(pairs[i][0])) {
				ArrayList<String> arrayList = new ArrayList<>();
				arrayList.add(pairs[i][1]);
				map.put(pairs[i][0], arrayList);
			} else {
				ArrayList<String> arrayList = map.get(pairs[i][0]);
				arrayList.add(pairs[i][1]);
				map.put(pairs[i][0], arrayList);
			}
		}
		for(int i = 0; i < words1.length; i++) {
			if(words1[i].equals(words2[i]) || 
					map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i]) || 
					map.containsKey(words2[i]) && map.get(words2[i]).contains(words1[i])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

}
