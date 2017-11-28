package oj091DecodeWays;

import java.util.HashMap;
import java.util.Map;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * @author Xueying Bai
 *
 */
 // 超时哇！！！
public class DecodeWays {
	public int numDecodings(String s) {
		Map<String, Integer> numMap = new HashMap<>();
		char[] charArray = s.toCharArray();
		int len = charArray.length;
		if(len == 0) {
			return 0;
		}
		int num1 = 0; // 表示分出一个字符的
		int num2 = 0; // 表示分出2个字符的
		char c = charArray[0];
		
		// 处理分出一个字符的情况
		if(len >= 1) {
			if(c == '0') {
				return 0;
			} else {
				if(len == 1) {
					num1 = 1;
				} else {
					if(numMap.containsKey(s.substring(1))) {
						num1 = numMap.get(s.substring(1));
					} else {
						num1 = numDecodings(s.substring(1));
						numMap.put(s.substring(1), num1);
					}
					//num1 = numDecodings(s.substring(1));
				}
			}
		}
		
		// 处理分出两个字符的情况
		if(len >= 2) {
			if(c == '1') {
				if(len == 2) {
					num2 = 1;
				} else {
					num2 = numDecodings(s.substring(2));
				}
			} else if (c == '2' && charArray[1] >= '0' && charArray[1] <= '6') {
				if(len == 2) {
					num2 = 1;
				} else {
					//num2 = numDecodings(s.substring(2));
					if(numMap.containsKey(s.substring(2))) {
						num2 = numMap.get(s.substring(2));
					} else {
						num2 = numDecodings(s.substring(2));
						numMap.put(s.substring(2), num2);
					}
				}
			}
		}
		return num1 + num2;
	}

}
