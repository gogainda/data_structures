package com.epi.bitwise;

public class SwapBits {
    public static long swapBits(long x, int i, int j) {
        if (((x >>> i) & 1 ) != ((x >>> j) & 1)) {
            long bitMask = (1l << i) | (1L << j);
            PrintUtils.printIntToBinary(1l << i);
            PrintUtils.printIntToBinary(1L << j);
            PrintUtils.printIntToBinary(bitMask);
            x ^= bitMask;
        }
        return x;
    }
}
