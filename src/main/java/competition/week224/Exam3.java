package competition.week224;

import java.util.HashMap;
import java.util.Map;

public class Exam3 {
    //dp[i][j] 代表前 i 列，以 [i][j] 结尾的方块的最大值是多少
    public int largestSubmatrix(int[][] matrix) {
        int temp = largestSubmatrix(matrix, 0, matrix.length - 1, 0);
        return temp * temp;
    }
    //一定是从最左边开始的

    /**
     *
     * @param matrix 原数组
     * @param start 起始行
     * @param end 结束行
     * @param n 开始列
     * @return 长方形最多有多长
     */
    private int largestSubmatrix(int [][]matrix, int start, int end, int n){
        if(n == matrix.length - 1){
            int res = 0;
            int max = 0;
            for (int i = start; i <= end; i++) {
                if(matrix[n][i] == 1){
                    max++;
                }else {
                    max = 0;
                }
                res = Math.max(res,max);
            }
            return res;
        }

        int nowStart = -1;
        int nowEnd = -1;
        int max = 0;
        for (int i = start; i <= end; i++) {
            if(matrix[i][n] == 0){
                if(nowEnd != -1){
                    max = Math.max(largestSubmatrix(matrix,nowStart, nowEnd - 1, n + 1), max);
                }
                nowEnd = -1;
                nowStart = -1;
            }else {
                if(nowStart == -1){
                    nowStart = i;
                }
                nowEnd = i;
            }
        }
        if(nowEnd != -1){
            max = Math.max(largestSubmatrix(matrix,nowStart, nowEnd, n + 1), max);
        }
        return max + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Exam3().largestSubmatrix(new int[][]{{0, 0, 1}, {1, 1, 1}, {1, 0, 1}}));
    }


}
