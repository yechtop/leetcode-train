package dp;

import java.util.Arrays;

public class LC455 {
    public int findContentChildren(int[] g, int[] s) {
        int sIndex = 0;
        int gIndex = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;

        while (sIndex != s.length && g.length != gIndex){
            if(s[sIndex] >= g[gIndex]){
                res++;
                sIndex++;
                gIndex++;
            }else {
                sIndex++;
            }
        }
        return res;
    }
}
