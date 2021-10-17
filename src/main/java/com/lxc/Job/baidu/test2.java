package com.lxc.Job.baidu;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            String num = scanner.nextLine();
            test(num);
            System.out.println();
        }
    }

    public static void test(String num) {
        char[] nums = num.toCharArray();
        int length = nums.length;
        int newLength = length;
        int diff = 0;
        for (int i = length - 1; i >= 0; i--) {
            nums[i] -= diff;
            if (diff > 0) {
                diff--;
            }

            if (nums[i] > '4') {
                nums[i] = '3';
            } else if (nums[i] == '4') {
                nums[i] = (char) (nums[i] - 1);
            } else if (nums[i] <= '0' && i > 0) {

                nums[i] = '3';
                diff++;
            }
        }
        boolean started = false;
        for (int i = 0; i < newLength; i++) {
            if (!started&&nums[i]=='0') {
                continue;
            }else {
                started=true;
            }
            System.out.print(nums[i]);
        }
    }
}
