package com.lxc.Job.jd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();
        int[] weight = new int[n];
        int count=1;
        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
        }
        Arrays.sort(weight);
        for (int i = 1; i <n; i++) {
            if (weight[i] - weight[i - 1] > x) {
                if (k>0){
                    k--;
                }else {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
