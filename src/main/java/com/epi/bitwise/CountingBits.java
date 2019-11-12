package com.epi.bitwise;

public class CountingBits {
    public static short countBits(int x) {
        System.out.println("init" + Integer.toBinaryString(x));
        short bits = 0;
        while (x != 0) {
            bits += x & 1;
            x >>>= 1;
            System.out.println(Integer.toBinaryString(x));
        }
        return bits;

    }
}
