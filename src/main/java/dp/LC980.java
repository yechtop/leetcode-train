package dp;

public class LC980 {
    // 1 表示起始方格
    // 2 表示结束方格
    // 0 表示空白方格
    // -1 表示障碍方格
    int res = 0;
    int endI, endJ;

    public int uniquePathsIII(int[][] grid) {
        int startI = 0, startJ = 0;
        int emptyNums = 0;
        //初始化
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                switch (grid[i][j]) {
                    case 1: {
                        startI = i;
                        startJ = j;
                    }
                    break;
                    case 0:
                        emptyNums++;
                        break;
                    case 2: {
                        endI = i;
                        endJ = j;
                    }
                    break;
                }
            }
        }
        go(grid, emptyNums, startI, startJ);
        return res;
    }

    private void go(int[][] grid, int emptyNums, int nowI, int nowJ) {
        if (emptyNums == -1 && nowI == endI && nowJ == endJ) {
            res++;
        }
        //上
        if (nowI > 0 && (grid[nowI - 1][nowJ] & 1) == 0) {
            grid[nowI - 1][nowJ] = 1;
            go(grid, emptyNums - 1, nowI - 1, nowJ);
            grid[nowI - 1][nowJ] = 0;
        }
        //下
        if (nowI < grid.length - 1 && (grid[nowI + 1][nowJ] & 1) == 0) {
            grid[nowI + 1][nowJ] = 1;
            go(grid, emptyNums - 1, nowI + 1, nowJ);
            grid[nowI + 1][nowJ] = 0;
        }
        //左
        if (nowJ > 0 && (grid[nowI][nowJ - 1] & 1) == 0) {
            grid[nowI][nowJ - 1] = 1;
            go(grid, emptyNums - 1, nowI, nowJ - 1);
            grid[nowI][nowJ - 1] = 0;
        }
        //右
        if (nowJ < grid[0].length - 1 && (grid[nowI][nowJ + 1] & 1) == 0) {
            grid[nowI][nowJ + 1] = 1;
            go(grid, emptyNums - 1, nowI, nowJ + 1);
            grid[nowI][nowJ + 1] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(2 & 1);
        System.out.println(new LC980().uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
    }
}
