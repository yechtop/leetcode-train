package dp;

import java.util.Arrays;

public class LC45 {
    //动态规划版本，速度较慢
//    public int jump(int[] nums) {
//        int[] res = new int[nums.length];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = i;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
//                res[i + j] = Math.min(res[i + j], res[i] + 1);
//            }
//        }
//        return res[nums.length  - 1];
//    }
    //O(N) 算法
    public int jump(int[] nums) {
        int end = 0;
        int maxPos = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if(i == end){
                res++;
                end = maxPos;
            }
        }
        return res;
    }
}
