package com.lxc.Job.NetEase;

import java.util.Scanner;

public class test4 {

    int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strings[] = scanner.nextLine().split(" ");
        if (strings.length==1){
            System.out.println(1);
            return;
        }
        int ages[]=new int[strings.length];
        for (int i = 0; i <ages.length ; i++) {
            ages[i]=Integer.parseInt(strings[i]);
        }
        int opt[]= new int[ages.length];
        int min=0;
        for (int i = 0; i < ages.length ; i++) {
            if (i==0){
                if (ages[i]>ages[i+1]){
                    opt[i]=opt[i+1]+1;
                }else {
                    opt[i]=opt[i+1];
                }
                min=Math.min(min,opt[i]);
                continue;
            }
            if (i==ages.length-1){
                if (ages[i]>ages[i-1]){
                    opt[i]=opt[i-1]+1;
                }else {
                    opt[i]=opt[i-1];
                }
                min=Math.min(min,opt[i]);
                continue;
            }
            int temp=i-1;
            if (ages[i-1]<ages[i+1]){
                temp=i+1;
            }
            if (ages[temp]>ages[i]){
                opt[i]=opt[temp]+1;
            }else {
                opt[i]=opt[temp];
            }
            min=Math.min(min,opt[i]);
        }
        int result=0;
        min=1-min;
        for (int i:opt){
            result+=i+min;
        }
        System.out.println(result);

    }
}
