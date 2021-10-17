package com.lxc.Job.alibaba;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        if (nums[0] > c) {
            nums[0] = c;
        }
        System.out.print(nums[0]+" ");
        int pre = nums[0];
        for (int i = 1; i < n; i++) {
            int temp = nums[i] + pre;
            if (temp>c*(i+1)){
                temp = c*(i+1);
               nums[i] =  c*(i+1)- pre;
            }
            pre = temp;
            System.out.print(nums[i]+" ");
        }
    }
}
