package com.lxc.Job.烽火通信;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        if (n==0){
            System.out.println(0);
            return;
        }
        scanner.nextLine();
        String s=scanner.nextLine();
        char cs[]=s.toCharArray();
        int[] opt=new int[n];
        for (int i = 2; i < n; i++) {
            if (cs[i]=='1'&&cs[i-1]=='0'&&cs[i-2]=='1'){
                int temp=0;
                if(i-3>=0){
                    temp=opt[i-3];
                }
                opt[i]=temp+1;
            }else {
                opt[i]=opt[i-1];
            }

        }
        System.out.println(opt[n-1]);

    }
}
