package oj056MergeIntervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 * @author Xueying Bai
 *
 */

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		if(intervals.size() == 0) return result;  // ע��յ����
		intervals.sort(new Comparator<Interval>() {  // ����start�Ĵ�С����
			public int compare(Interval o1, Interval o2) {
				if(o1.start < o2.start) {
					return -1;
				} else if (o1.start == o2.start) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for(Interval interval: intervals) {
			if(interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		result.add(new Interval(start, end));  // ע��Ҫ�����һ���ӽ�ȥ
		return result;
	}

}
