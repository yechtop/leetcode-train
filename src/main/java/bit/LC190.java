package bit;

public class LC190 {


    //00000010100101000001111010011100
    //00000010100101000001111010011100
    //00111001011110000010100101000000
    public int reverseBits(int n) {

        int leftBit = Integer.MIN_VALUE;
        int rightBit = 1;

        for (byte i = 0; i < 16; i++) {
            if ((((n & leftBit) != 0) && ((n & rightBit) != 0)) || ((((n & leftBit) == 0) && ((n & rightBit) == 0)))) {
                rightBit <<= 1;
                leftBit >>>= 1;
                continue;
            }
            if((n & rightBit) == 0){
                n = (n | rightBit);
                n = (n & (~leftBit));
            }else {
                n = (n | leftBit);
                n = (n & (~rightBit));
            }

            rightBit <<= 1;
            leftBit >>>= 1;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new LC190().reverseBits(43261596));
    }

}
