package sort;

import java.util.Arrays;
import java.util.LinkedList;

public class LC242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int [] charArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i) - 'a']++;
            charArr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(charArr[i] != 0)
                return false;
        }
        return true;
    }

}
