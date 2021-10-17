package com.lxc.Job.广联达;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        scanner.nextLine();
        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();
        int x = 0;
        int y = 0;
        double result=0;
        for (int i = 0; i <= N; i++) {
            double tempX = i;
            double tempY = N - i;
            double a = tempX * a1 + tempY * a2;
            double b = tempX * b1 + tempY * b2;
            double sqrt = Math.sqrt(a * a + b * b);
            if (sqrt>result){
                result=sqrt;
                x= (int) tempX;
                y= (int) tempY;
            }

        }
        System.out.println(x+" "+y);
    }
}
