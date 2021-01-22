package bit;

public class LC191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // byte 是 2 的八次方，其实只要 2 的 5 次方就能解决问题了
        byte res = 0;
        while (n != 0){
            n  &= (n - 1);
            res++;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(-3 % 2);
        System.out.println(new LC191().hammingWeight(-1));
    }

}
