package dp;

import java.util.HashMap;
import java.util.Map;

public class LC123 {
    /*
     * 递归写法，超时了
     */
//    Map<String, Integer> cache = new HashMap<>();
//    public int maxProfit(int[] prices) {
//        return maxProfit(prices, 0, prices.length - 1);
//    }
//
//    public int maxProfit(int[] prices, int left, int right) {
//        if (right == left) {
//            return 0;
//        }
//        int res = profit(prices, left, right);
//        int leftEnd = left + 1;
//        int rightStart = leftEnd + 1;
//        int res1 = 0, res2 = 0;
//        for (int i = rightStart; i < right; i++) {
//            rightStart = i;
//            leftEnd = rightStart - 1;
//            res1 = profit(prices, left, leftEnd);
//            res2 = profit(prices, rightStart, right);
//            res = Math.max(res, res1 + res2);
//        }
//        return res;
//    }
//
//    public int profit(int[] prices, int left, int right) {
//        String key = left + "," + right;
//        if (cache.containsKey(key))
//            return cache.get(key);
//        if (right == left) {
//            return 0;
//        }
//        int minVal = prices[left];
//        int res = 0;
//        for (int i = left; i <= right; i++) {
//            minVal = Math.min(minVal, prices[i]);
//            res = Math.max(res, prices[i] - minVal);
//        }
//        cache.put(key, res);
//        return res;
//    }


    /**
     * 动态规划写法
     */
    //0:未操作； 1:第一次买入； 2:第一次卖出； 3:第二次买入； 4:第二次卖出
    //do[i][j] 代表操作到 prices的第i个元素时，当他为j状态的最大值
    public int  maxProfit(int[] prices){
        int[][] dp = new int[prices.length][5];
        if(prices.length < 2)
            return 0;
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < prices.length; i++) {
            //第 i 天未操作的状态的值一定等于第 i - 1 个元素未操作的状态的值
            dp[i][0] = dp[i - 1][0];
            //第 i 天第一次买入的状态的值等于下面两种情况的最大值：1. 在第 i 天进行第一次买入。 2.不操作，因为之前已经进行了第一次买入
            dp[i][1] = Math.max(dp[i][0] - prices[i], dp[i - 1][1]);
            //第 i 天第一次卖出的状态的值等于下面两种情况的最大值：1. 在第 i 天进行第一次卖出。 2.不操作，因为之前已经进行了第一次卖出
            dp[i][2] = Math.max(dp[i][1] + prices[i], dp[i - 1][2]);
            //第 i 天第二次买入的状态的值等于下面两种情况的最大值：1. 在第 i 天进行第二次买入。 2.不操作，因为之前已经进行了第二次买入
            dp[i][3] = Math.max(dp[i][2] - prices[i], dp[i - 1][3]);
            //第 i 天第二次卖出的状态的值等于下面两种情况的最大值：1. 在第 i 天进行第二次卖出。 2.不操作，因为之前已经进行了第二次卖出
            dp[i][4] = Math.max(dp[i][3] + prices[i], dp[i - 1][4]);
        }
        return dp[prices.length - 1][4];
    }

    public static void main(String[] args) {
        System.out.println(new LC123().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
