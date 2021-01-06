package dp;

public class LC213 {
    public int rob(int[] nums) {
        int length = nums.length;
        int[] res = new int[length + 1];
        res[0] = nums[0];
        if (length == 1) {
            return res[length - 1];
        }
        res[1] = Math.max(nums[0], nums[1]);
        if (length == 2)
            return res[length - 1];
        for (int i = 2; i < length; i++) {
            res[i] = Math.max(nums[i] + res[i - 2], res[i - 1]);
        }
        int[] res1 = new int[length + 1];
        res1[1] = nums[1];
        res1[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < length; i++) {
            res1[i] = Math.max(nums[i] + res1[i - 2], res1[i - 1]);
        }
        return Math.max(res[length - 2], res1[length - 1]);
    }

    public static void main(String[] args) {
        //6, 6, 16, 16, 18, 26, 26, 31, 36, 36, 39, 0
                                                   //0, 3, 10, 16, 16, 26, 26, 31, 36, 36, 39, 0
        System.out.println(new LC213().rob(new int[]{6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3}));
    }

}
