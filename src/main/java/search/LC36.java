package search;

import java.util.HashSet;
import java.util.Set;

public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] horizontalSet = new boolean[9][9], verticalSet = new boolean[9][9], regionSet = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                int index = board[i][j] - '0' - 1;
                if(c == '.') continue;
                if(horizontalSet[i][index] || verticalSet[j][index] || regionSet[((i / 3) * 3 + (j / 3))][index])
                    return false;
                horizontalSet[i][index] = true;
                verticalSet[j][index] = true;
                regionSet[((i / 3) * 3 + (j / 3))][index] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new LC36().isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
    }
}
