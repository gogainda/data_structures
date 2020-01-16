package com.epi.bitwise;

public class PrimitiveMultiply {
    public static long multiply(long x, long y) {
        PrintUtils.printIntToBinary(x);
        PrintUtils.printIntToBinary(y);
        long sum = 0;
        while (x != 0) {
            if ((x & 1 ) != 0) {
                sum = add(sum, y);

            }
            x >>>= 1;
            y <<= 1;
            PrintUtils.printIntToBinary(x);
            PrintUtils.printIntToBinary(y);
        }
        return sum;
    }

    public static long add(long a, long b) {
        while (b != 0) {
            long carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
