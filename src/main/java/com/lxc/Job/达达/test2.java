package com.lxc.Job.达达;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        int n =new Scanner(System.in).nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j||i+j==n-1){
                    System.out.print("x");
                }else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }
}
