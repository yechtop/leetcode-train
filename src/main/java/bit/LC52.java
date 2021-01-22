package bit;

import java.util.ArrayList;
import java.util.List;

public class LC52 {
    //0代表可以放置，1代表已经放置
    public int totalNQueens(int n) {
        return solve(n, (short)0, (short)0, (short)0, (short)0);
    }
//最无赖的写法
//return new short[]{1,1,0,0,2,10,4,40,92,352}[n];

    private int solve(int n, int row, short columns, short diagonals1, short diagonals2) {
        if (n == row) {
            return 1;
        } else {
            short count = 0;
            short availablePositions = (short) (((1 << n) - 1) & (~(columns | diagonals1 | diagonals2)));
            while (availablePositions != 0) {
                //x & (−x) 可以获得 x 的二进制表示中的最低位的 1 的位置；
                short position = (short) (availablePositions & (-availablePositions));
                //x & (x−1) 可以将 x 的二进制表示中的最低位的 1 置成 0
                availablePositions = (short) (availablePositions & (availablePositions - 1));
                count += solve(n, row + 1, (short)(columns | position), (short)((diagonals1 | position) << 1), (short)((diagonals2 | position) >> 1));

            }
            return count;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new LC52().totalNQueens(i));
        }
    }



}
