package oj251Flattern2DVector;

import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 * 
 * For example,
 * Given 2d vector =
[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, 
the order of elements returned by next should be: [1,2,3,4,5,6].

Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.

 * @author Xueying Bai
 *
 */

public class Vector2D implements Iterator<Integer> {
	
	private Iterator<Integer> inIterator;
	private Iterator<List<Integer>> outIterator;
	
    public Vector2D(List<List<Integer>> vec2d) {
        outIterator = vec2d.iterator();
    }

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		while((inIterator == null || !inIterator.hasNext()) && outIterator.hasNext()) {
			inIterator = outIterator.next().iterator();
		}
		return inIterator != null && inIterator.hasNext();
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		hasNext();
		return inIterator.next();
	}

}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */