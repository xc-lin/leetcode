package com.lxc.Job.baidu;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine();
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> tempList = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                tempList.add(scanner.nextInt());
            }
            lists.add(tempList);
            scanner.nextLine();
        }
        int[][] newOne = new int[N * K][N * K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = lists.get(i).get(j);
                for (int k = 0; k <K; k++) {
                    for (int l = 0; l < K; l++) {
                        newOne[i * K+k][j * K+l] = temp;
                    }
                }
            }
        }
        for (int i = 0; i < N * K; i++) {
            for (int j = 0; j < N * K; j++) {
                System.out.print(newOne[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }


    }
}
