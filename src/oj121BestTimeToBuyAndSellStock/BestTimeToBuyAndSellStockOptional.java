package oj121BestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStockOptional {
	public int maxProfit(int[] prices) {
		int minprice = Integer.MAX_VALUE;
		int profit = 0;
		for(int i = 0; i < prices.length; i++) {
			if(minprice > prices[i]) {
				minprice = prices[i];
			} else if (prices[i] - minprice > profit) {
				profit = prices[i] - minprice;
			}
		}
		return profit;
	}

}
