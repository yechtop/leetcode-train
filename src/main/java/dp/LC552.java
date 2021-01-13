package dp;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class LC552 {

    //resLP[i] = resLP[i-4]
    //5
    //0*4,1*3,2*2,3*1,4*0
    //res[i] = ∑(k∈0,n-1) (resLP[k] * resLP[i-k-1])
    public int checkRecord(int n) {
        long M = 1000000007;
        long[] resLP = new long[n + 4];
        resLP[0] = 1;
        resLP[1] = 2;
        resLP[2] = 4;
        resLP[3] = 7;
        for (int i = 4; i < resLP.length; i++) {
            resLP[i] = ((2 * resLP[i - 1]) % M + (M - resLP[i - 4])) % M;
        }
        long res = resLP[n];
        for (int i = 0; i < n; i++) {
            res += ((resLP[i] * resLP[n - i - 1]) % M);
        }
        return (int) (res % M);
    }

}






















