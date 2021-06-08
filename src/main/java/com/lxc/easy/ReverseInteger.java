package com.lxc.easy;

public class ReverseInteger {
    public int reverseBest(int x) {
        long a = 0;
        while (x != 0) {
            a = a * 10 + x % 10;
            x /= 10;
        }
        return (int) a == a ? (int) a : 0;
    }

    public int reverseByString(int x) {

        String stringX = String.valueOf(x);
        char result[] = new char[11];
        int index = 0;
        boolean negative = false;
        if (stringX.charAt(0) == '-') {
            negative = true;
            result[index++] = '-';
        }

        for (int i = stringX.length() - 1; i >= 0; i--) {
            if (negative && i == 0) {
                break;
            }
            result[index++] = stringX.charAt(i);
        }
        int a = 0;
        try {
            a = Integer.parseInt(String.valueOf(result, 0, stringX.length()));
        } catch (Exception e) {
            return 0;
        }

        return a;

    }
}
