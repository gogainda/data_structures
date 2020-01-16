package com.epi.bitwise;

public class ClosestIntSameWeight {
    public static long closestIntSameWeight(long x) {
        final int NUM_UNSIGNED_BITS = 63;

        for(int i = 0; i < NUM_UNSIGNED_BITS; ++i) {
            if (((x >>> i) & 1) != ((x >>> (i + 1)) & 1)) {
                x ^= (1L << i) | (1L << (i + 1));
                return x;
            }
        }
        throw new IllegalArgumentException("All bits are 0 or 1");
    }

    public static long closestIntSameWeight2(long n) {
        PrintUtils.printIntToBinary(n);
        if(n <= 0 /* If all 0s */ || (n+1) == Long.MAX_VALUE /* n is MAX_INT */)
            return -1;
        long neg = ~n;
        long rightmostSetBit = n&~(n-1);
        PrintUtils.printIntToBinary(rightmostSetBit);
        long rightmostNotSetBit = neg&~(neg-1);
        PrintUtils.printIntToBinary(rightmostNotSetBit);
        if(rightmostNotSetBit > rightmostSetBit){
            PrintUtils.printIntToBinary(rightmostNotSetBit - (rightmostNotSetBit >> 1));
            return (n + (rightmostNotSetBit - (rightmostNotSetBit >> 1)));
        }
        PrintUtils.printIntToBinary(rightmostSetBit - (rightmostSetBit >> 1));
        return (n - (rightmostSetBit - (rightmostSetBit >> 1)));
    }


}
