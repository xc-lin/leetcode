package com.lxc.JZOffer2;

public class J56_SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = temp ^ nums[i];
        }
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & temp) >> i == 1) {
                break;
            }
            mask <<= 1;
        }
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mask) == 0) {
                a = a ^ nums[i];
            } else {
                b = b ^ nums[i];
            }
        }
        return new int[]{a, b};

    }

    public static void main(String[] args) {
        System.out.println(new J56_SingleNumbers().singleNumbers(new int[]{4,1,4,6}));
    }

}
