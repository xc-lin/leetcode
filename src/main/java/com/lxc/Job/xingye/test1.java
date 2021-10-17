package com.lxc.Job.xingye;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int num =scanner.nextInt();
        System.out.print(num+"=");
        test1(num);
    }
    public static void test1(int num){
        int temp=num;
        for (int i = 2; i <temp/2 ; i++) {
            while (num%i==0&&num!=i){
                num/=i;
                System.out.print(i+"*");
            }
            if (num==i){
                System.out.print(num);
                break;
            }
        }
    }
}
