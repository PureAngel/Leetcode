package oj406QueueReconstructionByHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Suppose you have a random list of people standing in a queue. 
 * Each person is described by a pair of integers (h, k), 
 * where h is the height of the person 
 * and k is the number of people in front of this person 
 * who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * Note:
 * The number of people is less than 1,100.
 * 
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * @author Xueying Bai
 *
 */

public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		if(people == null || people.length == 0) return people;
		
		Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				// TODO Auto-generated method stub
				if(a[0] > b[0]) {
					return -1;
				} else if (a[0] < b[0]) {
					return 1;
				} else if (a[1] > b[1]) {
					return 1;
				} else if (a[1] < b[1]) {
					return -1;
				} else {
					return 0;
				}
			}	
		});
		
		int len = people.length;
		ArrayList<int[]> templist = new ArrayList<>();
		for(int i = 0; i < len; i++) {
			templist.add(people[i][1], new int[]{people[i][0], people[i][1]});
		}
		
		int[][] result = new int[len][2];
		int i = 0;
		for(int[] k: templist) {
			result[i][0] = k[0];
			result[i][1] = k[1];
			i++;
		}
		
		return result;
	}

}
