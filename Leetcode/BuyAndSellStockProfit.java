package Leetcode;
import java.util.*;
public class BuyAndSellStockProfit {
	public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int profit = 0;
        int buy = 0;
        int pos = 1;
        
        while(pos < prices.length) {
            if(prices[buy] >= prices[pos]) {
                buy = pos;
            } else {
                profit = Math.max(profit, prices[pos] - prices[buy]);
            }
            pos++;
        }
        return profit;
    }
}
