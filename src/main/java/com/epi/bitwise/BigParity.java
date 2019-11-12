package com.epi.bitwise;

import java.util.Arrays;

/*
1 if the number of 1 is odd
0 if even
 */
public class BigParity {
    int[] cache = new int[(int) Math.pow(2, 16)];
    BigParity() {
        Arrays.fill(cache, -1);
    }

    public short parityOfLong(long x) {
        final int MASK_SIZE = 16;
        final int BIT_MASK = 0xffff;
        int firstQuadrant = (int) ((x >>> MASK_SIZE * 3) & BIT_MASK);
        int secondQuadrant= (int) ((x >>> MASK_SIZE * 2) & BIT_MASK);
        int thirdQuadrant = (int) ((x >>> MASK_SIZE * 1) & BIT_MASK);
        int forthQuadrant = (int) (x  & BIT_MASK);
        //short ^ short promoted to int
        return (short) (getParityForNQuadrant(firstQuadrant) ^ getParityForNQuadrant(secondQuadrant) ^ getParityForNQuadrant(thirdQuadrant) ^ getParityForNQuadrant(forthQuadrant));

    }

    private int getParityForNQuadrant(int firstQuadrant) {
        if (cache[firstQuadrant] == -1) {
            cache[firstQuadrant] = parityOfInt(firstQuadrant);
            return cache[firstQuadrant];
        } else {
            return cache[firstQuadrant];
        }

    }

    private int parityOfInt(int x) {
        int result = 0;
        while (x !=0) {
            x = x & (x - 1);
            result ^= 1;
        }
        return result;

    }

    public short fastParityOfLong(long x) {
        PrintUtils.printIntToBinary(x);
        PrintUtils.printIntToBinary(x >>> 32);
        PrintUtils.printIntToBinary(x ^ x >>> 32);
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short) (x & 0x1);
    }
}
