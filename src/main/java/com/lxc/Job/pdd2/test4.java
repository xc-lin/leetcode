package com.lxc.Job.pdd2;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int l = 0; l < T; l++) {
            scanner.nextLine();
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int[] opt = new int[n];
            if (n != 0) {
                scanner.nextLine();
                for (int i = 0; i < n; i++) {
                    opt[i] = scanner.nextInt();
                }
            }
            scanner.nextLine();
            for (int i = 0; i < m; i++) {
                int a = scanner.nextInt()-1;
                int b = scanner.nextInt()-1;
                for (int depth = 0; depth <n; depth++) {
                    switch (opt[depth]) {
                        case 1: {
                            if ((a - 1) >= 0) {
                                a--;
                            }
                            break;
                        }
                        case 2: {
                            if (b - 1 >= 0) {
                                b--;
                            }
                            break;
                        }
                        case 3: {
                            if (a + 1 < x) {
                                a++;
                            }
                            break;
                        }
                        case 4: {
                            if (b + 1 < y) {
                                b++;
                            }
                            break;
                        }
                    }
                }
                System.out.println((a + 1) + " " + (b + 1));
            }
        }
    }
}

/*
2
3 4 3 3
1 2 3
1 1
1 3
2 2
3 1
0 1 1 1
1 1


 */