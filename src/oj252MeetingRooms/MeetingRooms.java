package oj252MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times 
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * 
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 * 
 * @author Xueying Bai
 *
 */

public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval a, Interval b) {
				// TODO Auto-generated method stub
				if(a.start < b.start) {
					return -1;
				} else if (a.start > b.start) {
					return 1;
				} else {
					return 0;
				}
			}	
		});
		
		int len = intervals.length;
		for(int i = 0; i < len - 1; i++) {
			if(intervals[i].end > intervals[i + 1].start) {
				return false;
			}
		}
		
		return true;
	}

}
