package dp;

import java.util.Arrays;

public class LC312 {
    //dp[i][j] = Max(dp[i][k] + dp[k][j] + nums[i] * num[j] * nums[k])
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        int[] val = new int[nums.length + 2];
        val[0] = val[nums.length + 1] = 1;
        System.arraycopy(nums, 0, val, 1, nums.length);
        for (int n = 2; n < val.length; n++) {
            for (int i = 0; i + n < val.length; i++) {
                int j = n + i;
                for (int k = i + 1; k < j; k++) {
                    int temp = dp[i][k] + dp[k][j];
                    temp += val[i] * val[j] * val[k];
                    dp[i][j] = Math.max(dp[i][j], temp);
                }
            }
        }
        return dp[0][nums.length + 1];
    }

    public static void main(String[] args) {
        System.out.println(new LC312().maxCoins(new int[]{3, 1, 5, 8}));
    }
}
