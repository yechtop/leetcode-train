package bit;

import java.util.Arrays;

public class LC338 {

    //    给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
//    示例 1:
//
//    输入: 2
//    输出: [0,1,1]
//    示例 2:
//
//    输入: 5
//    输出: [0,1,1,2,1,2]

    //   01011
    //   01100
        public int[] countBits(int num) {
            int []ans = new int[num + 1];
            for (int i = 1; i <= num; i++) {
                ans[i] = ans[i & (i - 1)] + 1;
            }
            return ans;
        }
//        public int[] countBits(int num) {
//            int []ans = new int[num + 1];
//            for (int i = 1; i <= num; i++) {
//                ans[i] = ans[i >> 1] + (i & 1);
//            }
//            return ans;
//        }


    //1. 计算 ans[1] = ans[0] + 1
    //2. 计算 ans[2] = ans[0] + 1
    //3. 计算 ans[3] = ans[1] + 1
//    public int[] countBits(int num) {
//        int[] ans = new int[num + 1];
//        int i = 0, b = 1;
//        // [0, b) is calculated
//        while (b <= num) {
//            // generate [b, 2b) or [b, num) from [0, b)
//            while (i < b && i + b <= num) {
//                ans[i + b] = ans[i] + 1;
//                ++i;
//            }
//            i = 0;   // reset i
//            b <<= 1; // b = 2b
//        }
//        return ans;
//    }


//    public int[] countBits(int num) {
//        int[] res = new int[num + 1];
//        res[0] = 0;
//        for (int i = 1; i <= num; i++) {
//            int lastNum = i - 1;
//            //获取该数字最低位 1 的位置
//            int last1 = lastNum & (-lastNum);
//            //如果最低位大于 1，则无需进位，res[i] = res[i - 1] + 1
//            if(last1 > 1){
//                res[i] = res[i - 1] + 1;
//            }else {
//                int last0 = (lastNum + 1) & (-(lastNum + 1));
//                int temp = 0;
//                while (last0 != 0){
//                    last0 >>= 1;
//                    temp++;
//                }
//                res[i] = res[i - 1] + 2 - temp;
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC338().countBits(5)));
    }
}
