package com.lxc.Job.pdd2;

import java.util.Arrays;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
        }
        int[] temp=new int[n];
        for (int i = n-1; i >=0 ; i--) {
            int count=0;
            int k=0;
            while (count<nums[i]){
                if (temp[k]==0){
                    count++;
                }
                k++;
            }
            while (temp[k]==1){
                k++;
            }
            temp[k]=1;
            nums[i]=k;

        }
        for (int i = 0; i < n; i++) {
            System.out.print((nums[i]+1)+" ");
        }

    }
}
