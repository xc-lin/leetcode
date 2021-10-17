package com.lxc.Job.weBank;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();


        for (int i = 0; i < T; i++) {
            scanner.nextLine();
            double k = scanner.nextDouble();

            int length1 = (int) Math.pow(k, 1.0 / 3);
            int length2 = ((int) Math.pow(k, 1.0 / 4));
            int length3 = ((int) Math.pow(k, 1.0 / 5));
            boolean flag = true;
            int[] r3 = new int[length1+1];
            int[] r4 = new int[length2 + 1];
//            int[] r5 = new int[length3 + 1];
            calculate:
            for (int j = 1; j <= length3; j++) {
                int z;
                if (r3[j] != 0) {
                    z = r3[j] * j * j;
                } else {
                    z = (int) Math.pow(j, 5);
                }
                for (int l = 1; l <= length2; l++) {
                    int y;
                    if (r4[l] != 0) {
                        y = r4[l];
                    } else if (r3[l] != 0) {
                        y = r3[l] * l;
                    } else {
                        y = (int) Math.pow(l, 4);
                    }
                    r4[l] = y;
                    for (int m = 1; m <= length1; m++) {
                        int x;
                        if (r3[m] != 0) {
                            x = r3[m];
                        } else {
                            x = (int) Math.pow(m, 3);
                        }
                        r3[m] = x;
                        if (x + y + z == k) {
                            System.out.println("YES");
                            flag = false;
                            break calculate;
                        }
                    }
                }
            }
//            calculate:
//            for (int j = 1; j <= length1; j++) {
//                int x = (int) Math.pow(j, 3);
//                for (int l = 1; l <= length2; l++) {
//                    int y;
//                    if (l == j) {
//                        y = x * l;
//                    } else {
//                        y = (int) Math.pow(l, 4);
//                    }
//                    for (int m = 1; m <= length3; m++) {
//                        int z;
//                        if (m == l) {
//                            z = y * m;
//                        } else if (m == j) {
//                            z = x * m * m;
//                        } else {
//                            z = (int) Math.pow(m, 5);
//                        }
//                        if (x + y + z == k) {
//                            System.out.println("YES");
//                            flag = false;
//                            break calculate;
//                        }
//                    }
//                }
//            }
            if (flag) {
                System.out.println("NO");
            }
        }
    }
}
