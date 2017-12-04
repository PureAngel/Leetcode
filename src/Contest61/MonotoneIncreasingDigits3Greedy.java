package Contest61;

public class MonotoneIncreasingDigits3Greedy {
	public int monotoneIncreasingDigits(int N) {
		String string = Integer.toString(N);
		String resString = "";
		search:
			for(int i = 0; i < string.length(); i++) {
				for(char c = '1'; c <= '9'; c++) {
					if(string.compareTo(resString + repeat(c, string.length() - i)) < 0) {
						resString += (char)(c - 1);
						continue search;
					}
				}
				resString += '9';
			}
		
		return Integer.parseInt(resString);
	}
	
	private String repeat(char c, int count) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count; i++) {
			sb.append(c);
		}
		return sb.toString();
	}

}
