package oj295FindMedianFromDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

 * @author Xueying Bai
 *
 */

public class MedianFinder {
	PriorityQueue<Integer> bigQueue;
	PriorityQueue<Integer> smallQueue;
	/** initialize your data structure here. */
    public MedianFinder() {
        bigQueue = new PriorityQueue<>(new Comparator<Integer>() {
        	public int compare(Integer o1, Integer o2) {
        		if(o1 < o2) {
        			return 1;
        		} else if (o1 > o2) {
					return -1;
				} else {
					return 0;
				}
        	}
		});
        smallQueue = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(bigQueue.isEmpty()) {
        	bigQueue.add(num);
        	return;
        }
        if(bigQueue.size() == smallQueue.size()) {
        	if(num < bigQueue.peek()) {
        		bigQueue.add(num);
        	} else {
				smallQueue.add(num);
			}
        } else if (bigQueue.size() > smallQueue.size()) {
			if(num > bigQueue.peek()) {
				smallQueue.add(num);
			} else {
				smallQueue.add(bigQueue.poll());
				bigQueue.add(num);
			} 
		} else {
			if(num < smallQueue.peek()) {
				bigQueue.add(num);
			} else {
				bigQueue.add(smallQueue.poll());
				smallQueue.add(num);
			}
		}
    }
    
    public double findMedian() {
        if(bigQueue.size() == smallQueue.size()) {
        	return (bigQueue.peek() + smallQueue.peek()) / 2.0;
        } else if (bigQueue.size() > smallQueue.size()) {
			return bigQueue.peek();
		} else {
			return smallQueue.peek();
		}
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
