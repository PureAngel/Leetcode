package oj004MedianOfTwoSortedArrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * 
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * 
 * @author Xueying Bai
 *
 */

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		
		// to ensure n >= m
		if(m > n) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			
			int t = m;
			m = n;
			n = t;
		}
		
		int iMin = 0, iMax = m;
		int halfLen = (m + n + 1) / 2;
		while(iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if(i < iMax && nums2[j - 1] > nums1[i]) { // i is too small
				iMin = i + 1;
			} else if (i > iMin && nums1[i - 1] > nums2[j]) { // i is too big
				iMax = i - 1;
			} else { // i is perfect
				int maxLeft = 0;
				if(i == 0) { // nums1[0] > all nums2
					maxLeft = nums2[j - 1];
				} else if (j == 0) { // nums2[0] > all nums1
					maxLeft = nums1[i - 1];
				} else {
					maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
				}
				
				if((m + n) % 2 == 1) return maxLeft; // total is odd
				
				int minRight = 0;
				if(i == m) {
					minRight = nums2[j];
				} else if (j == n) {
					minRight = nums1[i];
				} else {
					minRight = Math.min(nums1[i], nums2[j]);
				}
				
				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}

}
