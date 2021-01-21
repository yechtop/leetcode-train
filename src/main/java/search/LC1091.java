package search;

import java.util.*;
import java.util.stream.Collectors;

public class LC1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        else {
            if(grid.length == 1)
                return 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer nowIndex = queue.poll();
                if (bdf(nowIndex, grid, queue)) {
                    return step + 1;
                }
            }
            step++;
        }
        return -1;
    }

    private boolean bdf(Integer nowIndex, int[][] grid, Queue<Integer> queue) {
        int[][] all = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int k = 0; k < all.length; k++) {
            int i = (nowIndex / 100) + all[k][0];
            int j = (nowIndex % 100) + all[k][1];
            if (i >= 0 && j >= 0 && i < grid.length && j < grid.length) {
                if (grid[i][j] == 1)
                    continue;
                if (i == grid.length - 1 && j == grid.length - 1) {
                    return true;
                }
                queue.add((i * 100) + j);
                grid[i][j] = 1;
            }
        }
        return false;
    }
}
