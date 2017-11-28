package oj360SortTransformedArray;

/**
 * Given a sorted array of integers nums and integer values a, b and c. 
 * Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
 * 
 * The returned array must be in sorted order.
 * Expected time complexity: O(n)
 * 
 * Example:
 * nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 * Result: [3, 9, 15, 33]
 * 
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 * Result: [-23, -5, 1, 7]
 * 
 * @author Xueying Bai
 *
 */
// ���ö��κ������ʣ�a > 0ʱ�����ߴ��м�С��a < 0ʱ������С�м�����Ե�a > 0ʱ���ȼ����ģ����������Ҷ˿�ʼ����a < 0ʱ���ȼ���С�ģ�����������˿�ʼ��
public class SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int[] result = new int[nums.length];
		int start = 0, end = nums.length - 1;
		int i;
		if(a >= 0) {
			i = nums.length - 1;
		} else {
			i = 0;
		}
		while(start <= end) {
			int startRes = functionRes(nums[start], a, b, c);
			int endRes = functionRes(nums[end], a, b, c);
			if(a >= 0) {
				if(startRes >= endRes) {
					result[i] = startRes;
					i--;
					start++;
				} else {
					result[i] = endRes;
					i--;
					end--;
				}
			} else {
				if(startRes <= endRes) {
					result[i] = startRes;
					i++;
					start++;
				} else {
					result[i] = endRes;
					i++;
					end--;
				}
			}
			
		}
		return result;
	}
	
	private int functionRes(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}

}
