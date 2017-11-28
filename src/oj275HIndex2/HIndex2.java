package oj275HIndex2;

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order? 
 * Could you optimize your algorithm?
 * 
 * @author Xueying Bai
 *
 */

public class HIndex2 {
	public int hIndex(int[] citations) {
		int low = 0, len = citations.length, high = len - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			if(citations[mid] == len - mid) {
				return citations[mid];
			} else if (citations[mid] > len - mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return len - 1 - high;
	}

}
