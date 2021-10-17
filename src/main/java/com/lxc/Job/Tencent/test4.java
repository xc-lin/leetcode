package com.lxc.Job.Tencent;

import java.util.Scanner;


public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        char a[]=scanner.nextLine().toCharArray();
        test(a,n,k);
    }

    public static void test(char a[], int n,int k) {
        StringBuffer sb=new StringBuffer();
        int left=0;
        int right=n-k;
        int index=0;
        int max=a[0];
        while (k>0) {
            while (left <= right) {
                if (max < a[left]) {
                    max = a[left];
                    index = left;
                }
                left++;
            }
            k--;
            sb.append(a[index]);
            left=++index;
            if (left==n-k){
                sb.append(a,left,k);
                break;
            }


            max=a[left];
            right=n-k;
        }
        System.out.println(sb.toString());

    }
}
