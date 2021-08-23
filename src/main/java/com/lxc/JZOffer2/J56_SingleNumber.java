package com.lxc.JZOffer2;

public class J56_SingleNumber {
    public int singleNumber(int[] nums) {
        int times[] = new int[32];
        for (int num : nums) {
            int mask = 1;
            int temp = num;
            for (int i = 0; i < 32; i++) {
                if ((temp & mask) == 1) {
                    times[i]++;
                }
                temp >>= 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (times[i]%3 == 1) {
                result = result | (1 << i);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new J56_SingleNumber().singleNumber(new int[]{1, 1, 6, 1}));
    }
}
