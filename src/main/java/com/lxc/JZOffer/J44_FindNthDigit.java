package com.lxc.JZOffer;

public class J44_FindNthDigit {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = 9 * digit * start;
        }
        long num = start + (n - 1) / digit;
        String a = (String.valueOf(num));
        return a.charAt((n - 1) % digit)-'0';


    }
}
