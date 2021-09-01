package com.lxc.hostest;

import java.util.Arrays;
import java.util.Comparator;

public class L406_根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    // 因为前面空着的位置都是 给相同的数或者比自己大的数
                    // 因此需要让k大的数先占位置，然后再让k小的 取占掉前面的位置
                    return o2[1] - o2[1];
                }
            }
        });
        for (int[] i : people) {
            System.out.println(Arrays.toString(i));
        }
        int[][] result = new int[people.length][];
        for (int i = 0; i < people.length; i++) {
            int k = 0;
            int resultIndex = 0;
            while (k <= people[i][1]) {
                if (result[resultIndex] == null) {
                    k++;
                }
                resultIndex++;
            }
            result[resultIndex-1] = people[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new L406_根据身高重建队列().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}));
    }
}
