package bit;

public class LC231 {

    public boolean isPowerOfTwo(int n) {
        if (n < 0)
            return false;
        boolean res = false;
        while (n != 0) {
            n &= n - 1;
            if (res)
                return false;
            res = true;
        }
        return res;
    }

}
