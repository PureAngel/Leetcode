package oj346MovingAveragefromDataStream;

/**
 * Given a stream of integers and a window size, 
 * calculate the moving average of all integers in the sliding window.
 * 
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * 
 * @author Xueying Bai
 *
 */

public class MovingAverage {
	int[] window;
	int count;
	int sum;
	int index;
	/** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        count = 0;
        sum = 0;
        index = 0;
    }
    
    public double next(int val) {
        if(count < window.length) {
        	count++;
        }
        sum -= window[index];
        sum += val;
        window[index] = val;
        index = (index + 1) % window.length;
        return (double)sum / count;
    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
