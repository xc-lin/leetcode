package com.lxc.hostest;

public class L461_汉明距离 {
    public int hammingDistanceBest(int x, int y) {
        int temp = x ^ y;
        int count = 0;
        while (temp != 0) {
            temp=temp&(temp-1);
            count++;

        }
        return count;
    }

    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((temp & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
