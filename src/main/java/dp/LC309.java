package dp;

public class LC309 {
    /**
     * 动态规划写法
     */
    //0:持有股票 1:不持有股票且明天处于冷静期 2:不持有股票且明天不在冷静期
    //dp[i][j] 代表操作到 prices的第i个元素时，当他为 j 状态的最大值
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int num0 = -prices[0], num1 = 0, num2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int nNum0 = Math.max(num0, num2 - prices[i]);
            int nNum2 = Math.max(num1, num2);
            int nNum1 = num0 + prices[i];
            num0 = nNum0;
            num1 = nNum1;
            num2 = nNum2;
        }
        return Math.max(num1, num2);
    }

    public static void main(String[] args) {
        System.out.println(new LC309().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
