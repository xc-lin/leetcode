package com.lxc.Job.lilisi;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class test3 {
    Queue<String>[] queues = new Queue[100];
    List<Integer> list = new LinkedList<>();

    {
        for (int i = 0; i < 100; i++) {
            queues[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        test3 t = new test3();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String opt = parts[0];
            String message = "";
            int type = Integer.parseInt(parts[1]) - 1;
            if (opt.equals("in")) {
                message = parts[2];
                t.in(type, message);
            } else {
                t.out(type);
            }
        }
    }

    public void in(int type, String message) {
        queues[type].offer(message);
        list.add(type);
    }

    public void out(int type) {
        if (list.isEmpty()) {
            System.out.println(-1);
            return;
        }
        if (type == -1) {
            int tempType = list.get(0);
            list.remove(0);
            System.out.println(queues[tempType].poll());
        } else {
            if (queues[type].isEmpty()) {
                System.out.println(-1);
                return;
            }
            String message = queues[type].poll();
            list.remove((Object) type);
//            for (int i = 0; i < list.size(); i++) {
//                if (list.get(i)==type){
//                    list.remove(i);
//                    break;
//                }
//            }
            System.out.println(message);
        }
    }

}
