package oj350IntersectionOfTwoArrays2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * 
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, 
 * and the memory is limited such that you cannot load all elements into the memory at once?
 * 
 * @author Xueying Bai
 *
 */

public class IntersectionOfTwoArrays2 {
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1.length == 0 || nums2.length == 0) return new int[0];
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int len1 = nums1.length, len2 = nums2.length;
		ArrayList<Integer> tempList = new ArrayList<>();
		int i1 = 0, i2 = 0;
		while(i1 < len1 && i2 < len2) {
			if(nums1[i1] == nums2[i2]) {
				tempList.add(nums1[i1]);
				i1++;
				i2++;
			} else if (nums1[i1] < nums2[i2]) {
				i1++;
			} else {
				i2++;
			}
		}
		
		int[] result = new int[tempList.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = tempList.get(i);
		}
		
		return result;
	}

}
