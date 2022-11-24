package com.geopokrovskiy.util;

/**
 * This class contains the utility which calculates the
 * Greatest Common Divisor of a and b
 * and
 * Least Common Multiple of and b
 */
public class MathUtil {

    /**
     * calculates the
     * Greatest Common Divisor of a and b
     *
     * @param a
     * @param b
     * @return
     */
    public static int findGCD(int a, int b) {
        if (a == 0) {
            return 1;
        }
        int aIsNegative = (a < 0) ? -1 : 1;
        int bIsNegative = (b < 0) ? -1 : 1;

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == b) {
            return a * aIsNegative * bIsNegative;
        } else {
            int max = (a > b) ? a : b;
            int min = (a > b) ? b : a;
            a = max - min;
            b = min;
            return findGCD(a * aIsNegative, b * bIsNegative);
        }
    }
}
