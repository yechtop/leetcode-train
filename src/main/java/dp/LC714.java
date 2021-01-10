package dp;

public class LC714 {

    //0：已买入   1：已卖出
    public int maxProfit(int[] prices, int fee) {
        if(prices.length < 2)
            return 0;
        int[][] res = new int[prices.length][2];
        res[0][0] = -prices[0];
        res[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            //在第 i 天已买入的最大值为：MAX(在第 i - 1 天已买入， 在第 i - 1 天已卖出 - prices[i])
            res[i][0] = Math.max(res[i - 1][0], res[i - 1][1] - prices[i]);
            //在第 i 天已卖出的最大值为：MAX(在第 i - 1 天已卖出， 在第 i - 1 天已买入 + prices[i] - 2)
            res[i][1] = Math.max(res[i - 1][1], res[i - 1][0] + prices[i] - fee);
        }
        return res[prices.length - 1][1];
    }
}
