package dp;

public class LC1143 {
    //dpTable[i][j] 代表text1.subString(0,i) 和 text2.subString(0,j) 的最长公共子序列长度

    public int longestCommonSubsequence(String text1, String text2) {
        int text2Len = text2.length(), text1Len = text1.length();
        int[][] dpTable = new int[text1Len + 1][text2Len + 1];
        for (int i = 1; i <= text1Len; i++)
            for (int j = 1; j <= text2Len; j++)
                dpTable[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? dpTable[i - 1][j - 1] + 1 : Math.max(dpTable[i - 1][j], dpTable[i][j - 1]);
        return dpTable[text1Len][text2Len];
    }

    public static void main(String[] args) {
        new LC1143().longestCommonSubsequence("bl", "yby");
    }
}
