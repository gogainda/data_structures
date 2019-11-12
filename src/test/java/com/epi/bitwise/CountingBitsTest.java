package com.epi.bitwise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingBitsTest {
    @Test
    void test() {
        int x = 11;
        System.out.println("init" + printIntToBinary());

        System.out.println("init" + Integer.toBinaryString(x - 1));
        System.out.println("init" + Integer.toBinaryString(~(x - 1)));

        System.out.println("init" + Integer.toBinaryString(x & ~(x - 1)));
//        assertEquals(5, CountingBits.countBits(244));
    }

    private static String printIntToBinary() {
        return String.format("%32s",Integer.toBinaryString(11)).replace(" ", "0");
    }

}