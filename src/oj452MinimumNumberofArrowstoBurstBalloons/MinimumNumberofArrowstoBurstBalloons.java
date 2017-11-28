package oj452MinimumNumberofArrowstoBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are a number of spherical balloons spread in two-dimensional space. 
 * For each balloon, provided input is the start and end coordinates of the horizontal diameter. 
 * Since it's horizontal, y-coordinates don't matter 
 * and hence the x-coordinates of start and end of the diameter suffice. 
 * Start is always smaller than end. There will be at most 104 balloons.
 * 
 * An arrow can be shot up exactly vertically from different points along the x-axis. 
 * A balloon with xstart and xend bursts by an arrow shot at x if xstart ¡Ü x ¡Ü xend. 
 * There is no limit to the number of arrows that can be shot. 
 * An arrow once shot keeps travelling up infinitely. 
 * The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 * 
 * Example:
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * Output:
 * 2
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 
 * (bursting the balloons [2,8] and [1,6]) 
 * and another arrow at x = 11 (bursting the other two balloons).
 * 
 * @author Xueying Bai
 *
 */

public class MinimumNumberofArrowstoBurstBalloons {
	public int findMinArrowShots(int[][] points) {
		if(points.length == 0) return 0;
		// sort by the start
		Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				// TODO Auto-generated method stub
				if(a[0] < b[0]) {
					return -1;
				} else if (a[0] > b[0]) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		int shootNum = 1;
		int shootBegin = points[0][0];
		int shootEnd = points[0][1];
		for(int i = 1; i < points.length; i++) {
			if(points[i][0] <= shootEnd) {
				shootBegin = points[i][0];
				if(points[i][1] < shootEnd) {
					shootEnd = points[i][1];
				}
			} else {
				shootNum++;
				shootBegin = points[i][0];
				shootEnd = points[i][1];
			}
		}
		return shootNum;
	}

}
