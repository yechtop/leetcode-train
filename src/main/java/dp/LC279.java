package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC279 {

    // 普通递归方法
//    public int numSquares(int n) {
//        int[] squareList = new int[40000];
//        int[] res = new int[n + 3];
//        for (int i = 0; i < squareList.length; i++)
//            squareList[i] = i*i;
//        res[0] = 0;
//        res[1] = 1;
//        //求出 2~n 的所有结果
//        for (int i = 2; i < n + 1; i++) {
//            //遍历 n - squareList 的所有子结果
//            int minTemp = i;
//            for (int j = 1; j < squareList.length; j++) {
//                if(squareList[j] > i)
//                    break;
//                int childRes = res[i - squareList[j]];
//                if(childRes + 1 < minTemp){
//                    minTemp = childRes + 1;
//                }
//            }
//            res[i] = minTemp;
//        }
//        return res[n];
//    }
    // 递归 + 贪心方法

    Set<Integer> squareSet = new HashSet<Integer>();
    public int numSquares(int n) {
        for (int i = 0; i * i <= n; i++)
            squareSet.add(i * i);

        for (int i = 1; i < n; i++) {
            if (canDividedBy(n, i))
                return i;
        }
        return n;
    }

    private boolean canDividedBy(int n, int count) {
        if (count == 1)
            return squareSet.contains(n);
        for (Integer square : squareSet) {
            if (canDividedBy(n - square, count - 1)) {
                return true;
            }
        }
        return false;
    }

}






















