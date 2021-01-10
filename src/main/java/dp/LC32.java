package dp;

public class LC32 {
    //dp[i] 代表以 i 结尾的最长子字符串的长度
    public int longestValidParentheses(String s) {
        if( s== null || s.length() < 2)
            return 0;
        int [] dp = new int[s.length()];
        if(s.charAt(0) == '(' && s.charAt(1) == ')')
            dp[1] = 2;
        int max = dp[1];

        for (int i = 2; i < s.length(); i++) {
            char nowC = s.charAt(i);
            if(nowC == '('){
                dp[i] = 0;
            }else {
                if(s.charAt(i - 1) == '('){
                    dp[i] = dp[i - 2] + 2;
                }else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    if(i - dp[i - 1]  >= 2)
                        dp[i] = dp[i - dp[i - 1] - 2] + dp[i - 1] + 2;
                    else
                        dp[i] = dp[i - 1] + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
    }
}
