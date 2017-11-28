package oj091DecodeWays;

public class Test {
	public static void main(String[] args) {
		String s = "26";
		DecodeWays decodeWays = new DecodeWays();
		DecodeWaysDP decodeWaysDP = new DecodeWaysDP();
		DecodeWaysDP2 decodeWaysDP2 = new DecodeWaysDP2();
		//System.out.println(decodeWays.numDecodings(s));
		System.out.println(decodeWaysDP2.numDecodings(s));
	}

}
