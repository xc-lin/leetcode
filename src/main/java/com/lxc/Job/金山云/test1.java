package com.lxc.Job.金山云;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> lists = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            int[] temp = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                temp[j] = scanner.nextInt();
            }
            lists.add(temp);
        }
        int opt[][] = new int[n][n];
        opt[0][0]= lists.get(0)[0];
        int result=0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < lists.get(i).length; j++) {
                if (j == i) {
                    opt[i][j]=opt[i][j-1]+lists.get(i)[j];
                }else if (j-1<0){
                    opt[i][j]=opt[i-1][j]+lists.get(i)[j];
                }else if (i==n-1){
                    opt[i][j]=opt[i-1][j]+lists.get(i)[j];
                    result=Math.max(opt[i][j],result);
                }else {
                    opt[i][j]=Math.max(opt[i-1][j],opt[i][j-1])+lists.get(i)[j];
                }

            }
        }
        System.out.println(result);

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(lists.get(i)));
//        }
    }
}
