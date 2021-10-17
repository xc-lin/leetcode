package com.lxc.Job.meituan;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            scanner.nextLine();
            int a = scanner.nextInt();
            int m = scanner.nextInt();
            int y = scanner.nextInt();
            boolean flag = false;
            if (a==0&&y!=0){

            }else {
                for (int j = 0; j < m; j++) {
                    if (Math.pow(a, j) % m == y) {
                        flag = true;
                        System.out.println(j);
                    }
                }
            }
            if (!flag){
                System.out.println(-1);
            }
        }
    }
}
