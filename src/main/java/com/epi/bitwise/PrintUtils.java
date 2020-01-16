package com.epi.bitwise;

public class PrintUtils {

    public static void printIntToBinary(int i) {
        System.out.print(String.format("%32s",Integer.toBinaryString(i)).replace(" ", "0"));
        System.out.print("-->");
        System.out.println(i);
    }
    public static void printIntToBinary(long i) {
        System.out.print(String.format("%64s",Long.toBinaryString(i)).replace(" ", "0"));
        System.out.print("-->");
        System.out.println(i);
    }
}
