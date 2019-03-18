package ByteDance;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i ++) {
            if (buy > prices[i])
                buy = prices[i];
            else
                profit = Math.max(profit, prices[i] - buy);
        }

        return profit;
    }
}


