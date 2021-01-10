package dp;

import javax.swing.*;

public class LC91 {
    //简单写法
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        int pre = 1;
        int curr = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = curr;
            int n = s.charAt(i) - '0';
            int ln = s.charAt(i - 1) - '0';
            if(n == 0){
                if(ln == 1 || ln == 2)
                    curr = pre;
                else
                    return 0;
            }else if(ln == 1 || (ln == 2 && n < 7 && n > 0)){
                curr = pre + curr;
            }
            pre = temp;
        }
        return curr;
    }



    //复杂写法
//    public int numDecodings(String s) {
//        if(s.length() == 1)
//            return s.charAt(0) == '0' ? 0 : 1;
//        int[] res = new int[s.length()];
//        if (s.charAt(0) == '0')
//            return 0;
//        else
//            res[0] = 1;
//        if(canCombination(s.charAt(0) - '0',s.charAt(1) - '0')){
//            res[1] =  s.charAt(1) == '0' ? 1 : 2;
//        }else
//            res[1] = canDivide(-1,s.charAt(0) - '0', s.charAt(1) - '0') ? 1 : 0;
//        for (int i = 2; i < s.length(); i++) {
//            int n = s.charAt(i) - '0';
//            int ln = s.charAt(i - 1) - '0';
//            int lln = s.charAt(i - 2) - '0';
//            if (!canCombination(ln, n)) {
//                if (canDivide(lln,ln,n)) {
//                    res[i] = res[i - 1];
//                } else
//                    return 0;
//            } else {
//                if (!canDivide(lln,ln,n))
//                    res[i] = res[i - 2];
//                else
//                    res[i] = res[i - 2] + res[i - 1];
//            }
//        }
//        return res[res.length - 1];
//    }
//
//    private boolean canCombination(int first, int end) {
//        return (first == 1) || (first == 2 && end < 7);
//    }
//    private boolean canDivide(int pre, int first, int end){
//        if(pre == -1){
//            if(end == 0 && (first == 1 ||first == 2))
//                return true;
//            if(end == 0)
//                return false;
//            return true;
//        }else {
//            if(canCombination(pre,first)){
//                return end != 0;
//            }else {
//                return first != 0 && end != 0;
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new LC91().numDecodings("30"));
    }
}
