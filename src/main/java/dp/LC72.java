package dp;

import java.util.HashSet;
import java.util.Set;

public class LC72 {

    //dp[i][j] 代表将 word1.sub(0,i+1)转换为 word2.sub(0,j+1)所需要的最小编辑距离
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0)
            return word2.length();
        if(word2.length() == 0)
            return word1.length();

        int [][]dp = new int[word1.length()][word2.length()];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                boolean equals = word1.charAt(i) == word2.charAt(j);
                if(i > 0 && j > 0){
                    dp[i][j] = Math.min( dp[i - 1][j - 1] + (equals ? 0 : 1), Math.min(dp[i - 1][j], dp[i][j - 1]) + 1) ;
                }else if(i == 0 && j > 0){
                    dp[i][j] = equals ? j : dp[i][j - 1] + 1;
                }else if(i > 0){
                    dp[i][j] = equals ? i : dp[i - 1][j] + 1;
                }
            }
        }
        return dp[word1.length() - 1][word2.length()  - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LC72().minDistance("oooo","ooo"));
    }

}