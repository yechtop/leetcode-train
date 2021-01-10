package dp;

public class LC55 {
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if(i == end){
                if(maxPos <= i )
                    return false;
                end = maxPos;
            }
        }
        return true;
    }
}
