package dp;

import java.util.HashMap;
import java.util.HashSet;

public class LC76 {
    //dp[i]存储了t中
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        String res = "";
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(tMap.containsKey(c)){
                tMap.put(c, tMap.get(c) + 1);
            }else {
                tMap.put(c, 1);
            }
        }
        HashSet<Character> suitableSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sMap.containsKey(c)) {
                int value = sMap.get(c) + 1;
                sMap.put(c, value);
                if(value >= tMap.get(c)){
                    suitableSet.add(c);
                }
            } else if (tMap.containsKey(c)) {
                sMap.put(c, 1);
                if(sMap.get(c) >= tMap.get(c)){
                    suitableSet.add(c);
                }
            }
            //开始收缩
            if (tMap.containsKey(c) && suitableSet.size() == tMap.size()) {
                while (start <= i) {
                    char startC = s.charAt(start);
                    if(!sMap.containsKey(startC)){
                        start++;
                        continue;
                    }
                    //如果已经当前字符在 tMap 中的次数等于在 sMap 中的次数，就没有必要重复了
                    if (sMap.get(startC).equals(tMap.get(startC))) {
                        //len = i - start + 1
                        if(i - start < min){
                            min = i - start;
                            res = s.substring(start, i + 1);
                        }
                        break;
                    } else {
                        if(tMap.containsKey(startC)){
                            sMap.put(startC,sMap.get(startC) - 1);
                        }
                        start++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC76().minWindow("a", "a"));
    }
}
