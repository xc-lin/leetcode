package com.lxc.medium.BitOperation;

public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int result = left;
        for (int i = left; i < right; i++) {
            result = result & ++left;
        }
        return result;

    }

    public int rangeBitwiseAndBest(int left, int right) {
        int shift = 0;
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            shift++;
        }
        return left << shift;

    }

    public int rangeBitwiseAnd2(int left, int right) {
        int mask = 1 << 31;
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            if ((left & mask) == (right & mask)) {
                result = result|(left & mask);
            }
            mask = mask >> 1;

        }
        return result;

    }
}
