package com.lxc.Job.weBank;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
        }
        int[] result=new int[n];
        boolean even=true;
        for (int i = 0; i < n; i++) {
            if (i==0){
                result[0]=nums[0];
            }else if (even){
                even=false;
                result[i]=nums[i-1]-nums[i];
            }else {
                even=true;
                result[i]=nums[i]-nums[i-1];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
