package dp;

public class LC63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] path = new int[m][n];
        path[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1)
                    continue;
                //上方的路径
                if(i > 0 && obstacleGrid[i-1][j] != 1){
                    path[i][j] += path[i-1][j];
                }
                //左边的路径
                if(j > 0 && obstacleGrid[i][j-1] != 1){
                    path[i][j] += path[i][j-1];
                }
            }
        }
        return path[m-1][n-1];
    }
}
