package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC403 {

    //dp[i][j] 代表青蛙在序号为 i 的单元格位置上，且接下来可以跳 j - 1, j, j + 1 步
    //dp[i][j] = true -> for x in [j - 1, j, j + 1] : if(stones[i + x] = 1) dp[i + x][x] = true
    public boolean canCross(int[] stones) {

        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for (int value : stones) {
            map.put(value, new HashSet<>());
        }

        map.get(0).add(0);

        for (int stone : stones) {
            for (Integer k : map.get(stone)) {
                for (int j = k - 1; j <= k + 1; j++) {
                    if (j > 0 && map.containsKey(stone + j))
                        map.get(stone + j).add(j);
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }

    /**
     * 我的解法，因为int 数组太长了
     */
//    public boolean canCross(int[] stones) {
//        int[] river = new int[stones[stones.length - 1] + 1];
//        boolean [][]dp = new boolean[river.length][river.length];
//        for (int stone : stones) {
//            river[stone] = 1;
//        }
//        int first = stones[0];
//        dp[first][0] = true;
//        for (int i = first; i < river.length; i++) {
//            if(river[i] == 1){
//                for (int j = 0; j < dp[i].length; j++) {
//                    if(dp[i][j]){
//                        int next;
//                        //如果上一步只跳了 1 步，就不能选择跳 0 步了
//                        next = i + j - 1;
//                        if(j - 1 > 0 && next < river.length){
//                            if(river[next] == 1){
//                                dp[next][j - 1] = true;
//                            }
//                        }
//                        //如果上一步大于 0 才可以选择这一种跳法
//                        next = i + j;
//                        if(j > 0  && next < river.length){
//                            if(river[next] == 1){
//                                dp[next][j] = true;
//                            }
//                        }
//                        next = i + j + 1;
//                        if(next < river.length){
//                            if(river[next] == 1){
//                                dp[next][j + 1] = true;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        int endStone = stones[stones.length - 1];
//        for (int i = 0; i < river.length; i++) {
//            if(dp[endStone][i]){
//                return true;
//            }
//        }
//        return false;
//    }


    public static void main(String[] args) {
        System.out.println(new LC403().canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }
}
