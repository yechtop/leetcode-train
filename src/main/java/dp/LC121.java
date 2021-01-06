package dp;

public class LC121 {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int nowMix = Math.min(prices[0], prices[1]);
        int res = Math.max(prices[1] - prices[0], 0);
        for (int i = 2; i < prices.length; i++) {
            res = Math.max(prices[i] - nowMix, res);
            nowMix = Math.min(prices[i], nowMix);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC121().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
