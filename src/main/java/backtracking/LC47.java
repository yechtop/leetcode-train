package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47 {
    boolean[] vis;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        permute(nums, 0, new ArrayList<>());
        return res;
    }

    public void permute(int[] nums, int start, List<Integer> perm) {
        if (start == nums.length) {
            res.add(new ArrayList<>(perm));
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            permute(nums, start + 1, perm);
            vis[i] = false;
            perm.remove(start);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC47().permuteUnique(new int[]{1, 1,1, 2}));
    }

}
