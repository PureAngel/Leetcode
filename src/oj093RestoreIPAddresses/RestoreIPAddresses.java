package oj093RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, 
 * restore it by returning all possible valid IP address combinations.
 * 
 * For example:
 * Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author Xueying Bai
 *
 */

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		int len = s.length();
		List<String> result = new ArrayList<>();
		for(int i = 1; i <= 3 && i < len - 2; i++) {
			for(int j = i + 1; j <= i + 3 && j < len - 1; j++) {
				for(int k = j + 1; k <= j + 3 && k < len; k++) {
					String s1 = s.substring(0, i);
					String s2 = s.substring(i, j);
					String s3 = s.substring(j, k);
					String s4 = s.substring(k);
					if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						result.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
		return result;
	}
	
	private boolean isValid(String s) {
		if(s.length() > 3 || s.length() <= 0 || Integer.parseInt(s) > 255 || (s.length() != 1 && s.charAt(0) == '0')) {
			return false;
		}
		return true;
	}

}
