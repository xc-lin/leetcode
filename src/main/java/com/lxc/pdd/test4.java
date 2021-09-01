package com.lxc.pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            scanner.nextLine();
            List<List<Integer>> matrix = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                matrix.add(new ArrayList<>());
            }
            for (int j = 0; j < N; j++) {
                int n = scanner.nextInt();
                for (int k = 0; k < n; k++) {
                    matrix.get(j).add(1);
                }

            }
            for (int j = 0; j < N; j++) {
                System.out.println(matrix.get(j).toString());
            }


        }

    }

    public static void test2(List<List<Integer>> matrix, int i,int j) {

    }
}
//1
//3 4 1
//5 2 3
//1 2 9 7