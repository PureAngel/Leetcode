package Contest62;

// Time: O(NL) Space: O(1)
public class WordFilter2 {
	String[] input;
	
    public WordFilter2(String[] words) {
        input = words;
    }
    
    public int f(String prefix, String suffix) {
        for(int i = input.length - 1; i >= 0; i--) {
        	if(input[i].startsWith(prefix) && input[i].endsWith(suffix)) {
        		return i;
        	}
        }
        return -1;
    }

}
