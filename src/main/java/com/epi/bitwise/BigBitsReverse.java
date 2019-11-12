package com.epi.bitwise;

import java.util.Arrays;

/*
1 if the number of 1 is odd
0 if even
 */
public class BigBitsReverse {
    int[] revesalCache = new int[(int) Math.pow(2, 16)];
    BigBitsReverse() {
        Arrays.fill(revesalCache, -1);
    }

    public long reverseBits(long x) {
        final int MASK_SIZE = 16;
        final int BIT_MASK = 0xffff;
        int firstQuadrant = (int) ( x & BIT_MASK);
        int sndQ = (int) ( (x >>> MASK_SIZE) & BIT_MASK);
        int thrQ = (int) ( (x >>> 2 * MASK_SIZE) & BIT_MASK);
        int fourQ = (int) ( (x >>> 3 * MASK_SIZE) & BIT_MASK);

        return getReverse(firstQuadrant) << (MASK_SIZE * 3) |
                getReverse(sndQ) << (MASK_SIZE * 2) |
                getReverse(thrQ) << MASK_SIZE |
                getReverse(fourQ);


    }

    private long getReverse(int number) {
        if (revesalCache[number] == -1) {
            revesalCache[number] = reverseOfInt(number);
            return (long) revesalCache[number];
        } else {
            return (long) revesalCache[number];
        }

    }

    public int reverseOfInt(int x) {
        PrintUtils.printIntToBinary(x);
        int i = 15;
        int j = 0;
        while (i > 8) {
            if (((x >>> i) & 1 ) != ((x >>> j) & 1)) {
                int bitMask = (1 << i) | (1 << j);

                x ^= bitMask;
            }
            i--;
            j++;
        }
        PrintUtils.printIntToBinary(x);
        return x;

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
