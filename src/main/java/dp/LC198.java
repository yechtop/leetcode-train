package dp;

public class LC198 {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        int lastLast = nums[0];
        int last = 0;
        int res = lastLast;
        if (nums.length >= 2) {
            last = Math.max(nums[0], nums[1]);
            if(nums.length == 2)
                return last;
        }
        for (int i = 2; i < nums.length; i++) {
            res = Math.max(last, lastLast + nums[i]);
            lastLast = last;
            last = res;
        }
        return res;
    }

}
