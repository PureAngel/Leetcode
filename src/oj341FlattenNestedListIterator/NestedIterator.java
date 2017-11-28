package oj341FlattenNestedListIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list 
 * -- whose elements may also be integers or other lists.
 * 
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * 
 * By calling next repeatedly until hasNext returns false, 
 * the order of elements returned by next should be: [1,1,2,1,1].
 * 
 * Example 2:
 * Given the list [1,[4,[6]]],
 * 
 * By calling next repeatedly until hasNext returns false, 
 * the order of elements returned by next should be: [1,4,6].
 * 
 * @author Xueying Bai
 *
 */

public class NestedIterator implements Iterator<Integer> {
	
	
	Stack<NestedInteger> stack;
	
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for(int i = nestedList.size() - 1; i >= 0; i--) { // ◊¢“‚—π’ªÀ≥–Ú—Ω
        	stack.push(nestedList.get(i));
        }
        
    }

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		while(!stack.isEmpty()) {
			NestedInteger cur = stack.peek();
			if(cur.isInteger()) {
				return true;
			}
			// list
			stack.pop();
			for(int i = cur.getList().size() - 1; i >= 0; i--) { // ◊¢“‚—π’ªÀ≥–Ú—Ω
				stack.push(cur.getList().get(i));
			}
		}
		return false;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return stack.pop().getInteger();
	}

}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */