package sort;

import java.util.HashMap;
import java.util.Set;

public class LC493 {
    /**
     * 冒泡排序，会超时
     */
//    public int reversePairs(int[] nums) {
//        long [] doubleNums = new long[nums.length];
//        int len = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            doubleNums[i] = ((long) nums[i] << 1);
//        }
//        int res = 0;
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if(nums[i] > doubleNums[j]){
//                    res ++;
//                }
//            }
//        }
//        return res;
//    }
//    public int reversePairs(int[] nums) {
//
//
//        long [] doubleNums = new long[nums.length];
//        //记录 n 出现的次数
//        int[] countMap = new int[Integer.MAX_VALUE];
//        //记录 大于 n 的数出现的次数
//        int[] sumMap = new int[Integer.MAX_VALUE];
//
//        int res = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            doubleNums[i] = (nums[i] << 1);
//        }
//        for (int num : nums) {
//            res += sumMap[2 * num];
//            countMap[num]++;
//            updateSumMap(sumMap,countMap);
//        }
//        return res;
//
//    }
//
//    private void updateSumMap(int[] sumMap, int[] countMap) {
//        int now = 0;
//        for (int i = Integer.MAX_VALUE - 1; i >= 0; i--) {
//            sumMap[i] += now;
//            now += countMap[i];
//        }
//    }

    //官方题解
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    public int reversePairsRecursive(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = reversePairsRecursive(nums, left, mid);
            int n2 = reversePairsRecursive(nums, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int j = mid + 1;
            while (i <= mid) {
                while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                    j++;
                }
                ret += j - mid - 1;
                i++;
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = nums[p2++];
                } else if (p2 > right) {
                    sorted[p++] = nums[p1++];
                } else {
                    if (nums[p1] < nums[p2]) {
                        sorted[p++] = nums[p1++];
                    } else {
                        sorted[p++] = nums[p2++];
                    }
                }
            }
            for (int k = 0; k < sorted.length; k++) {
                nums[left + k] = sorted[k];
            }
            return ret;
        }
    }

}
