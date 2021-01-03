package dp;

import java.util.List;

public class LC120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int [][] dpTable = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        int min  = Integer.MAX_VALUE;
        dpTable[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < dpTable.length; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int leftVal = Integer.MAX_VALUE;
                int rightVal = Integer.MAX_VALUE;
                if(j > 0){
                    leftVal = dpTable[i-1][j-1];
                }
                if(j < triangle.get(i).size() - 1){
                    rightVal = dpTable[i-1][j];
                }
                dpTable[i][j] = triangle.get(i).get(j) + Math.min(leftVal,rightVal);
            }
        }
        for (int i = 0; i < dpTable[0].length; i++) {
            if(dpTable[triangle.size()-1][i] < min){
                min = dpTable[triangle.size()-1][i];
            }
        }
        return min;
    }
}
