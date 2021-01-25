package competition.week224;

import java.util.HashMap;
import java.util.Map;

public class Exam2 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> resMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] * nums[j];
                if (resMap.containsKey(temp)) {
                    resMap.put(temp, resMap.get(temp) + 1);
                } else {
                    resMap.put(temp, 1);
                }
            }
        }

        int ans = 0;
        for (Integer value : resMap.values()) {
            if (value != 1) {
                ans += 4 * value * (value - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Exam2().tupleSameProduct(new int[]{2, 3, 5, 7}));
    }
}
