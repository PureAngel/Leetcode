package oj253MeetingRooms2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times 
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * 
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 * 
 * @author Xueying Bai
 *
 */

public class MeetingRooms2 {
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) return 0;
		// 按照开始时间先后排序
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
		
		PriorityQueue<Interval> heap = new PriorityQueue(intervals.length, new Comparator<Interval>() {

			@Override
			public int compare(Interval a, Interval b) {
				// TODO Auto-generated method stub
				if(a.end < b.end) {
					return -1;
				} else if (a.end > b.end) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		
		heap.add(intervals[0]);
		for(int i = 1; i < intervals.length; i++) {
			Interval interval = heap.poll(); // ends earliest
			if(intervals[i].start >= interval.end) {
				interval.end = intervals[i].end; // no need for a new room
			} else {
				heap.add(intervals[i]); // add a new room
			}
			heap.add(interval);
		}
		return heap.size();
	}

}
