package com.lxc.Job.博乐科技;

import com.lxc.test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class test1 {

    public boolean OpenAllRoom(int[][] rooms) {
        HashSet<Integer> set = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>();
        boolean[] a = new boolean[rooms.length];
//        for (int i = 0; i < rooms[0].length; i++) {
        deque.add(0);
        set.add(0);
        a[0] = true;
//        }

        while (!deque.isEmpty()) {
            for (int i = deque.size() - 1; i >= 0; i--) {
                int key = deque.poll();
                a[key] = true;
                for (int j = 0; j < rooms[key].length; j++) {
                    if (set.add(rooms[key][j])) {
                        deque.add(rooms[key][j]);
                    }

                }
            }
        }
        for (int i = 0; i < rooms.length; i++) {
            if (!a[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new test1().OpenAllRoom(new int[][]{{1},{1,2},{2},{}}));
    }
}
