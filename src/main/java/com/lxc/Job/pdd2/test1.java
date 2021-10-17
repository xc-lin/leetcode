package com.lxc.Job.pdd2;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        scanner.nextLine();
        nums[0]=scanner.nextInt();
        for (int i = 1; i < n; i++) {
            nums[i]=nums[i-1]+scanner.nextInt();
        }
        System.out.println(Arrays.toString(nums));
        int m=scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            int b=scanner.nextInt();
            int left=0;
            int right=n-1;
            while (left<=right){
                int mid=(left+right)/2;
                if (nums[mid]>b){
                    right=mid-1;
                }else if (nums[mid]==b){
                    left=mid;
                    break;
                }else {
                    left=mid+1;
                }
            }
            System.out.println(left+1);
        }




    }
}
