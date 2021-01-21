package search;

import java.util.*;

public class LC37 {
    public void solveSudoku(char[][] board) {
        //1.遍历数独，给每个单元格定义一个可能的解
        //2.递归假设这些可能的解，直到找到正确的解
        solveSudoku(board, getProbable(board));
    }

    /**
     * @param board 当前的值
     * @param probableVal 所有未填的值都包含在里面，如果 set.size 等于 0，则代表当前位置没有解
     * @return 是否有解.如果有解，则将接下来的所有值都填写完毕，如果没解，则不改变原数组
     */
    public boolean solveSudoku(char[][]board, Map<String,Set<Character>> probableVal){
        if(probableVal.size() == 0){
            return true;
        }
        int min = Integer.MAX_VALUE;
        String minKey = "";

        Set<Map.Entry<String, Set<Character>>> probableSet = probableVal.entrySet();
        for (Map.Entry<String, Set<Character>> probableEntry : probableSet) {
            String key = probableEntry.getKey();
            Set<Character> valueSet = probableEntry.getValue();
            if(valueSet.size() == 0)
                return false;
            if(valueSet.size() < min){
                min = valueSet.size();
                minKey = key;
            }
        }
        String key = minKey;
        int i = key.charAt(0) - '0';
        int j = key.charAt(1) - '0';
        Set<Character> valueSet = probableVal.get(minKey);
        for (Character c : valueSet) {
            board[i][j] = c;
            if(solveSudoku(board,getProbable(board)))
                return true;
            else
                board[i][j] = '.';
        }
        return false;
    }


    public Map<String,Set<Character>> getProbable(char[][] board) {
        Map<String, Set<Character>> resMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    resMap.put(i + "" + j, new HashSet<>(new ArrayList<>(List.of('1', '2', '3', '4', '5', '6', '7', '8', '9'))));
                }
            }
        }
        //第 i 行的第 j 个元素是否存在。第 i 列的第 j 个元素是否存在，第 i 个区域的第
        boolean[][] horizontalSet = new boolean[9][9], verticalSet = new boolean[9][9], regionSet = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                int index = board[i][j] - '1';
                if (c == '.') continue;
                horizontalSet[i][index] = true;
                verticalSet[j][index] = true;
                regionSet[getRegion(i,j)][index] = true;
            }
        }
        Set<Map.Entry<String, Set<Character>>> entries = resMap.entrySet();
        for (Map.Entry<String, Set<Character>> entry : entries) {
            int i = entry.getKey().charAt(0) - '0';
            int j = entry.getKey().charAt(1) - '0';
            Set<Character> set = entry.getValue();
            //去除该行,该列，该区域已经有的元素
            for (int k = 0; k < 9; k++) {
                if(verticalSet[j][k] || horizontalSet[i][k] || regionSet[getRegion(i,j)][k])
                    set.remove((char)(k + '1'));
            }
        }
        return resMap;
    }

    private int getRegion(int i, int j){
        return (i / 3) * 3 + (j / 3);
    }


    public static void main(String[] args) {
        new LC37().solveSudoku(new char[][]{
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
