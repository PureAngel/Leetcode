package Contest61;

public class MonotoneIncreasingDigits2 {
	public int monotoneIncreasingDigits(int N) {
		char[] S = String.valueOf(N).toCharArray();
		int i = 1;
		while(i < S.length && S[i - 1] <= S[i]) {
			i++;
		}
		while(i > 0 && i < S.length && S[i - 1] > S[i]) {
			S[i - 1]--;
			i--;
		}
		for(int j = i + 1; j < S.length; j++) {
			S[j] = '9';
		}
		return Integer.parseInt(String.valueOf(S));
	}

}
