package com.lxc.JZOffer;

public class J16_MyPow {
    public double myPow(double x, int n) {
        double result = 1.0;
        long b = n;
        if (x == 0) {
            return 0;
        }
        if (b == 0) {
            return 1;
        }
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        int count = 1;
        while (b!=0) {
            if ((b & 1) == 1) {
                result *= x;
            }
            x *= x;
            b=b>>1;

        }
        return result;

    }
}
