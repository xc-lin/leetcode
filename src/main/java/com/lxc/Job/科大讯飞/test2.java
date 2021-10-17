package com.lxc.Job.科大讯飞;

import java.util.*;

public class test2 {
    List<Integer> list = new ArrayList<>();
    int count = 0;
    int[] length;

    public int happyTriangle(int[] length) {
        this.length = length;
        dfs(0, 0);
        return count;
    }

    public void dfs(int depth, int k) {
        if (depth == 3) {
            List<Integer> temp=new LinkedList<>(list);
            temp.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            int a1 = temp.get(0);
            int a2 = temp.get(1);
            int a3 = temp.get(2);
            if (a1 == a2 && a2 == a3 && a1 == a3||(a1+a2<=a3)) {
                return;
            }
            if (a1 * a1 + a2 * a2 == a3 * a3) {
                return;
            }

            count++;
            return;
        }
        for (int i = k; i <= length.length - (3 - depth); i++) {
            list.add(length[i]);
//            System.out.println(list.toString());
            dfs(depth + 1, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new test2().happyTriangle(new int[]{5, 3, 4, 6, 6, 1}));
    }
}
