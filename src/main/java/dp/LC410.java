package dp;

import java.util.Arrays;

public class LC410 {

    //dp[i][j]代表前 i 个元素，分割成 m 次的结果
    //dp[i][j] = for k in (0,j - 1) : MIN(  Math.Max(dp[k][j-1], sum[k+1][i]) )
    public int splitArray(int[] nums, int m) {
        int [][] dp = new int[nums.length][m + 1];
        int[][] sumArr = new int[nums.length][nums.length];
        //代表i到j中的最大值
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            sumArr[i][i] = sum;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                sumArr[i][j] = sum;
            }
        }

        //i：第i个元素
        for (int i = 0; i < nums.length; i++) {
            //j 划分为 j 份
            for (int j = 1; j <= m; j++) {
                //如果划分为 1 份，则直接返回和就行了
                if(j == 1){
                    dp[i][j] = sumArr[0][i];
                }else {
                    int min = Integer.MAX_VALUE;
                    //k 应当在 0 到 i - 1 之间， 同时 k 因为有 k+1 个元素，所以必须 k + 1 >= j - 1
                    for (int k = 0; k < i ; k++) {
                        if(k + 1 >= j - 1)
                            min = Math.min(min, Math.max(dp[k][j - 1], sumArr[k + 1][i]));
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[nums.length - 1][m];
    }


    //dp[i][j][m] 代表 nums 从 i 到 j 分割成 m 份，各分和的各自和的最大值的最小值
    //dp[i][j][m] = for k in [i,j]  min(max(dp[i][k][m/2],dp[k+1][j][m/2]))
    //   2   1   1
    //if( m > j - i + 1 ) dp[i][j][m] = Integer.MAX_VALUE
    //if(m == 1) dp[i][j][m] 最大值

    /**
     * 超时的写法
     */
//    public int splitArray(int[] nums, int m) {
//        int[][][] dp = new int[nums.length][nums.length][m + 1];
//        int[][] sumArr = new int[nums.length][nums.length];
//        //代表i到j中的最大值
//        for (int i = 0; i < nums.length; i++) {
//            int sum = nums[i];
//            sumArr[i][i] = sum;
//            for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                sumArr[i][j] = sum;
//            }
//        }
//
//        //n = r - l 也就是数组的长度-1
//        for (int n = 0; n < nums.length; n++) {
//            //左边从 0 开始，保证右边小于 len
//            for (int l = 0; l + n < nums.length; l++) {
//                int r = l + n;
//                for (int k = 1; k <= m; k++) {
//                    //n + 1 也就是长度，当 m 大于长度，自然就没有结果
//                    if (k > n + 1) {
//                        dp[l][r][k] = Integer.MAX_VALUE;
//                    } else if (k == 1) {//如果 m 为 1 则求的就是 l 到 r 中的和
//                        dp[l][r][k] = sumArr[l][r];
//                    } else {
//                        //l = 1, r = 3
//                        int k2 = k / 2;
//                        int min = Integer.MAX_VALUE;
//                        for (int mid = l; mid < r; mid++) {
//                            min = Math.min(min, Math.max(dp[l][mid][k2], dp[mid + 1][r][k - k2]));
//                        }
//                        dp[l][r][k] = min;
//                    }
//                }
//            }
//        }
//        return dp[0][nums.length - 1][m];
//    }

    public static void main(String[] args) {
        System.out.println(new LC410().splitArray(new int[]{7,2,5,10,8}, 2));
    }
}
