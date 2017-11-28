package oj027RemoveElement;

public class RemoveElementAnotherVersion {
	public int removeElement(int[] nums, int val) {
		int i = 0;
		int l = nums.length;
		while(i < l) {
			if(nums[i] == val) {
				nums[i] = nums[l-1];
				l--;
			} else {
				i++;
			}
		}
		return l;
	}

}
