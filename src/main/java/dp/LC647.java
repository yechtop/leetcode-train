package dp;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class LC647 {

    /**
     * 优化写法
     */
    public int countSubstrings(String s){
        int n = s.length(),ans = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }


    //f[i][j] 代表 i-j 的子串是不是回文
    //f[i][j] = f[i-1][j-1] & s[i] == s[j]
    //ff[i] 代表第 i 位往回有多少个回文子串
    //dp[i] 代表 0,i 上有多少回文子串
    //dp[i] = dp[i-1] + ff[i]
//    public int countSubstrings(String s) {
//        boolean[][] f = new boolean[s.length()][s.length()];
//        int[] ff = new int[s.length()];
//        //j - i = n
//        for (int n = 0; n < s.length(); n++) {
//            for (int i = 0; i + n < s.length(); i++) {
//                int j = i + n;
//                if (n == 0) {
//                    f[i][j] = true;
//                } else {
//                    boolean equals = (s.charAt(i) == s.charAt(j));
//                    if (n == 1) {
//                        f[i][j] = equals;
//                    } else {
//                        f[i][j] = f[i + 1][j - 1] & equals;
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < s.length(); i++) {
//            int sum = 1;
//            for (int j = i - 1; j >= 0; j--) {
//                if(f[j][i]){
//                    sum++;
//                }
//            }
//            ff[i] = sum;
//        }
//        int res = 1;
//        for (int i = 1; i < s.length(); i++) {
//            res += ff[i];
//        }
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(new LC647().countSubstrings("aaa"));
    }

}
