package dp;

public class LC188 {
    /**
     * 动态规划写法
     */
    //0:未操作； 第 k 次买入， 第 k 次 卖出
    //do[i][j] 代表操作到 prices的第i个元素时，当他为j状态的最大值
    public int maxProfit(int k, int[] prices) {
        if(prices.length < 2)
            return 0;
        int[][] dp = new int[prices.length][k * 2 + 2];
        //初始化
        for (int i = 0; i <= k; i++) {
            //在第 1 天买入的最大值为
            dp[0][i * 2] = -prices[0];
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j <= k; j++) {
                //在第 i 天第 k 次买入的最大值等于：MAX(第 i - 1 天第 k 次买入，第 i - 1 天第 k - 1 次卖出 - 第 i 天的股票数值)
                dp[i][j * 2] = Math.max(dp[i - 1][j * 2], dp[i - 1][j * 2 - 1] - prices[i]);
                //在第 i 天第 k 次卖出的最大值等于：MAX(第 i - 1 天第 k 次卖出， 第 i - 1 天第 k - 1 次买入 + 第 i 天的股票数值)
                dp[i][j * 2 + 1] = Math.max(dp[i - 1][j * 2 + 1], dp[i - 1][j * 2] + prices[i]);
            }
        }
        return dp[prices.length - 1][k * 2 + 1];
    }
}
