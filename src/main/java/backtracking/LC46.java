package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC46 {
    boolean[] vis;
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        vis = new boolean[nums.length];
        backTrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, int first, List<Integer> output) {
        if (first == nums.length) {
            res.add(List.copyOf(output));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            output.add(nums[i]);
            backTrack(nums, first + 1, output);
            output.remove(output.size() - 1);
            vis[i] = false;
        }
    }


    public static void main(String[] args) {
        System.out.println(new LC46().permute(new int[]{1,2,3}));
    }

}
