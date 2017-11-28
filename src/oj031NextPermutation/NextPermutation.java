package oj031NextPermutation;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. 
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * @author Xueying Bai
 *
 */

public class NextPermutation {
	public void nextPermutation(int[] nums) {
        // 后找
		int i = nums.length - 2;
		while(i >= 0) {
			if(nums[i + 1] <= nums[i]) { // 切记=的情况
				i--;
			} else {
				break;
			}
		}
        
        if(i < 0) { // 切记完全逆序的情况
            reverse(nums, 0, nums.length - 1);
            return; // 切记要return，不然继续运行了
        }
		
		// 交换
		for(int j = nums.length - 1; j > i; j--) {
			if(nums[j] > nums[i]) {
				swap(nums, i, j);
                break; // 切记break跳出循环
			}
		}
		
		// 翻转
		reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private void reverse(int[] nums, int start, int end) {
		int temp;
		while(start < end) {
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

}
