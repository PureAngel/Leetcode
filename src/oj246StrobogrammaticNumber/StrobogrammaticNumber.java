package oj246StrobogrammaticNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees 
 * (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. 
 * The number is represented as a string.
 * 
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * 
 * @author Xueying Bai
 *
 */

public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		for(int i = 0; i < num.length(); i++) {
			if(!map.containsKey(num.charAt(i))) {
				return false;
			}
			if(num.charAt(num.length() - 1 - i) != map.get(num.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
