package oj123BestTimetoBuyandSellStockIII;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * 
 * @author Xueying Bai
 *
 */

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		int firstBuy = Integer.MIN_VALUE, firstSell = 0, secondBuy = Integer.MIN_VALUE, secondSell = 0;
		for(int curPrice: prices) {
			if(firstBuy < -curPrice) firstBuy = -curPrice;
			if(firstSell < curPrice + firstBuy) firstSell = curPrice + firstBuy;
			if(secondBuy < firstSell - curPrice) secondBuy = firstSell - curPrice;
			if(secondSell < curPrice + secondBuy) secondSell = curPrice + secondBuy;
		}
		return secondSell;
	}

}
