package com.lxc.Job.Microsoft;

import java.util.Arrays;
import java.util.Comparator;

public class test2 {
    public static int solution(int N, int[] A, int[] B) {
        int M = A.length;
        Integer[] counts = new Integer[N];
        Arrays.fill(counts,0);
        for (int i = 0; i < M; i++){
            counts[A[i]-1]++;
            counts[B[i]-1]++;
        }
        Arrays.sort(counts, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int result=0;
        for (int i = 0; i < N; i++) {
            result+=(N-i)*counts[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(test2.solution(3,new int[]{3},new int[]{1}));
    }
}
