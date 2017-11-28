package oj191Numberof1Bits;

/**
 * Write a function that takes an unsigned integer and returns the number of ¡¯1' bits it has 
 * (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ¡¯11' 
 * has binary representation 00000000000000000000000000001011, so the function should return 3.
 * 
 * @author Xueying Bai
 *
 */

public class Numberof1Bits {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int mask = 1;
    	int bits = 0;
    	for(int i = 0; i < 32; i++) {
    		if((n & mask) != 0) {
    			bits++;	
    		}
    		mask <<= 1;
    	}
    	return bits;
    }

}
