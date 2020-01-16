package com.epi.bitwise;

public class PrimitiveDivide {
    public static int divide(int x, int y) {
        PrintUtils.printIntToBinary(x);
        PrintUtils.printIntToBinary(y);
        int result = 0;
        int power = 32;
        long yPower = (long) y << power;
        PrintUtils.printIntToBinary(yPower);

        while (x >= y) {
            while(yPower > x) {
                yPower >>>= 1;
                --power;
            }
            PrintUtils.printIntToBinary(yPower);
            result  += 1 << power;
            PrintUtils.printIntToBinary(result);
            x -= yPower;
            PrintUtils.printIntToBinary(x);
        }
        return result;
    }
}
