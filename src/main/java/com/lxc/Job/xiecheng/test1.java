package com.lxc.Job.xiecheng;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split(" ");
            if (commands[0].equals("pwd")) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> iter = stack.descendingIterator();
                while (iter.hasNext()) {
                    sb.append("\\");
                    sb.append(iter.next());
                }
                if (sb.length() == 0) {
                    System.out.println("\\");
                } else {
                    System.out.println(sb.toString());
                }
            } else {
                if (commands[1].equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(commands[1]);
                }
            }
        }
    }
}
