package oj349IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * @author Xueying Bai
 *
 */

public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1.length == 0 || nums2.length == 0) return new int[0];
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int len1 = nums1.length, len2 = nums2.length;
		ArrayList<Integer> tempList = new ArrayList<>();
		for(int start1 = 0, start2 = 0, end1 = len1 -1, end2 = len2 - 1; 
				start1 < len1 && start2 < len2 && end1 >= 0 && end2 >= 0;) {
			if(nums1[start1] < nums2[start2]) {
				start1++;
			} else if (nums1[start1] > nums2[start2]) {
				start2++;
			} else {
				if(!tempList.contains(nums1[start1])) {
					tempList.add(nums1[start1]);
				}
				start1++;
				start2++;
			}
			
			if(nums1[end1] < nums2[end2]) {
				end2--;
			} else if (nums1[end1] > nums2[end2]) {
				end1--;
			} else {
				if(!tempList.contains(nums1[end1])) {
					tempList.add(nums1[end1]);
				}
				end1--;
				end2--;
			}
		}
		int[] result = new int[tempList.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = tempList.get(i);
		}
		return result;
	}

}
