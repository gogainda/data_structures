package com.epi.bitwise;

import com.epi.bitwise.BigParity;
import com.epi.bitwise.PrintUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

class BigParityTest {

    @Test
    void parity1() {
        BigParity bigParity = new BigParity();
        Random r = new Random();
        for(double i = 0; i < 10; i++) {
            bigParity.fastParityOfLong(r.nextLong()) ;
        }
    System.out.println(Arrays.toString(bigParity.cache));
    }

    @Test
    void rightPropagate() {
        int v = 0b01010000;
        PrintUtils.printIntToBinary(v );
        PrintUtils.printIntToBinary(v & (v - 1) );
        PrintUtils.printIntToBinary(v & ~(v - 1) );
    }

    @Test
    void modPowerOfTwo() {
        int v1 = 77;
        int v2 = 64;
        PrintUtils.printIntToBinary(v1);
        PrintUtils.printIntToBinary(v2);
        PrintUtils.printIntToBinary(v2 - 1);
        PrintUtils.printIntToBinary(v2 - 1 & v1);
    System.out.println(v2 - 1 & v1);
    }

}