package leetcode_best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit01(int[] prices) {
        int maxPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i] && maxPrice < prices[j] - prices[i]) {
                    maxPrice = prices[j] - prices[i];
                }
            }
        }

        return maxPrice;
    }

    public int maxProfit02(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
