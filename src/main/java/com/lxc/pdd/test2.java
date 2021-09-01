package com.lxc.pdd;

import java.util.*;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = scanner.nextLine();
        }
        test2(strings);

    }

    public static void test2(String[] strings) {

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] o1s = o1.toCharArray();
                char[] o2s = o2.toCharArray();

                char tempc1[] = o1.toCharArray();
                for (int i = 0; i < o1.length() / 2; i++) {
                    if (tempc1[i] > tempc1[o1.length() - i - 1]) {
                        char k = tempc1[i];
                        tempc1[i] = tempc1[o1.length() - i - 1];
                        tempc1[o1.length() - i - 1] = k;
                    }
                }


                boolean flag = true;
                for (int i = 0; i < o1.length(); i++) {
                    if (i > o2.length()) {
                        break;
                    }
                    if (tempc1[i] < o2s[i] || tempc1[i] < o2s[o2.length() - i - 1]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return -1;
                }


                char tempc2[] = o2.toCharArray();
                for (int i = 0; i < o2.length() / 2; i++) {
                    if (tempc2[i] > tempc2[o2.length() - i - 1]) {
                        char k = tempc2[i];
                        tempc2[i] = tempc2[o2.length() - i - 1];
                        tempc2[o2.length() - i - 1] = k;
                    }
                }


                flag = true;
                for (int i = 0; i < o2.length(); i++) {
                    if (i > o1.length()) {
                        break;
                    }
                    if (tempc2[i] < o1s[i] || tempc2[i] < o1s[o2.length() - i - 1]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < strings.length; i++) {
            queue.offer(strings[i]);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
//1
//3 4 1
//5 2 3
//1 2 9 7