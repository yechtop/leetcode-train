package tree;

import java.util.HashMap;
import java.util.Map;

public class LC200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    run(grid, i, j);
                }
            }
        }
        return res;
    }

    // 判断当前是否可以走，并且走接下来的路
    public void run(char[][] grid, int m, int n) {
        if (grid[m][n] == '1') {
            grid[m][n] = '2';
        } else {
            return;
        }
        int[][] goArr = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] go : goArr) {
            int i = m + go[0];
            int j = n + go[1];
            if (i >= 0 && i < grid.length
                    && j >= 0 && j < grid[0].length
                    && (grid[i][j] == '1')) {
                run(grid, i, j);
            }
        }
    }

    public static void main(String[] args) {
        new LC200().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}});
    }
}