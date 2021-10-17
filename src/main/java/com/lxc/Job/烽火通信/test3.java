package com.lxc.Job.烽火通信;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        char c11[]=scanner.nextLine().toCharArray();
        char c22[]=scanner.nextLine().toCharArray();
        int c1[]=new int[c11.length];
        int c2[]=new int[c22.length];
        for (int i = 0; i < c11.length; i++) {
            c1[i]=c11[i];
            c2[i]=c22[i];
        }
        int count=0;
        for (int i = 0; i < c1.length; i++) {
            int x=c2[i]-c1[i];
            c1[i]=c2[i];
            if (x!=0){
                c1[i+1]-=x;
                count++;
            }

        }
        System.out.println(count);
    }
}
