package dp;

public class LC221 {
    public int maximalSquare(char[][] matrix) {
        int[][] num1 = new int[matrix.length][matrix[0].length];
        int[][] num2 = new int[matrix.length][matrix[0].length];
        int[][] res = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            int max = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                max = matrix[i][j] == '1' ? max + 1 : 0;
                num1[i][j] = max;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                max = matrix[i][j] == '1' ? max + 1 : 0;
                num2[i][j] = max;
                if(matrix[i][j] == '1')
                    ans = 1;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            res[i][0] = matrix[i][0] == '1' ? 1 : 0;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            res[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    res[i][j] = 0;
                } else {
                    int last = res[i - 1][j - 1];
                    res[i][j] = Math.min(last + 1, Math.min(num1[i][j], num2[i][j]));
                }
                ans = Math.max(ans,res[i][j]);
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        new LC221().maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
}
