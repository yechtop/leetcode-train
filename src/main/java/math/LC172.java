package math;

import java.util.HashMap;
import java.util.Map;

public class LC172 {

    public int trailingZeroes(int n) {
        if(n == 0)
            return 0;
        int num5 = 0;
        int[] num5Map = new int[n + 5];
        num5Map[5] = 1;

        for (int i = 5; i <= n; i+= 5) {
            if (i % 5 == 0) {
                num5Map[i] = num5Map[i / 5] + 1;
                num5 += num5Map[i];
            }
        }
        return num5;
    }

    public int trailingZeroes1(int n) {
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }

}
