package dp;

import java.util.List;

public class LC53 {
    //O(n) 做法
    public int maxSubArray(int[] nums) {
        int preSum = 0;
        int res = nums[0];
        for (int num : nums) {
            preSum += num;
            res = Math.max(res, preSum);
            preSum = Math.max(0, preSum);
        }
        return res;
    }

    //分治做法
    public int maxSubArray_divide(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return maxSubArray_divide(nums, 0, nums.length - 1);
    }

    //分治做法
    public int maxSubArray_divide(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int middle = (right + left) / 2;
        int leftMax = maxSubArray_divide(nums, left, middle);
        int rightMax = maxSubArray_divide(nums, middle + 1, right);
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = middle; i >= left; i--) {
            sum += nums[i];
            max = Math.max(max, sum);
        }
        int max1 = Integer.MIN_VALUE, sum1 = 0;
        for (int i = middle + 1; i <= right; i++) {
            sum1 += nums[i];
            max1 = Math.max(max1, sum1);
        }
        int middleMax = Math.max(max + max1, Math.max(max, max1));
        return Math.max(Math.max(middleMax, leftMax), rightMax);
    }

    public static void main(String[] args) {
        System.out.println(new LC53().maxSubArray_divide(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
