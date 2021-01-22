package search;

import java.util.*;

public class LC773 {

    //1,2,3
    //4,5,0
    public int slidingPuzzle(int[][] board) {
        if(change(board) == 123450)
            return 0;
        HashSet<Integer> visit = new HashSet<>();
        int start = change(board);
        visit.add(start);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (bfs(toChange(queue.poll()), queue, visit)) {
                    return step + 1;
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LC773().slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));
    }

    private boolean bfs(int[][] board, Queue<Integer> queue, HashSet<Integer> visit) {

        int[][] all = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int nowI = 0, nowJ = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0){
                    nowI = i;
                    nowJ = j;
                }
            }
        }

        for (int[] change : all) {
            int i = nowI + change[0];
            int j = nowJ + change[1];
            if(i >= 0 && j >= 0 && i < board.length && j < board[0].length){
                int temp = board[i][j];
                board[i][j] = board[nowI][nowJ];
                board[nowI][nowJ] = temp;
                int res = change(board);
                if(res == 123450){
                    return true;
                }
                if(!visit.contains(res)){
                    queue.add(res);
                    visit.add(res);
                }

                temp = board[i][j];
                board[i][j] = board[nowI][nowJ];
                board[nowI][nowJ] = temp;
            }
        }
        return false;
    }

    public int[][] toChange(int val){
        return new int[][]{
                {val / 100000, (val / 10000) % 10, (val / 1000) % 10},
                {(val / 100) % 10, (val / 10) % 10, val % 10}};
    }

    public int change(int[][] board) {
        return (board[0][0] * 100000)
                + (board[0][1] * 10000)
                + (board[0][2] * 1000)
                + (board[1][0] * 100)
                + (board[1][1] * 10)
                + (board[1][2]);
    }
}
