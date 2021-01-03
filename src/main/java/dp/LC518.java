package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i + coin];
            }
        }
        return dp[amount];
    }
}
