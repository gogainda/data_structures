package com.epi.bitwise;

public class PowerXY {
    public static double power(double x, int y) {
        double result = 1;
        int  xPow = 1;
        int prevPow = 0;
        while (prevPow != y) {
            x = x * x;
            xPow++;
            if (xPow + prevPow > y) {
                result = result * x;

                prevPow += 1;
            } else {
                result = result * x;

                prevPow = xPow + prevPow;
            }

        }
        return result;

    }
}
