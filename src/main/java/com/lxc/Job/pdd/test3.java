package com.lxc.Job.pdd;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            test3(n);
        }


    }

    public static void test3(int n) {
        int temp = 0;

        for (int i = 1; i < n; i++) {
            int value = 2 * i * (i + 1);
            if (n < value) {
                temp = i;
                break;
            } else if (n == value) {
                System.out.println(i * i);
                return;
            }
        }
        temp--;
        int count = temp * temp;
        if (temp == 0) {
            System.out.println(0);
        } else {
            int value = 2 * (temp) * (temp + 1);
            boolean flag = true;
            int c=0;
            while (n > value) {

                if (flag||c==temp) {
                    value += 3;
                    flag=false;
                } else {
                    value += 2;
                }
                count++;
                c++;
            }
            if (value!=n){
                count--;
            }
        }
        System.out.println(count);
    }
}
//1
//3 4 1
//5 2 3
//1 2 9 7