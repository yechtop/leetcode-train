package dp;

public class LC363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            int[] cowSum = new int[matrix.length];
            for (int j = i; j < matrix[0].length; j++) {
                for (int l = 0; l < cowSum.length; l++) {
                    cowSum[l] += matrix[l][j];
                }
                res = Math.max(res, maxSumSubArr(cowSum, k));
            }
        }
        return res;
    }

    //这个其实可以再优化一下
    private int maxSumSubArr(int[] cowSum, int k) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < cowSum.length; i++) {
            int sum = 0;
            for (int j = i; j < cowSum.length; j++) {
                sum += cowSum[j];
                if (sum <= k)
                    res = Math.max(sum, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new LC363().maxSumSubmatrix(new int[][]{{5 ,-4,-3, 4},
//                {-3,-4, 4, 5},
//                {5 ,1 , 5,-4}}, 8));
        System.out.println(new LC363().maxSumSubArr(new int[]{-2, -3, 11}, -2));
    }
}
