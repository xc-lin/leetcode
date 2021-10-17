package com.lxc.Job.渤海银行;

import java.util.Scanner;

public class test2 {
    static int[] nums;
    static int count=0;
    static int result=0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        dfs(0,0,0);
        System.out.println(result);
    }

    public static void dfs(int index,int k,int last) {
        if (index> nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (k==0){
                if (count==1){
                    if (nums[i]%last!=0){
                        continue;
                    }
                    k=nums[i]/last;
                }
                count++;
                result=Math.max(count,result);
                dfs(i+1,k,nums[i]);
                k=0;
                count--;
            }else if (last*k==nums[i]){
                count++;
                result=Math.max(count,result);
                dfs(i+1,k,nums[i]);
                count--;
            }


        }
    }
}
