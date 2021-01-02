package dp;

public class LC70 {
    //dpTable[i] 代表上 i 阶楼梯最少需要几步
    public int climbStairs(int n) {
        int[] dpTable = new int[n + 1];
        dpTable[1] = 1;
        dpTable[0] = 1;
        for (int i = 2; i <= n; i++) {
            dpTable[i] = dpTable[i - 1] + dpTable[i - 2];
        }
        return dpTable[n];
    }

}
