package Contest62;

import java.util.HashMap;
import java.util.Map;

public class WordFilter3 {
	Map<String, Integer> map = new HashMap<>();
	
	public WordFilter3(String[] words) {
		for(int w = 0; w < words.length; w++) {
			for(int i = 0; i <= 10 && i <= words[w].length(); i++) {
				for(int j = 0; j <= 10 && j <= words[w].length(); j++) {
					map.put(words[w].substring(0, i) + "+" + words[w].substring(words[w].length() - j), w);
				}
			}
		}
	}
	
	public int f(String prefix, String suffix) {
		String keyString = prefix + "+" + suffix;
		if(map.containsKey(keyString)) {
			return map.get(keyString);
		} else {
			return -1;
		}
	}

}
