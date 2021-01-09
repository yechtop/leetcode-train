package dp;

public class LC122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] res = new int[len];
        res[0] = 0;
        if (len == 1)
            return res[0];
        res[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < len; i++) {
            res[i] = Math.max(res[i - 1], res[i - 1] + prices[i] - prices[i - 1]);
        }
        return res[len - 1];
    }

    public static void main(String[] args) {
        new LC122().maxProfit(new int[]{1,2,3,4,5});
    }
}
