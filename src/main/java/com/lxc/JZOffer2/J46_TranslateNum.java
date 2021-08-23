package com.lxc.JZOffer2;

public class J46_TranslateNum {
    public int translateNum(int num) {

        char nums[] = String.valueOf(num).toCharArray();
        int length = nums.length;
        int opt[] = new int[length + 1];
        opt[0] = 1;
        opt[1] = 1;
        for (int i = 1; i < length; i++) {
            if ((10 * (nums[i - 1] - '0') + nums[i] - '0' < 26) && (nums[i - 1] != '0')) {
                opt[i + 1] = opt[i] + opt[i - 1];
            } else {
                opt[i + 1] = opt[i];
            }
        }
        return opt[length];
    }

    public static void main(String[] args) {
        System.out.println(new J46_TranslateNum().translateNum(506));
    }
}
