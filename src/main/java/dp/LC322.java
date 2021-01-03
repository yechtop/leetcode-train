package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC322 {
    //贪心递归做法
    Map<Integer, Integer> cache = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (cache.containsKey(amount))
            return cache.get(amount);
        if (amount == 0) {
            cache.put(amount, 0);
            return 0;
        }
        if (amount < 0) {
            cache.put(amount, -1);
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int temp = coinChange(coins, amount - coin);
            if (temp != -1 && temp < min)
                min = temp;
        }
        int res = min == Integer.MAX_VALUE ? -1 : min + 1;
        cache.put(amount, res);
        return res;
    }

    //DP做法
    public int coinChange_dp(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        Arrays.fill(res, amount + 1);
        res[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i >= coin)
                    res[i] = Math.min(res[i], res[i - coin] + 1);
            }
        }
        return res[amount] > amount ? -1 : res[amount];
    }
}
