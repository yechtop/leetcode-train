package dp;

import java.util.HashMap;
import java.util.Map;

public class LC123 {
    //递归写法，超时了
    Map<String, Integer> cache = new HashMap<>();
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, prices.length - 1);
    }

    public int maxProfit(int[] prices, int left, int right) {
        if (right == left) {
            return 0;
        }
        int res = profit(prices, left, right);
        int leftEnd = left + 1;
        int rightStart = leftEnd + 1;
        int res1 = 0, res2 = 0;
        for (int i = rightStart; i < right; i++) {
            rightStart = i;
            leftEnd = rightStart - 1;
            res1 = profit(prices, left, leftEnd);
            res2 = profit(prices, rightStart, right);
            res = Math.max(res, res1 + res2);
        }
        return res;
    }

    public int profit(int[] prices, int left, int right) {
        String key = left + "," + right;
        if (cache.containsKey(key))
            return cache.get(key);
        if (right == left) {
            return 0;
        }
        int minVal = prices[left];
        int res = 0;
        for (int i = left; i <= right; i++) {
            minVal = Math.min(minVal, prices[i]);
            res = Math.max(res, prices[i] - minVal);
        }
        cache.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC123().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}, 0, 7));
    }
}
